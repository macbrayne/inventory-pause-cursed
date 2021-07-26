package de.macbrayne.fabriclegacy.inventorypause.common;

import de.macbrayne.fabriclegacy.inventorypause.compat.VanillaScreenDictionary;
import de.macbrayne.fabriclegacy.inventorypause.utils.Reference;
import net.minecraft.client.gui.screen.Screen;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ScreenHelper {
    private static final ModConfig config = new ModConfig();
    private static final VanillaScreenDictionary vanillaDictionary = Reference.getVanillaScreenDictionary();

    public static boolean isConfiguredScreen(@Nullable Screen screen) {
        return screen != null && config.enabled && (vanillaDictionary.handleScreen(screen.getClass()) ||
                isCustomMenu(screen));
    }

    private static boolean isCustomMenu(@Nonnull Screen screen) {
        for (String s : config.modCompat.customScreens) {
            if(screen.getClass().getName().equals(s)) {
                return true;

            }
        }
        return false;
    }
}
