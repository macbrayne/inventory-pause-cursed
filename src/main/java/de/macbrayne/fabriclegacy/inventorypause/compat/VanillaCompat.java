package de.macbrayne.fabriclegacy.inventorypause.compat;

import de.macbrayne.fabriclegacy.inventorypause.utils.ModConfig;
import de.macbrayne.fabriclegacy.inventorypause.utils.Reference;
import de.macbrayne.forge.inventorypause.compat.ScreenDictionary;
import net.minecraft.client.gui.screen.container.*;

public class VanillaCompat {
    private final ModConfig config = Reference.getConfig();
    private final ScreenDictionary screenDictionary = Reference.getScreenDictionary();

    public void register() {
        // Abilities Screen top layer
        screenDictionary.register(CraftingScreen.class, () -> config.enabled &&
                config.abilities.craftingScreen);
        screenDictionary.register(DispenserScreen.class, () -> config.enabled &&
                config.abilities.dispenserScreen);
        screenDictionary.register(DoubleChestScreen.class, () -> config.enabled &&
                config.abilities.doubleChestScreen);
        screenDictionary.register(FurnaceScreen.class, () -> config.enabled &&
                config.abilities.furnaceScreen);
        screenDictionary.register(PlayerInventoryScreen.class, () -> config.enabled &&
                config.abilities.playerInventoryScreen);
    }
}
