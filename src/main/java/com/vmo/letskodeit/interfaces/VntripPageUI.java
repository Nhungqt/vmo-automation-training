package com.vmo.letskodeit.interfaces;

import static com.vmo.letskodeit.common.Locator.xpath;

public class VntripPageUI {
    public static final String KHACHSAN_TEXTLINK = xpath("//span[text()='Khách sạn']/parent::a");
    public static final String SEARCH_INPUT = xpath("//input[@placeholder='Nhập điểm đến, khách sạn']");
    public static final String HOTEL_LIST = xpath("//ul[@class='listPlace']");
    public static final String JWHANOI_OPTION = xpath("//p[contains(text(),'JW Marriott Hanoi')]");
    public static final String RECEIVE_RETURN_DAY = xpath("//p[text()='Ngày nhận phòng / trả phòng']/following-sibling::div[@class='inputInline']");
    public static final String RECEIVE_DAY = xpath("//td[@title='2024-06-01']");
    public static final String RETURN_DAY = xpath("//td[@title='2024-06-02']");
    public static final String SEARCH_BTN = xpath("//span[text()='Tìm kiếm']/parent::button");
    public static final String ROOM_LIST = xpath("//div[@class='listRoom']");
    public static final String DATPHONG_BTN = xpath("//div[@class='listRoom__item'][1]//div[@class='roomItem__body']//div[@class='roomItem__row'][1]//div[@class='roomItem__btn']");
    public static final String CHECKOUT_FORM = xpath("//div[@class='checkoutInfo']");
    public static final String FULLNAME_INPUT = xpath("//input[@placeholder='Họ và tên']");
    public static final String PHONENUMBER_INPUT = xpath("input[@placeholder='Số điện thoại']");
    public static final String EMAIL_INPUT = xpath("//input[@placeholder='Email']");
    public static final String CONTINUE_BTN = xpath("//span[text()='Tiếp tục']");
    public static final String PAYMENT_FORM = xpath("//div[@class='checkoutPayment']//h2");
    public static final String TTCK = xpath("//p[text()='Thanh toán chuyển khoản']/ancestor::label");
    public static final String CONTINUE_PAYMENT = xpath("//span[text()='Tiếp tục']/parent::button");
    public static final String TRANSFERS_INSTRUCTIONS = xpath("//h2[text()='HƯỚNG DẪN CHUYỂN KHOẢN']/parent::div");
    public static final String IPAID = xpath("//span[text()='Tôi đã chuyển khoản xong']/parent::button");
    public static final String GDDDXN = xpath("//p[text()='Giao dịch đang được xác nhận']/ancestor::div[@class='checkoutState']");
    public static final String LOGO = xpath("//a[@class='logo']");
    public static final String HOMEPAGE = xpath("//span[text()='Trang chủ']/ancestor::li");

}
