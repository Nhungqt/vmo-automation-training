package com.vmo.letskodeit.features;

import com.vmo.letskodeit.common.BaseTest;
import com.vmo.letskodeit.pageObject.VntripPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//@Listeners(TestListener.class)
public class BookingVntripTest extends BaseTest {
    private WebDriver driver;
    private VntripPageObject vntripPageObject;

    @BeforeMethod
    public void setUp() {
        driver = getBrowserDriver("CHROME");

        vntripPageObject = new VntripPageObject(driver);
    }

    @Test
    public void bookingRoom() {
        vntripPageObject.openVntripPage();
        vntripPageObject.getTitleOfVntrip();

        vntripPageObject.searchHotel();
        vntripPageObject.clickOnDatPhongBtn();

        vntripPageObject.inputPersonalInformation();
        vntripPageObject.paySuccessfully();

        vntripPageObject.backToHomepage();
    }
}
