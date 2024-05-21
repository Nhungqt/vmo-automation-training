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
        openUrl(driver,"https://app.vntrip.vn/");
    }

    public void getTitleOfVntrip() {
        Assert.assertEquals(driver.getTitle(), "Vntrip: Đặt phòng khách sạn, vé máy bay, combo du lịch giá rẻ");
    }

    public void searchHotel() {
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
    }

    public void clickOnDatPhongBtn() {
        waitForElementVisible(driver, VntripPageUI.ROOM_LIST);
        waitForElementVisible(driver, VntripPageUI.ROOM_LIST);
        clickToElement(driver, VntripPageUI.DATPHONG_BTN);
    }

    public void inputPersonalInformation() {
        waitForElementVisible(driver, VntripPageUI.CHECKOUT_FORM);
        waitForElementVisible(driver, VntripPageUI.FULLNAME_INPUT);
        waitForElementVisible(driver, VntripPageUI.FULLNAME_INPUT, "Quach Thi Nhung");
        waitForElementVisible(driver, VntripPageUI.PHONENUMBER_INPUT, "345678900");
        waitForElementVisible(driver, VntripPageUI.EMAIL_INPUT, "nhungqt@gmail.com");
        clickToElement(driver, VntripPageUI.CONTINUE_BTN);
        String Thanhtoan = getTextElement(driver, VntripPageUI.PAYMENT_FORM);
        Assert.assertEquals(driver, Thanhtoan, "THÔNG TIN THANH TOÁN");
    }

    public void paySuccessfully() {
        clickToElement(driver, VntripPageUI.TTCK);
        clickToElement(driver, VntripPageUI.TTCK);
        clickToElement(driver, VntripPageUI.CONTINUE_PAYMENT);
        clickToElement(driver, VntripPageUI.TRANSFERS_INSTRUCTIONS);
        clickToElement(driver, VntripPageUI.IPAID);
        isElementDisplay(driver, VntripPageUI.GDDDXN);
    }

    public void backToHomepage() {
        clickToElement(driver, VntripPageUI.LOGO);
        String TrangChu = getAttributeElement(driver, VntripPageUI.HOMEPAGE, "class");
        TrangChu.contains("active");
    }
}
