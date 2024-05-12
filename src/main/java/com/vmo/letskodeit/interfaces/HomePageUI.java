package com.vmo.letskodeit.interfaces;

import static com.vmo.letskodeit.common.Locator.css;
import static com.vmo.letskodeit.common.Locator.xpath;

public class HomePageUI {
    public static final String USERNAME_TXT = xpath("//input[@id='username']");
    public static final String PASSWORD_TXT = css("#password");
}
