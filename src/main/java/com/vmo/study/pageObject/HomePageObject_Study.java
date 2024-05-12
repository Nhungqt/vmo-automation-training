package com.vmo.study.pageObject;

import com.vmo.letskodeit.interfaces.PracticePageUI;
import com.vmo.study.common.BasePage_Study;
import org.openqa.selenium.WebDriver;

public class HomePageObject_Study extends BasePage_Study {
    private WebDriver driver;

    public HomePageObject_Study(WebDriver driver){
        this.driver = driver;
    }
}
