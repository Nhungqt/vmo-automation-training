package com.vmo.letskodeit.driverFactory.localFactory;

import org.openqa.selenium.WebDriver;

public class LocalFactory {
    private WebDriver driver;
    public WebDriver createDriver(String browser){
        browser = browser.toUpperCase();
        switch (browser){
            case "CHROME":
                driver = new ChromeDriverManagement().getBrowserDriver;
            case "H_CHROME":
                driver = new ChromeHealessDriverManagement().getBrowserDriver;
            case "FIREFOX":
                driver = new FirefoxDriverManagement().getBrowserDriver;
            case "EDGE":
                driver = new EdgeDriverManagement().getBrowserDriver;
            default:
                throw new RuntimeException("Not support browser "+browser);
        }
        return driver;

    }
}
