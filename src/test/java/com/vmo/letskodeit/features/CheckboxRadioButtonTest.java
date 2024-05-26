package com.vmo.letskodeit.features;

import com.vmo.letskodeit.common.BaseTest;
import com.vmo.letskodeit.pageObject.PracticePageObject;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("letskodeit")
@Feature("Practice Page")
@Story("Handle checkbox/radio/button")
public class CheckboxRadioButtonTest extends BaseTest {
    private WebDriver driver;
    private PracticePageObject practicePageObject;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        practicePageObject = new PracticePageObject(driver);
    }

    @Test
    public void TC01_HandleCheckbox(){
        practicePageObject.openletskodeitPracticePage();
        practicePageObject.verifyAccessPageSuccessfully("Practice Page");

        practicePageObject.selectBMWCheckBox();
        practicePageObject.isBMWCheckboxSelected();

        practicePageObject.selectBENZCheckbox();
        practicePageObject.isBENZCheckboxSelected();

        practicePageObject.selectBMWCheckBox();
        practicePageObject.isBMWCheckboxSelected();
    }
    @Test
    public void TC02_HandleRadioButton(){
        practicePageObject.openletskodeitPracticePage();
        practicePageObject.verifyAccessPageSuccessfully("Practice Page");

        practicePageObject.selectHondaRadio();
        practicePageObject.isHondaRadioSelected();

        practicePageObject.selectBenzRadio();
        practicePageObject.isBenzRadioSelected();

        practicePageObject.selectHondaRadio();
        practicePageObject.isHondaRadioSelected();

        practicePageObject.selectHondaRadio();
        practicePageObject.isHondaRadioSelected();
    }
    @Test
    public void TC03_FieldStatus(){
        practicePageObject.openletskodeitPracticePage();
        practicePageObject.verifyAccessPageSuccessfully("Practice Page");

        practicePageObject.selectEnableOrDisableBtn();
        practicePageObject.isEnableOrDisableBtnEnable();
    }
}
