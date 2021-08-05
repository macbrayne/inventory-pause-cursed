package de.macbrayne.fabriclegacy.inventorypause.utils;

public class ModConfig {
    public boolean enabled = true;
    public Abilities abilities = new Abilities();

    public static class Abilities {
        public boolean dispenserScreen = true;
        public boolean doubleChestScreen = false;
        public boolean craftingScreen = false;
        public boolean furnaceScreen = false;
        public boolean playerInventoryScreen = true;
    }
}
