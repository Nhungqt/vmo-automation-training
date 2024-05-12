package com.vmo.letskodeit.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    public static String getDynamicLocator(String locator, String...value){
        return String.format(locator,(Object[]) value);
    }
    public void clickToElementDynamic(WebDriver driver, String locator, String...value){
        driver.findElement(By.xpath(getDynamicLocator(locator,value))).click();
    }
    protected WebElement getWebElement(WebDriver driver, String locator){
        return driver.findElement(By.xpath(locator));
    }
    protected void clickToElement(WebDriver driver, String locator){
        getWebElement(driver,locator).click();
        }
    protected void senkeyToElement(WebDriver driver, String locator, String value){
        WebElement element = getWebElement(driver,locator);
        element.clear();
        element.sendKeys(value);
    }
    public boolean isElementSelected(WebDriver driver, String locator){
        return getWebElement(driver,locator).isSelected();
    }
    public boolean isElementEnable (WebDriver driver, String locator){
        return getWebElement(driver,locator).isEnabled();
    }
}
