package de.macbrayne.fabriclegacy.inventorypause.compat;

import de.macbrayne.fabriclegacy.inventorypause.InventoryPause;
import net.minecraft.client.gui.screen.container.*;
import tk.valoeghese.zoesteriaconfig.api.container.WritableConfig;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BooleanSupplier;

public class VanillaScreenDictionary {
    private final Class<?>[] vanillaClasses;
    private final Map<Class<?>, BooleanSupplier> configProviderMap = new HashMap<>(14);
    private final WritableConfig config = InventoryPause.getConfig();

    public VanillaScreenDictionary() {
        // Abilities Screen top layer
        configProviderMap.put(CraftingScreen.class, () -> InventoryPause.isModEnabled() &&
                config.getBooleanValue("abilities.craftingScreen"));
        configProviderMap.put(DispenserScreen.class, () -> InventoryPause.isModEnabled() &&
                config.getBooleanValue("abilities.dispenserScreen"));
        configProviderMap.put(DoubleChestScreen.class, () -> InventoryPause.isModEnabled() &&
                config.getBooleanValue("abilities.doubleChestScreen"));
        configProviderMap.put(FurnaceScreen.class, () -> InventoryPause.isModEnabled() &&
                config.getBooleanValue("abilities.furnaceScreen"));
        configProviderMap.put(PlayerInventoryScreen.class, () -> InventoryPause.isModEnabled() &&
                config.getBooleanValue("abilities.playerInventoryScreen"));;

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
