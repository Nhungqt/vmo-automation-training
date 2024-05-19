package com.vmo.letskodeit.features;

import com.vmo.letskodeit.common.BaseTest;
import com.vmo.letskodeit.pageObject.VntripPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookingVntripSuccessfully extends BaseTest {
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

        vntripPageObject.waitForKhachSanclickable();
        vntripPageObject.clickOnKhachSan();
        vntripPageObject.waitforSearchfieldVisible();
        vntripPageObject.senkeyToSearchField();

        vntripPageObject.waitForHotelListVisible();
        vntripPageObject.clickOnJWHaNoi();

        vntripPageObject.SelectDay();
        vntripPageObject.scrolltoReturnDay();
        vntripPageObject.selectReceiveDay();
        vntripPageObject.selectReturnDay();
        vntripPageObject.clickOnSearchBtn();

        vntripPageObject.waitForRoomListVisible();
        vntripPageObject.clickOnDatPhongBtn();

        vntripPageObject.waitForCheckoutFormVisible();
        vntripPageObject.waitForFullNameFieldVisible();

        vntripPageObject.inputFullName();
        vntripPageObject.inputPhoneNumber();
        vntripPageObject.inputEmail();
        vntripPageObject.clickOnContinueBtn();

        vntripPageObject.verifyIsAtCheckoutPayment();
        vntripPageObject.waitForTTCKVisible();
        vntripPageObject.clickOnTTCK();
        vntripPageObject.clickOnContinueToPay();


        vntripPageObject.waitForTransferInstructionVisible();
        vntripPageObject.clickOnIPAID();
        vntripPageObject.isGDDXNDisplayed();

        vntripPageObject.backToHomepage();
        vntripPageObject.isAtHomePage();
    }
}
