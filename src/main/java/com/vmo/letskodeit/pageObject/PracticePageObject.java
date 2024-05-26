package com.vmo.letskodeit.pageObject;

import com.vmo.letskodeit.common.BasePage;
import com.vmo.letskodeit.helper.Log;
import com.vmo.letskodeit.interfaces.PracticePageUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class PracticePageObject extends BasePage {
    private WebDriver driver;

    public PracticePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void openletskodeitPracticePage() {
        Log.allure("Open Practice Page");
        driver.get("https://www.letskodeit.com/practice");
    }

    public void verifyAccessPageSuccessfully(String title) {
        Log.allure("Verify title is %s");
        Assert.assertEquals(getTitle(driver),title);
    }

    public void selectBMWCheckBox() {
        Log.allure("Select BMW CheckBox");
        clickToElement(driver, PracticePageUI.BMW_CHECKBOX);
    }

    public void isBMWCheckboxSelected() {
        Log.allure("Verify BMW Checkbox is selected");
        isElementSelected(driver, PracticePageUI.BMW_CHECKBOX);
    }

    public void selectBENZCheckbox() {
        Log.allure("Select BENZ Checkbox");
        clickToElement(driver, PracticePageUI.BENZ_CHECKBOX);
    }

    public void isBENZCheckboxSelected() {
        Log.allure("Verify BENZ Checkbox is selected");
        isElementSelected(driver, PracticePageUI.BENZ_CHECKBOX);
    }

    public void selectHondaRadio() {
        Log.allure("Select Honda radio");
        clickToElement(driver, PracticePageUI.HONDA_RADIO);
    }

    public void isHondaRadioSelected() {
        Log.allure("Verify Honda radio is selected");
        isElementSelected(driver, PracticePageUI.HONDA_RADIO);
    }

    public void selectBenzRadio() {
        Log.allure("Select BENZ radio");
        clickToElement(driver, PracticePageUI.BENZ_RADIO);
    }

    public void isBenzRadioSelected() {
        Log.allure("Verify BENZ radio is lelected");
        isElementSelected(driver, PracticePageUI.BENZ_RADIO);
    }

    public void selectEnableOrDisableBtn() {
        Log.allure("Select Disable or Enable button");
        if (isElementEnable(driver, PracticePageUI.ENABLE_BUTTON)) {
            clickToElement(driver, PracticePageUI.DISABLE_BUTTON);
        } else clickToElement(driver, PracticePageUI.ENABLE_BUTTON);
    }

    public void isEnableOrDisableBtnEnable() {
        Log.allure("Verify Disable or Enable button is Enable");
        isElementEnable(driver, PracticePageUI.STATUS_BUTTON);

    }


    //  Study on class

    public void selectBMWCheckBoxStudy() {
        clickToElementDynamic(driver, PracticePageUI.DYNAMIC_LOCATOR, "bmw", "bmwcheck");
    }
    public String getTitlePracticePage() {
        return getTitle(driver);
    }
}