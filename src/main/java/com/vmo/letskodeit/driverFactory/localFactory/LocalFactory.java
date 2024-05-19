package com.vmo.letskodeit.driverFactory.localFactory;

import org.openqa.selenium.WebDriver;

public class LocalFactory {
    private WebDriver driver;
    public WebDriver createDriver(String browser){
        browser = browser.toUpperCase();
        switch (browser){
            case "CHROME":
                driver = new ChromeDriverManagement().getBrowserDriver();
                break;
            case "H_CHROME":
                driver = new ChromeHeadlessDriverManagement().getBrowserDriver();
                break;
            case "FIREFOX":
                driver = new FirefoxDriverManagement().getBrowserDriver();
                break;
            case "EDGE":
                driver = new EdgeDriverManagement().getBrowserDriver();
                break;
            default:
                throw new RuntimeException("Not support browser "+browser);
        }
        return driver;
    }
}
