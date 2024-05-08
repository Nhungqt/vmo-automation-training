package com.vmo.letskodeit.pageObject;

import com.vmo.letskodeit.common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PracticePageObject extends BasePage {
    private WebDriver driver;

    public PracticePageObject(WebDriver driver){
        this.driver = driver;
    }
    public void openletskodeitPracticePage (){
        driver.get("https://www.letskodeit.com/practice");
    }
    public void handleCheckbox(){
        WebElement
    }

}
