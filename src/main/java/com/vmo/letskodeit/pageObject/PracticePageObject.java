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
        Log.info("open Practice Page");
        driver.get("https://www.letskodeit.com/practice");
    }

    public void verifyAccessPageSuccessfully() {
        Assert.assertEquals(driver, getTitle(driver), "Practice Page");
    }

    public void selectBMWCheckBox() {
        clickToElement(driver, PracticePageUI.BMW_CHECKBOX);
    }

    public void isBMWCheckboxSelected() {
        Log.info("Select BMW Checkbox successfully");
        isElementSelected(driver, PracticePageUI.BMW_CHECKBOX);
    }

    public void selectBENZCheckbox() {
        clickToElement(driver, PracticePageUI.BENZ_CHECKBOX);
    }

    public void isBENZCheckboxSlected() {
        isElementSelected(driver, PracticePageUI.BENZ_CHECKBOX);
    }

    public void selectHondaRadio() {
        clickToElement(driver, PracticePageUI.HONDA_RADIO);
    }

    public void isHondaRadioSeleted() {
        isElementSelected(driver, PracticePageUI.HONDA_RADIO);
    }

    public void selecBenzRadio() {
        clickToElement(driver, PracticePageUI.BENZ_RADIO);
    }

    public void isBenzRadioSelected() {
        isElementSelected(driver, PracticePageUI.BENZ_RADIO);
    }

    public void selectEnableOrDisableBtn() {
        if (isElementEnable(driver, PracticePageUI.ENABLE_BUTTON)) {
            clickToElement(driver, PracticePageUI.DISABLE_BUTTON);
        } else clickToElement(driver, PracticePageUI.ENABLE_BUTTON);
    }

    public void isEnableOrDisableBtnEnable() {
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