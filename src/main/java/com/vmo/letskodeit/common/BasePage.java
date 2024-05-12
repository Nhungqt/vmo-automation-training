package com.vmo.letskodeit.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class BasePage {
    public static String getDynamicLocator(String locator, String... params) {
        return String.format(locator, (Object[]) params);
    }

    public By getLocator(String locator) {
        String[] locatorSplit = locator.split(":=");
        String typeOfLocator = locatorSplit[0].toUpperCase();
        switch (typeOfLocator) {
            case "ID":
                return By.id(locatorSplit[1]);
            case "NAME":
                return By.name(locatorSplit[1]);
            case "CLASSNAME":
                return By.className(locatorSplit[1]);
            case "XPATH":
                return By.xpath(locatorSplit[1]);
            case "CSS":
                return By.cssSelector(locatorSplit[1]);
            default:
                throw new RuntimeException("Does not support this type of location:" + typeOfLocator);
        }
    }

    public void clickToElementDynamic(WebDriver driver, String locator, String... value) {
        driver.findElement(By.xpath(getDynamicLocator(locator, value))).click();
    }

    protected WebElement getWebElement(WebDriver driver, String locator) {
        return driver.findElement(By.xpath(locator));
    }

    public WebElement getWebElement(WebDriver driver, String locator, String... params) {
        locator = getDynamicLocator(locator, params);
        return driver.findElement(getLocator(locator));
    }

    protected void clickToElement(WebDriver driver, String locator) {
        getWebElement(driver, locator).click();
    }

    protected void senkeyToElement(WebDriver driver, String locator, String value) {
        WebElement element = getWebElement(driver, locator);
        element.clear();
        element.sendKeys(value);
    }

    public boolean isElementSelected(WebDriver driver, String locator) {
        return getWebElement(driver, locator).isSelected();
    }

    public boolean isElementEnable(WebDriver driver, String locator) {
        return getWebElement(driver, locator).isEnabled();
    }

    public String getCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void fowardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refreshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public void switchToWindowById(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String id : allWindows) {
            if (!id.equals(parentID)) {
                driver.switchTo().window(id);
                break;
            }
        }
    }

    public void switchToWindowByTitle(WebDriver driver, String title) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String id : allWindows) {
            driver.switchTo().window(id);
            if (driver.getTitle().equals(title)) {
                break;
            }
        }
    }

    public void closeTabWithoutParent(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String id : allWindows) {
            if (!id.equals(parentID)) {
                driver.switchTo().window(id);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }

}
