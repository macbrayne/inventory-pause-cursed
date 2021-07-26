package de.macbrayne.fabriclegacy.inventorypause.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import de.macbrayne.fabriclegacy.inventorypause.common.ModConfig;
import de.macbrayne.fabriclegacy.inventorypause.compat.VanillaScreenDictionary;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Reference {
    private static ModConfig config = new ModConfig();
    private static final VanillaScreenDictionary vanillaScreenDictionary = new VanillaScreenDictionary();

    static {
        Path configPath = Paths.get("config/inventorypause.json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            if(configPath.toFile().exists()) {
                config = gson.fromJson(new String(Files.readAllBytes(configPath)), ModConfig.class);
                System.out.println(config.abilities.pauseCraftingTable);
            }
            Files.write(configPath, gson.toJson(config).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ModConfig getConfig() {
        return config;
    }

    public static VanillaScreenDictionary getVanillaScreenDictionary() {
        return vanillaScreenDictionary;
    }
}
