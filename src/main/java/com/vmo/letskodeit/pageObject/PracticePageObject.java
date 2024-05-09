package com.vmo.letskodeit.pageObject;

import com.vmo.letskodeit.common.BasePage;
import com.vmo.letskodeit.interfaces.PracticePageUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PracticePageObject extends BasePage {
    private WebDriver driver;

    public PracticePageObject(WebDriver driver){
        this.driver = driver;
    }
    public void openletskodeitPracticePage (){
        driver.get("https://www.letskodeit.com/practice");
    }
    public void selectBMWCheckBox(){
        WebElement BMWCheckBox = driver.findElement(By.xpath(PracticePageUI.BMW_CHECKBOX));
        BMWCheckBox.click();
        Assert.assertTrue(BMWCheckBox.isSelected());
    }

    public String getTitlePracticePage(){
        return driver.getTitle();
    }
}
