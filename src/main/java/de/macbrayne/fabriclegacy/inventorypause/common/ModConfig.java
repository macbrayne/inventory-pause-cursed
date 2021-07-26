package de.macbrayne.fabriclegacy.inventorypause.common;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("CanBeFinal")
// @Config(name = "inventorypause")
public class ModConfig /*implements ConfigData*/ {
    public boolean enabled = true;
    public boolean disableSaving = false;
    public boolean debug = false;

    // @ConfigEntry.Gui.CollapsibleObject
    public DebugText debugText = new DebugText();

    public static class DebugText {
        public float x = 4f;
        public float y = 4f;
        public int maxDepth = 3;
    }

    // @ConfigEntry.Category("abilities")
    // @ConfigEntry.Gui.TransitiveObject
    public Abilities abilities = new Abilities();

    // @ConfigEntry.Category("modCompat")
    // @ConfigEntry.Gui.TransitiveObject
    public ModCompat modCompat = new ModCompat();

    public static class Abilities {
        public static class AdditionalGUIs {
            public boolean pauseAnvil = false;
            public boolean pauseBeacon = false;
            public boolean pauseDispenser = false;
            public boolean pauseBrewingStand = false;
        }

        public static class WorldGUIs {
            public boolean pauseHorse = false;
            public boolean pauseMerchant = false;
        }

        public boolean pauseInventory = true;
        public boolean pauseCreativeInventory = true;
        public boolean pauseCraftingTable = false;
        public boolean pauseFurnace = false;
        public boolean pauseShulkerBox = false;
        public boolean pauseChest = false;
        // @ConfigEntry.Gui.CollapsibleObject
        public
        WorldGUIs worldGUIs = new WorldGUIs();
        // @ConfigEntry.Gui.CollapsibleObject
        public
        AdditionalGUIs additionalGUIs = new AdditionalGUIs();
    }

    public static class ModCompat {
        List<String> customScreens = new ArrayList<>();
    }
}