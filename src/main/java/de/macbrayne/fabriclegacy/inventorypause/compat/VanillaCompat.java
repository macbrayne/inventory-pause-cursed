package de.macbrayne.fabriclegacy.inventorypause.compat;

import de.macbrayne.fabriclegacy.inventorypause.InventoryPause;
import de.macbrayne.fabriclegacy.inventorypause.utils.Reference;
import de.macbrayne.forge.inventorypause.compat.ScreenDictionary;
import net.minecraft.client.gui.screen.container.*;
import tk.valoeghese.zoesteriaconfig.api.container.WritableConfig;

public class VanillaCompat {
    private final WritableConfig config = InventoryPause.getConfig();
    private final ScreenDictionary screenDictionary = Reference.getScreenDictionary();

    public void register() {
        // Abilities Screen top layer
        screenDictionary.register(CraftingScreen.class, () -> InventoryPause.isModEnabled() &&
                config.getBooleanValue("abilities.craftingScreen"));
        screenDictionary.register(DispenserScreen.class, () -> InventoryPause.isModEnabled() &&
                config.getBooleanValue("abilities.dispenserScreen"));
        screenDictionary.register(DoubleChestScreen.class, () -> InventoryPause.isModEnabled() &&
                config.getBooleanValue("abilities.doubleChestScreen"));
        screenDictionary.register(FurnaceScreen.class, () -> InventoryPause.isModEnabled() &&
                config.getBooleanValue("abilities.furnaceScreen"));
        screenDictionary.register(PlayerInventoryScreen.class, () -> InventoryPause.isModEnabled() &&
                config.getBooleanValue("abilities.playerInventoryScreen"));;
    }
}
