package com.vmo.letskodeit.pageObject;

import com.vmo.letskodeit.common.BasePage;
import com.vmo.letskodeit.interfaces.VntripPageUI;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class VntripPageObject extends BasePage {
    private WebDriver driver;

    public VntripPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void openVntripPage() {
        driver.get("https://app.vntrip.vn/");
    }

    public void getTitleOfVntrip() {
        Assert.assertEquals(driver.getTitle(), "Vntrip: Đặt phòng khách sạn, vé máy bay, combo du lịch giá rẻ");
    }

    public void waitForKhachSanclickable() {
        waitForElementClickable(driver, VntripPageUI.KHACHSAN_TEXTLINK);
    }

    public void clickOnKhachSan() {
        clickToElement(driver, VntripPageUI.KHACHSAN_TEXTLINK);
    }

    public void waitforSearchfieldVisible() {
        waitForElementVisible(driver, VntripPageUI.SEARCH_INPUT);
    }

    public void senkeyToSearchField() {
        senkeyToElement(driver, VntripPageUI.SEARCH_INPUT, "Jw marriot");
    }

    public void waitForHotelListVisible() {
        waitForElementVisible(driver, VntripPageUI.HOTEL_LIST);
    }

    public void clickOnJWHaNoi() {
        clickToElement(driver, VntripPageUI.JWHANOI_OPTION);
    }

    public void SelectDay() {
        clickToElement(driver, VntripPageUI.RECEIVE_RETURN_DAY);
    }

    public void scrolltoReturnDay() {
        scrollToElement(driver, VntripPageUI.RETURN_DAY);
    }

    public void selectReceiveDay() {
        clickToElement(driver, VntripPageUI.RECEIVE_DAY);
    }

    public void selectReturnDay() {
        clickToElement(driver, VntripPageUI.RETURN_DAY);
    }

    public void clickOnSearchBtn() {
        clickToElement(driver, VntripPageUI.SEARCH_BTN);
    }

    public void waitForRoomListVisible() {
        waitForElementVisible(driver, VntripPageUI.ROOM_LIST);
    }

    public void clickOnDatPhongBtn() {
        clickToElement(driver, VntripPageUI.DATPHONG_BTN);
    }

    public void waitForCheckoutFormVisible() {
        waitForElementVisible(driver, VntripPageUI.CHECKOUT_FORM);
    }

    public void waitForFullNameFieldVisible() {
        waitForElementVisible(driver, VntripPageUI.FULLNAME_INPUT);
    }

    public void inputFullName() {
        waitForElementVisible(driver, VntripPageUI.FULLNAME_INPUT, "Quach Thi Nhung");
    }

    public void inputPhoneNumber() {
        waitForElementVisible(driver, VntripPageUI.PHONENUMBER_INPUT, "345678900");
    }

    public void inputEmail() {
        waitForElementVisible(driver, VntripPageUI.EMAIL_INPUT, "nhungqt@gmail.com");
    }

    public void clickOnContinueBtn() {
        clickToElement(driver, VntripPageUI.CONTINUE_BTN);
    }

    public void verifyIsAtCheckoutPayment() {
        String Thanhtoan = getTextElement(driver, VntripPageUI.PAYMENT_FORM);
        Assert.assertEquals(driver, Thanhtoan, "THÔNG TIN THANH TOÁN");
    }

    public void waitForTTCKVisible() {
        clickToElement(driver, VntripPageUI.TTCK);
    }

    public void clickOnTTCK() {
        clickToElement(driver, VntripPageUI.TTCK);
    }

    public void clickOnContinueToPay() {
        clickToElement(driver, VntripPageUI.CONTINUE_PAYMENT);
    }

    public void waitForTransferInstructionVisible() {
        clickToElement(driver, VntripPageUI.TRANSFERS_INSTRUCTIONS);
    }

    public void clickOnIPAID() {
        clickToElement(driver, VntripPageUI.IPAID);
    }

    public void isGDDXNDisplayed() {
        isElementDisplay(driver, VntripPageUI.GDDDXN);
    }

    public void backToHomepage() {
        clickToElement(driver, VntripPageUI.LOGO);
    }

    public void isAtHomePage() {
        String TrangChu = getAttributeElement(driver, VntripPageUI.HOMEPAGE, "class");
        TrangChu.contains("active");
    }
}
