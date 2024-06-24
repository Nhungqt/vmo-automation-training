package com.vmo.demowebshop.driverFactory.localFactory;

import com.vmo.demowebshop.driverFactory.IBrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManagement implements IBrowserFactory {
    @Override
    public WebDriver getBrowserDriver() {
        return new EdgeDriver();
    }
}
