package de.macbrayne.fabriclegacy.inventorypause.utils;


import de.macbrayne.forge.inventorypause.compat.ScreenDictionary;

public class Reference {
    private static final ScreenDictionary vanillaScreenDictionary = new ScreenDictionary();

    public static ScreenDictionary getScreenDictionary() {
        return vanillaScreenDictionary;
    }
}