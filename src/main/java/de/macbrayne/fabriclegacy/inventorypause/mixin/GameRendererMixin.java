package de.macbrayne.fabriclegacy.inventorypause.mixin;

import de.macbrayne.fabriclegacy.inventorypause.common.ModConfig;
import de.macbrayne.fabriclegacy.inventorypause.utils.Reference;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
    @Shadow @Final private MinecraftClient client;

    @Inject(method = "method_30211", /*at = @At(value = "INVOKE", target = "")*/ at = @At("TAIL"))
    public void method_30211(float f, long l, CallbackInfo ci) {
        ModConfig modConfig = Reference.getConfig();
        Screen screen = client.currentScreen;
        if(screen != null && modConfig.debug) {
            int line = 0;
            for (Class<?> cl = screen.getClass(); cl.getSuperclass() != null && line < modConfig.debugText.maxDepth; cl = cl.getSuperclass()) {
                MinecraftClient.getInstance().textRenderer.drawWithShadow(cl.getName(), modConfig.debugText.x, modConfig.debugText.y + 10 * line, 0xffffffff);
                line++;
            }
        }
    }
}
