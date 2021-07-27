package de.macbrayne.fabriclegacy.inventorypause.compat;

import de.macbrayne.fabriclegacy.inventorypause.utils.Reference;
import net.minecraft.client.gui.screen.ingame.*;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BooleanSupplier;

public class VanillaScreenDictionary {
    private final Class<?>[] vanillaClasses;
    private final Map<Class<?>, BooleanSupplier> configProviderMap = new HashMap<>(14);

    public VanillaScreenDictionary() {
        // Abilities Screen top layer
        configProviderMap.put(InventoryScreen.class, () -> Reference.getConfig().abilities.pauseInventory);
        configProviderMap.put(CreativeInventoryScreen.class, () -> Reference.getConfig().abilities.pauseCreativeInventory);
        configProviderMap.put(FurnaceScreen.class, () -> Reference.getConfig().abilities.pauseFurnace);
        configProviderMap.put(CraftingTableScreen.class, () -> Reference.getConfig().abilities.pauseCraftingTable);
        configProviderMap.put(ShulkerBoxScreen.class, () -> Reference.getConfig().abilities.pauseShulkerBox);
        configProviderMap.put(GenericContainerScreen.class, () -> Reference.getConfig().abilities.pauseChest);

        // Additional GUIs
        configProviderMap.put(AnvilScreen.class, () -> Reference.getConfig().abilities.additionalGUIs.pauseAnvil);
        configProviderMap.put(BeaconScreen.class, () -> Reference.getConfig().abilities.additionalGUIs.pauseBeacon);
        configProviderMap.put(Generic3x3ContainerScreen.class, () -> Reference.getConfig().abilities.additionalGUIs.pauseDispenser);
        configProviderMap.put(BrewingStandScreen.class, () -> Reference.getConfig().abilities.additionalGUIs.pauseBrewingStand);
        configProviderMap.put(HopperScreen.class, () -> Reference.getConfig().abilities.additionalGUIs.pauseHopper);

        // World GUIs
        configProviderMap.put(HorseScreen.class, () -> Reference.getConfig().abilities.worldGUIs.pauseHorse);
        configProviderMap.put(MerchantScreen.class, () -> Reference.getConfig().abilities.worldGUIs.pauseMerchant);

        // Cache keySet to improve performance
        vanillaClasses = configProviderMap.keySet().toArray(new Class[0]);

    }

    public boolean handleScreen(@Nonnull Class<?> screenClass) {
        Optional<Class<?>> registeredParentClass = getRegisteredParentClass(screenClass);
        return registeredParentClass.filter(aClass -> configProviderMap.get(aClass).getAsBoolean()).isPresent();
    }

    private Optional<Class<?>> getRegisteredParentClass(@Nonnull Class<?> screenClass) {
        return Arrays.stream(vanillaClasses).filter((vanillaClass -> vanillaClass.isAssignableFrom(screenClass))).findFirst();
    }

}
