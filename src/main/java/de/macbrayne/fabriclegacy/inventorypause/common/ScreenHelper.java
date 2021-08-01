package de.macbrayne.fabriclegacy.inventorypause.common;

import de.macbrayne.fabriclegacy.inventorypause.utils.Reference;
import de.macbrayne.forge.inventorypause.compat.ScreenDictionary;
import net.minecraft.client.gui.Screen;

import javax.annotation.Nullable;

public class ScreenHelper {
    private static final ScreenDictionary SCREEN_DICTIONARY = Reference.getScreenDictionary();

    public static boolean isConfiguredScreen(@Nullable Screen screen) {
        return screen != null && SCREEN_DICTIONARY.handleScreen(screen.getClass());
    }
}
