package de.macbrayne.fabriclegacy.inventorypause.mixin;

import de.macbrayne.fabriclegacy.inventorypause.common.ScreenHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.sound.SoundManager;
import net.minecraft.server.integrated.IntegratedServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.annotation.Nullable;

@Mixin(MinecraftClient.class)
public abstract class MinecraftMixin {
    @Shadow public abstract SoundManager getSoundManager();
    @Shadow public abstract boolean isIntegratedServerRunning();
    @Shadow private @Nullable IntegratedServer server;

    @Inject(at = @At("TAIL"), method = "openScreen")
    public void openScreen(@Nullable Screen screen, CallbackInfo ci) {
        if (ScreenHelper.isConfiguredScreen(screen))
        {
            boolean canPauseGame = isIntegratedServerRunning() && !this.server.isDedicated();
            if(canPauseGame) {
                this.getSoundManager().pauseAll();
            }
        }
    }

}
