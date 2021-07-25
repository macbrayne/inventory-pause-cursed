package de.macbrayne.fabriclegacy.inventorypause.utils;

import de.macbrayne.fabriclegacy.inventorypause.compat.VanillaScreenDictionary;

public class Reference {
    private static final VanillaScreenDictionary vanillaScreenDictionary = new VanillaScreenDictionary();

    public static VanillaScreenDictionary getVanillaScreenDictionary() {
        return vanillaScreenDictionary;
    }
}