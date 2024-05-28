package com.vmo.letskodeit.features;

import com.vmo.letskodeit.common.BaseTest;
import com.vmo.letskodeit.helper.Log;
import com.vmo.letskodeit.pageObject.VntripPageObject;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
//@Listeners(TestListener.class)

@Epic("Vntrip")
@Feature("Booking hotel")
@Story("Booking hotel successfully")
public class BookingVntripTest extends BaseTest {
    private WebDriver driver;
    private VntripPageObject vntripPageObject;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) {
        driver = getBrowserDriver(browser);

        vntripPageObject = new VntripPageObject(driver);
    }
//    @AfterMethod
//    public void tearDown(){
//        driver.quit();
//    }

    @Test
    @Parameters({"fullname", "phonenumber", "email"})
    public void bookingRoom(String fullname, String phonenumber, String email) {
        vntripPageObject.openVntripPage();
        vntripPageObject.getTitleOfVntrip();

        vntripPageObject.searchHotel();
        vntripPageObject.clickOnDatPhongBtn();

        vntripPageObject.inputPersonalInformation(fullname, phonenumber, email);
        vntripPageObject.paySuccessfully();

        vntripPageObject.backToHomepage();
    }
}
