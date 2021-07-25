package de.macbrayne.fabriclegacy.inventorypause.common;

import de.macbrayne.fabriclegacy.inventorypause.compat.VanillaScreenDictionary;
import de.macbrayne.fabriclegacy.inventorypause.utils.Reference;
import net.minecraft.client.gui.Screen;

import javax.annotation.Nullable;

public class ScreenHelper {
    private static final VanillaScreenDictionary vanillaDictionary = Reference.getVanillaScreenDictionary();

    public static boolean isConfiguredScreen(@Nullable Screen screen) {
        return screen != null && vanillaDictionary.handleScreen(screen.getClass());
    }
}
