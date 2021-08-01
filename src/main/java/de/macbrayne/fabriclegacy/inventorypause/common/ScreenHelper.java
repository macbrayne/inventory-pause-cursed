package de.macbrayne.fabriclegacy.inventorypause.common;

import de.macbrayne.fabriclegacy.inventorypause.utils.Reference;
import de.macbrayne.forge.inventorypause.compat.ScreenDictionary;
import net.minecraft.client.gui.screen.Screen;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ScreenHelper {
    private static final ScreenDictionary SCREEN_DICTIONARY = Reference.getScreenDictionary();

    public static boolean isConfiguredScreen(@Nullable Screen screen) {
        return screen != null && Reference.getConfig().enabled && (SCREEN_DICTIONARY.handleScreen(screen.getClass()) ||
                isCustomMenu(screen));
    }

    private static boolean isCustomMenu(@Nonnull Screen screen) {
        for (String s : Reference.getConfig().modCompat.customScreens) {
            if(screen.getClass().getName().equals(s)) {
                return true;

            }
        }
        return false;
    }
}
