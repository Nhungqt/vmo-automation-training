package com.vmo.letskodeit.features;

import com.vmo.letskodeit.common.BaseTest;
import com.vmo.letskodeit.pageObject.PracticePageObject;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
        practicePageObject.verifyAccessPageSuccessfully();

        practicePageObject.selectBMWCheckBox();
        practicePageObject.isBMWCheckboxSelected();

        practicePageObject.selectBENZCheckbox();
        practicePageObject.isBENZCheckboxSlected();

        practicePageObject.selectBMWCheckBox();
        practicePageObject.isBMWCheckboxSelected();
    }
    @Test
    public void TC02_HandleRadioButton(){
        practicePageObject.openletskodeitPracticePage();
        practicePageObject.verifyAccessPageSuccessfully();

        practicePageObject.selectHondaRadio();
        practicePageObject.isHondaRadioSeleted();

        practicePageObject.selecBenzRadio();
        practicePageObject.isBenzRadioSelected();

        practicePageObject.selectHondaRadio();
        practicePageObject.isHondaRadioSeleted();

        practicePageObject.selectHondaRadio();
        practicePageObject.isHondaRadioSeleted();
    }
    @Test
    public void TC03_FieldStatus(){
        practicePageObject.openletskodeitPracticePage();
        practicePageObject.verifyAccessPageSuccessfully();

        practicePageObject.selectEnableOrDisableBtn();
        practicePageObject.isEnableOrDisableBtnEnable();
    }
}
