package de.macbrayne.fabriclegacy.inventorypause;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import de.macbrayne.fabriclegacy.inventorypause.compat.VanillaCompat;
import io.github.minecraftcursedlegacy.api.config.Configs;
import io.github.minecraftcursedlegacy.api.registry.Id;
import net.fabricmc.api.ModInitializer;
import tk.valoeghese.zoesteriaconfig.api.container.WritableConfig;
import tk.valoeghese.zoesteriaconfig.api.template.ConfigTemplate;

public class InventoryPause implements ModInitializer {
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		try {
			config = Configs.loadOrCreate(new Id("inventorypause", "inventorypause"),
					ConfigTemplate.builder()
							.addDataEntry("enabled", true)
							.addContainer("abilities", container -> container.addDataEntry("craftingScreen", true)
									.addDataEntry("dispenserScreen", true)
									.addDataEntry("doubleChestScreen", true)
									.addDataEntry("furnaceScreen", false)
									.addDataEntry("playerInventoryScreen", true))
							.build());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		new VanillaCompat().register();
	}

	private static WritableConfig config;

	public static WritableConfig getConfig() {
		return config;
	}

	public static boolean isModEnabled() {
		return config.getBooleanValue("enabled");
	}
}
