package com.vmo.demowebshop.common;

import com.vmo.demowebshop.common.Prefix;

public class Locator {
    public static String id(String locator) {
        return com.vmo.demowebshop.common.Prefix.ID + locator;
    }

    public static String name(String locator) {
        return com.vmo.demowebshop.common.Prefix.NAME + locator;
    }

    public static String className(String locator) {
        return com.vmo.demowebshop.common.Prefix.CLASSNAME + locator;
    }

    public static String xpath(String locator) {
        return com.vmo.demowebshop.common.Prefix.XPATH + locator;
    }

    public static String css(String locator) {
        return Prefix.CSS + locator;
    }
}
