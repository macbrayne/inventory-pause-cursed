package de.macbrayne.fabriclegacy.inventorypause;

import de.macbrayne.fabriclegacy.inventorypause.common.ModConfig;
import net.fabricmc.api.ModInitializer;

public class InventoryPause implements ModInitializer {
	public static ModConfig MOD_CONFIG = new ModConfig();

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		System.out.println("Hello Fabric world!");
	}
}
