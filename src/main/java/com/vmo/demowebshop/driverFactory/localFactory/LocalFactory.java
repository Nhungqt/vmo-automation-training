package com.vmo.demowebshop.driverFactory.localFactory;

import com.vmo.demowebshop.driverFactory.localFactory.ChromeDriverManagement;
import com.vmo.demowebshop.driverFactory.localFactory.ChromeHeadlessDriverManagement;
import com.vmo.demowebshop.driverFactory.localFactory.EdgeDriverManagement;
import com.vmo.demowebshop.driverFactory.localFactory.FirefoxDriverManagement;
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
