package com.vmo.letskodeit.interfaces;

import static com.vmo.letskodeit.common.Locator.xpath;

public class PracticePageUI {

    public static final String BMW_CHECKBOX = xpath("//legend[text()='Checkbox Example']/following-sibling::label[@for='bmw']//input[@id='bmwcheck']");
    public static final String BENZ_CHECKBOX = xpath("//legend[text()='Checkbox Example']/following-sibling::label[@for='benz']//input[@id='benzcheck']");
    public static final String HONDA_RADIO = xpath("//legend[text()='Radio Button Example']/following-sibling::label[@for='honda']//input[@id='hondaradio']");
    public static final String BENZ_RADIO = xpath("//legend[text()='Radio Button Example']/following-sibling::label[@for='benz']//input[@id='benzradio']");
    public static final String STATUS_BUTTON = xpath("//input[@placeholder='Enabled/Disabled Field']");
    public static final String ENABLE_BUTTON = xpath("//legend[text()='Enabled/Disabled Example']/following-sibling::input[@id='enabled-button']");
    public static final String DISABLE_BUTTON = xpath("//legend[text()='Enabled/Disabled Example']/following-sibling::input[@id='disabled-button']");

    //  Study on class
    // 1. Dynamic locator
    public static final String DYNAMIC_LOCATOR = "//legend[text()='Checkbox Example']/following-sibling::label[@for='%s']//input[@id='%s']";
}

