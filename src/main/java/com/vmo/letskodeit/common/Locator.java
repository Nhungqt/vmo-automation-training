package com.vmo.letskodeit.common;

public class Locator {
    public static String id(String locator) {
        return Prefix.ID + locator;
    }

    public static String name(String locator) {
        return Prefix.NAME + locator;
    }

    public static String className(String locator) {
        return Prefix.CLASSNAME + locator;
    }

    public static String xpath(String locator) {
        return Prefix.XPATH + locator;
    }

    public static String css(String locator) {
        return Prefix.CSS + locator;
    }
}
