package de.macbrayne.fabriclegacy.inventorypause.compat;

import de.macbrayne.fabriclegacy.inventorypause.utils.Reference;
import de.macbrayne.forge.inventorypause.compat.ScreenDictionary;
import net.minecraft.client.gui.screen.ingame.*;

public class VanillaCompat {
    ScreenDictionary screenDictionary = Reference.getScreenDictionary();

    public void register() {
        // Abilities Screen top layer
        screenDictionary.register(InventoryScreen.class, () -> Reference.getConfig().abilities.pauseInventory);
        screenDictionary.register(CreativeInventoryScreen.class, () -> Reference.getConfig().abilities.pauseCreativeInventory);
        screenDictionary.register(FurnaceScreen.class, () -> Reference.getConfig().abilities.pauseFurnace);
        screenDictionary.register(CraftingTableScreen.class, () -> Reference.getConfig().abilities.pauseCraftingTable);
        screenDictionary.register(ShulkerBoxScreen.class, () -> Reference.getConfig().abilities.pauseShulkerBox);
        screenDictionary.register(GenericContainerScreen.class, () -> Reference.getConfig().abilities.pauseChest);

        // Additional GUIs
        screenDictionary.register(AnvilScreen.class, () -> Reference.getConfig().abilities.additionalGUIs.pauseAnvil);
        screenDictionary.register(BeaconScreen.class, () -> Reference.getConfig().abilities.additionalGUIs.pauseBeacon);
        screenDictionary.register(Generic3x3ContainerScreen.class, () -> Reference.getConfig().abilities.additionalGUIs.pauseDispenser);
        screenDictionary.register(BrewingStandScreen.class, () -> Reference.getConfig().abilities.additionalGUIs.pauseBrewingStand);
        screenDictionary.register(HopperScreen.class, () -> Reference.getConfig().abilities.additionalGUIs.pauseHopper);

        // World GUIs
        screenDictionary.register(HorseScreen.class, () -> Reference.getConfig().abilities.worldGUIs.pauseHorse);
        screenDictionary.register(MerchantScreen.class, () -> Reference.getConfig().abilities.worldGUIs.pauseMerchant);
    }
}
