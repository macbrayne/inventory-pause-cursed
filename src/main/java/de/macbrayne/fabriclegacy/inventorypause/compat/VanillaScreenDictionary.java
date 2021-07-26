package de.macbrayne.fabriclegacy.inventorypause.compat;

import de.macbrayne.fabriclegacy.inventorypause.common.ModConfig;
import net.minecraft.client.gui.screen.ingame.*;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BooleanSupplier;

public class VanillaScreenDictionary {
    private final ModConfig config = new ModConfig();
    private final Class<?>[] vanillaClasses;
    private final Map<Class<?>, BooleanSupplier> configProviderMap = new HashMap<>(14);

    public VanillaScreenDictionary() {
        // Abilities Screen top layer
        configProviderMap.put(InventoryScreen.class, () -> config.abilities.pauseInventory);
        configProviderMap.put(CreativeInventoryScreen.class, () -> config.abilities.pauseCreativeInventory);
        configProviderMap.put(FurnaceScreen.class, () -> config.abilities.pauseFurnace);
        configProviderMap.put(CraftingTableScreen.class, () -> config.abilities.pauseCraftingTable);
        configProviderMap.put(ShulkerBoxScreen.class, () -> config.abilities.pauseShulkerBox);
        configProviderMap.put(GenericContainerScreen.class, () -> config.abilities.pauseChest);

        // Additional GUIs
        configProviderMap.put(AnvilScreen.class, () -> config.abilities.additionalGUIs.pauseAnvil);
        configProviderMap.put(BeaconScreen.class, () -> config.abilities.additionalGUIs.pauseBeacon);
        configProviderMap.put(Generic3x3ContainerScreen.class, () -> config.abilities.additionalGUIs.pauseDispenser);
        configProviderMap.put(BrewingStandScreen.class, () -> config.abilities.additionalGUIs.pauseBrewingStand);

        // World GUIs
        configProviderMap.put(HorseScreen.class, () -> config.abilities.worldGUIs.pauseHorse);
        configProviderMap.put(MerchantScreen.class, () -> config.abilities.worldGUIs.pauseMerchant);

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
