package com.vmo.study.common;

import com.vmo.letskodeit.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage_Study {
    public class PracticePageObject extends BasePage {
        private WebDriver driver;

        public PracticePageObject(WebDriver driver) {
            this.driver = driver;
        }

    }
}
