package de.macbrayne.fabriclegacy.inventorypause.utils;


import com.moandjiezana.toml.Toml;
import com.moandjiezana.toml.TomlWriter;
import de.macbrayne.forge.inventorypause.compat.ScreenDictionary;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.IOException;

public class Reference {
    private static ModConfig config = new ModConfig();
    private static final ScreenDictionary vanillaScreenDictionary = new ScreenDictionary();

    static {
        File configFile = new File(FabricLoader.getInstance().getConfigDir().toFile(), "inventorypause.toml");
        try {
            if (configFile.exists())
                config = new Toml().read(configFile).to(ModConfig.class);
            else
                new TomlWriter().write(new ModConfig(), configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ModConfig getConfig() {
        return config;
    }

    public static ScreenDictionary getScreenDictionary() {
        return vanillaScreenDictionary;
    }
}