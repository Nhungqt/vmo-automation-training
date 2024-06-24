package com.vmo.demowebshop.interfaces;

import static com.vmo.demowebshop.common.Locator.*;

public class DemoWebShopPageUI {
    public static final String LOGIN_TEXTLINK = xpath("//a[text()='Log in']");
    public static final String EMAIL_INPUT = xpath("//input[@id='Email']");
    public static final String PASSWORD_INPUT = xpath("//input[@id='Password']");
    public static final String LOGIN_BTN = xpath("//input[@class='button-1 login-button']");
    public static final String MESSAGE_ERROR = xpath("//div[@class='message-error']//ul");
    public static final String FIELD_VARIATION_ERROR = xpath("//span[@class='field-validation-error']");
    public static final String LOGOUT_TEXTLINK = xpath("//a[text()='Log out']");
    public static final String BOOKS_TAG = xpath("//strong[text()='Categories']/parent::div/following-sibling::div//li[1]");
    public static final String BOOK_PRODUCTIONS_PAGE = xpath("//h1[text()='Books']");
    public static final String SUCCESS_MESAGE = className("bar-notification.success");
    public static final String CART_QUANTITY = className("cart-qty");
    public static final String PRODUCT_ITEM = css(".product-item");
    public static final String RATING_LIST = css(".rating");
    public static final String ADD_TO_CART_BTN = css(".product-box-add-to-cart-button");
    public static final String RATING_VALUE = xpath("//div[@class='rating']//div");
    public static final String FIRST_ITEM_CHECKBOX = xpath("//tbody//tr[@class='cart-item-row'][1]//input[@name='removefromcart']");
    public static final String UPDATE_CART_BTN = xpath("//input[@name='updatecart']");

//  Locator TC 04
    public static final String DIGITAL_DOWNLOADS_TEXTLINK = xpath("//ul[@class='top-menu']//a[contains(text(),'Digital downloads')]");
    public static final String DIGITAL_TITLE = xpath("//h1[text()='Digital downloads']");
    public static final String SHOPPING_CART_TEXTLINK = xpath("//span[text()='Shopping cart']");
    public static final String CART_TABLE = xpath("//table[@class='cart']");
    public static final String TERM_OF_SERVICE_CHECKBOX = id("termsofservice");
    public static final String CHECKOUT_BTN = id("checkout");
    public static final String  CHECKOUT_USER_TYPE_PAGE = className("new-wrapper checkout-as-guest-or-register-block");
    public static final String CHECKOUT_AS_GUEST_BTN = css(".checkout-as-guest-button");
    public static final String FIRSTNAME_INPUT = id("BillingNewAddress_FirstName");
    public static final String LASTNAME_INPUT = id("BillingNewAddress_LastName");
    public static final String EMAIL_CHECKOUT_INPUT = id("BillingNewAddress_Email");
    public static final String COMPANY_INPUT = id("BillingNewAddress_FirstName");
    public static final String COUNTRY_FIELD = xpath("//select[@name='BillingNewAddress.CountryId']");
    public static final String SELECT_COUNTRY = xpath("//select[@name='BillingNewAddress.CountryId']//option[2]");
    public static final String CITY_INPUT = id("BillingNewAddress_City");
    public static final String ADDRESSED_1 = id("BillingNewAddress_Address1");
    public static final String ZIP_POSTAL_CODE_INPUT = id("BillingNewAddress_ZipPostalCode");
    public static final String PHONENUMBER_INPUT = id("BillingNewAddress_PhoneNumber");
    public static final String CONTINUE_BILLING_SAVE_BTN = xpath("//input[@onclick='Billing.save()']");
    public static final String CONTINUE_PAYMENT_BTN = xpath("//input[@onclick='PaymentMethod.save()']");
    public static final String CONTINUE_PAYMENT_INFOR_BTN = xpath("//input[@onclick='PaymentInfo.save()']");
    public static final String CONFIRM_BTN = xpath("//input[@onclick='ConfirmOrder.save()']");
    public static final String CONTINUE_COMPLETED_BTN = className("button-2 order-completed-continue-button");


}
