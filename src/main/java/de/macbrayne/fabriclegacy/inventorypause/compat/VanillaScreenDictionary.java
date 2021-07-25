package de.macbrayne.fabriclegacy.inventorypause.compat;

import net.minecraft.client.gui.screen.container.*;
import net.minecraft.container.ChestContainer;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BooleanSupplier;

public class VanillaScreenDictionary {
    private final Class<?>[] vanillaClasses;
    private final Map<Class<? extends ContainerScreen>, BooleanSupplier> configProviderMap = new HashMap<>(14);

    public VanillaScreenDictionary() {
        // Abilities Screen top layer
        configProviderMap.put(CraftingScreen.class, () -> true);
        configProviderMap.put(DispenserScreen.class, () -> true);
        configProviderMap.put(DoubleChestScreen.class, () -> true);
        configProviderMap.put(FurnaceScreen.class, () -> true);
        configProviderMap.put(PlayerInventoryScreen.class, () -> true);

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
