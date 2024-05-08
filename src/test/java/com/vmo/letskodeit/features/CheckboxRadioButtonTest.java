package com.vmo.letskodeit.features;

import com.vmo.letskodeit.common.BaseTest;
import com.vmo.letskodeit.pageObject.PracticePageObject;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

    }
}
