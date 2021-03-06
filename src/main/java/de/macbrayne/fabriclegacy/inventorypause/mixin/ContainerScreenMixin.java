package de.macbrayne.fabriclegacy.inventorypause.mixin;

import de.macbrayne.fabriclegacy.inventorypause.common.ScreenHelper;
import net.minecraft.client.gui.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(net.minecraft.client.gui.screen.container.ContainerScreen.class)
public class ContainerScreenMixin {
    @Inject(method = "isPauseScreen", at = @At("HEAD"), cancellable = true)
    public void isPauseScreen(CallbackInfoReturnable<Boolean> cir) {
        if(ScreenHelper.isConfiguredScreen((Screen) (Object) this)) {
            cir.setReturnValue(true);
            cir.cancel();
        }
    }
}
