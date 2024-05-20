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

    public void inputSearchCondition(){
        waitForElementClickable(driver, VntripPageUI.KHACHSAN_TEXTLINK);
        clickToElement(driver, VntripPageUI.KHACHSAN_TEXTLINK);
        waitForElementVisible(driver, VntripPageUI.SEARCH_INPUT);
        senkeyToElement(driver, VntripPageUI.SEARCH_INPUT, "Jw marriot");
        waitForElementVisible(driver, VntripPageUI.HOTEL_LIST);
        clickToElement(driver, VntripPageUI.JWHANOI_OPTION);
        clickToElement(driver, VntripPageUI.RECEIVE_RETURN_DAY);
        scrollToElement(driver, VntripPageUI.RETURN_DAY);
        clickToElement(driver, VntripPageUI.RECEIVE_DAY);
        clickToElement(driver, VntripPageUI.RETURN_DAY);
        clickToElement(driver, VntripPageUI.SEARCH_BTN);
        waitForElementVisible(driver, VntripPageUI.ROOM_LIST);
        waitForElementVisible(driver, VntripPageUI.ROOM_LIST);
        clickToElement(driver, VntripPageUI.DATPHONG_BTN);
        waitForElementVisible(driver, VntripPageUI.CHECKOUT_FORM);
        waitForElementVisible(driver, VntripPageUI.FULLNAME_INPUT);
        waitForElementVisible(driver, VntripPageUI.FULLNAME_INPUT, "Quach Thi Nhung");
        waitForElementVisible(driver, VntripPageUI.PHONENUMBER_INPUT, "345678900");
        waitForElementVisible(driver, VntripPageUI.EMAIL_INPUT, "nhungqt@gmail.com");

    }

    public void waitForKhachSanclickable() {

    }

    public void clickOnKhachSan() {

    }

    public void waitforSearchfieldVisible() {

    }

    public void senkeyToSearchField() {

    }

    public void waitForHotelListVisible() {

    }

    public void clickOnJWHaNoi() {

    }

    public void SelectDay() {

    }

    public void scrolltoReturnDay() {

    }

    public void selectReceiveDay() {

    }

    public void selectReturnDay() {

    }

    public void clickOnSearchBtn() {

    }

    public void waitForRoomListVisible() {

    }

    public void clickOnDatPhongBtn() {

    }

    public void waitForCheckoutFormVisible() {

    }

    public void waitForFullNameFieldVisible() {

    }

    public void inputFullName() {

    }

    public void inputPhoneNumber() {

    }

    public void inputEmail() {

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
