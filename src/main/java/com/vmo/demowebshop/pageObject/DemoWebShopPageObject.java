package com.vmo.demowebshop.pageObject;

import com.vmo.demowebshop.interfaces.DemoWebShopPageUI;
import com.vmo.demowebshop.common.BasePage;
import com.vmo.demowebshop.helper.Log;
import com.vmo.demowebshop.utils.excelutils.ExcelUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class DemoWebShopPageObject extends BasePage {
    private WebDriver driver;

    public DemoWebShopPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void openDemoWebShop() {
        Log.allure("Open Demo Web Shop page");
        driver.get("https://demowebshop.tricentis.com/");
    }

    public void getTitleOfCurrentPage(String title) {
        Assert.assertEquals(getTitle(driver), title);
    }

    public void loginWithDataTest(int i) {
        Log.allure("Log in with data test");
        Object[][] sheetData = ExcelUtil.shared.getExcelData("assignment.xlsx", "Test data", 1, 6, 1, 3);

        Object[] row = sheetData[i];
        sendKeyAndLogIn((String) row[0], (String) row[1], (String) row[2]);
    }

    public void sendKeyAndLogIn(String email, String password, String message) {
        clickToElement(driver, DemoWebShopPageUI.LOGIN_TEXTLINK);
        clickToElement(driver, DemoWebShopPageUI.EMAIL_INPUT);
        sendKeyToElement(driver, DemoWebShopPageUI.EMAIL_INPUT, email);
        clickToElement(driver, DemoWebShopPageUI.PASSWORD_INPUT);
        sendKeyToElement(driver, DemoWebShopPageUI.PASSWORD_INPUT, password);
        clickToElement(driver, DemoWebShopPageUI.LOGIN_BTN);
        if (!message.isEmpty()) {
            String error = "";
            try {
                getWebElement(driver, DemoWebShopPageUI.MESSAGE_ERROR);
                waitForAllElementsVisible(driver, DemoWebShopPageUI.MESSAGE_ERROR);
                error = getWebElement(driver, DemoWebShopPageUI.MESSAGE_ERROR).getText();
            } catch (Exception e) {

            }
            if (error.isEmpty()) {
                getWebElement(driver, DemoWebShopPageUI.FIELD_VARIATION_ERROR);
                waitForAllElementsVisible(driver, DemoWebShopPageUI.FIELD_VARIATION_ERROR);
                error = getWebElement(driver, DemoWebShopPageUI.FIELD_VARIATION_ERROR).getText();
            }
            Assert.assertEquals(error, message);
        }

    }

    public void goToBookProductionPageSuccessfully() throws InterruptedException {
        Log.allure("Go To Book Production Page Successfully");
        WebElement booksLink = driver.findElement(By.linkText("Books"));
        booksLink.click();
        waitForElementVisible(driver, DemoWebShopPageUI.BOOK_PRODUCTIONS_PAGE);
        isElementDisplay(driver, DemoWebShopPageUI.BOOK_PRODUCTIONS_PAGE);
    }

    public void addToCartTopTwoBooks() throws InterruptedException {
        Log.allure("Add to cart 2 Books highest rated");
        List<WebElement> books = getListWebElements(driver, DemoWebShopPageUI.PRODUCT_ITEM);
//
        // Array to hold the top two books
        WebElement[] topTwoBooks = new WebElement[2];
        double[] topTwoRatings = {0.0, 0.0};

        // Iterate through each book to find the ratings
        for (WebElement book : books) {
            if (isElementDisplay(book, DemoWebShopPageUI.ADD_TO_CART_BTN)) {
                // Locate the rating element
                WebElement ratingElement = getWebElement(book, DemoWebShopPageUI.RATING_LIST);
                String sRating = getWebElement(ratingElement, DemoWebShopPageUI.RATING_VALUE).getAttribute("style");
                sRating = sRating.replaceAll("[^0-9]", "");
                double rating = Double.parseDouble(sRating);

                // Check if the current book has a higher rating than the stored ones
                if (rating > topTwoRatings[0]) {
                    topTwoBooks[1] = topTwoBooks[0];
                    topTwoRatings[1] = topTwoRatings[0];
                    topTwoBooks[0] = book;
                    topTwoRatings[0] = rating;
                } else if (rating > topTwoRatings[1]) {
                    topTwoBooks[1] = book;
                    topTwoRatings[1] = rating;
                }
            }
        }

        // Add the top two books to the cart
        for (WebElement book : topTwoBooks) {
//            WebElement addToCartButton = book.findElement(By.cssSelector(".product-box-add-to-cart-button"));
            getWebElement(book, DemoWebShopPageUI.ADD_TO_CART_BTN);
            clickToElement(driver, DemoWebShopPageUI.ADD_TO_CART_BTN);
            // Wait for a while before adding the next book to avoid any potential issues
            TimeUnit.SECONDS.sleep(2);
        }

    }

    public void verifySuccessMessage() {
        WebElement successMessage = getWebElement(driver, DemoWebShopPageUI.SUCCESS_MESAGE);
        if (successMessage.getText().contains("The product has been added to your shopping cart")) {
            System.out.println("Success: The product has been added to your shopping cart");
        } else {
            System.out.println("Error: The success message did not appear");
        }
    }

    public void verifyCartIncreasesAmount() {
        WebElement cartQuantityElement = getWebElement(driver, DemoWebShopPageUI.CART_QUANTITY);
        int initialCartQuantity = Integer.parseInt(cartQuantityElement.getText().replaceAll("[^0-9]", ""));
        int updatedCartQuantity = Integer.parseInt(cartQuantityElement.getText().replaceAll("[^0-9]", ""));

        // Verify the cart quantity has increased by 2
        if (updatedCartQuantity == initialCartQuantity + 2) {
            System.out.println("Success: The shopping cart quantity has increased correctly.");
        } else {
            System.out.println("Error: The shopping cart quantity did not increase as expected.");
        }

    }

    public void verifyCartDecreasesAmount() {
        WebElement cartQuantityElement = getWebElement(driver, DemoWebShopPageUI.CART_QUANTITY);
        int initialCartQuantity = Integer.parseInt(cartQuantityElement.getText().replaceAll("[^0-9]", ""));
        int updatedCartQuantity = Integer.parseInt(cartQuantityElement.getText().replaceAll("[^0-9]", ""));

        // Verify the cart quantity has decreased by 1
        if (updatedCartQuantity == initialCartQuantity - 1) {
            System.out.println("Success: The shopping cart quantity has decreased correctly.");
        } else {
            System.out.println("Error: The shopping cart quantity did not decrease as expected.");
        }

    }

    public void addThreeAnyItemToCart() throws InterruptedException {
        List<WebElement> products = getListWebElements(driver, DemoWebShopPageUI.PRODUCT_ITEM);
        ArrayList<Integer> randoms = new ArrayList<>();
        while (randoms.size() < 3) {
            int random = new Random().nextInt(products.size());
            if (!randoms.contains(random)) {
                randoms.add(random);
            }
        }
        for (int random : randoms) {
            WebElement product = products.get(1);
            if (isElementDisplay(product, DemoWebShopPageUI.ADD_TO_CART_BTN)) {
                clickToElement(driver, DemoWebShopPageUI.ADD_TO_CART_BTN);
                TimeUnit.SECONDS.sleep(3);
            }
        }
    }

    public void hoverOnShoppingCartAndVerify() {
        hoverMouseToElement(driver, DemoWebShopPageUI.SHOPPING_CART_TEXTLINK);
//      Verify products are added


    }

    public void goToShoppingCartPageSuccessfully() throws InterruptedException {
        getWebElement(driver, DemoWebShopPageUI.SHOPPING_CART_TEXTLINK);
        clickToElement(driver, DemoWebShopPageUI.SHOPPING_CART_TEXTLINK);
        waitForElementVisible(driver, DemoWebShopPageUI.CART_TABLE);
    }

    public void removeProductAndUpdate() {
        // Choose the first product in the cart to remove
        getWebElement(driver, DemoWebShopPageUI.FIRST_ITEM_CHECKBOX);
        clickToElement(driver, DemoWebShopPageUI.FIRST_ITEM_CHECKBOX);
        isElementSelected(driver, DemoWebShopPageUI.FIRST_ITEM_CHECKBOX);
        getWebElement(driver, DemoWebShopPageUI.UPDATE_CART_BTN);
        clickToElement(driver, DemoWebShopPageUI.UPDATE_CART_BTN);

    }

    public void goToDigitalDownloadsPageSuccessfully() throws InterruptedException {
        WebElement digitalDownloads = getWebElement(driver, DemoWebShopPageUI.DIGITAL_DOWNLOADS_TEXTLINK);
        digitalDownloads.click();
        waitForAllElementsVisible(driver, DemoWebShopPageUI.DIGITAL_TITLE);
    }

    public void addAnyItemToCart() throws InterruptedException {
        List<WebElement> products = getListWebElements(driver, DemoWebShopPageUI.PRODUCT_ITEM);

        int random = new Random().nextInt(products.size());
        WebElement product = products.get(random);
        if (isElementDisplay(product, DemoWebShopPageUI.ADD_TO_CART_BTN)) {
            getWebElement(product, DemoWebShopPageUI.ADD_TO_CART_BTN);
            clickToElement(driver, DemoWebShopPageUI.ADD_TO_CART_BTN);
            TimeUnit.SECONDS.sleep(3);
        }

    }

    public void clickOnTermsOfServiceSuccessfully() throws InterruptedException {
        getWebElement(driver, DemoWebShopPageUI.TERM_OF_SERVICE_CHECKBOX);
        clickToElement(driver, DemoWebShopPageUI.TERM_OF_SERVICE_CHECKBOX);
        isElementSelected(driver, DemoWebShopPageUI.TERM_OF_SERVICE_CHECKBOX);
        overrideImplicitTimeOut(driver, 10);
    }

    public void clickOnCheckout() throws InterruptedException {
        getWebElement(driver, DemoWebShopPageUI.CHECKOUT_BTN);
        clickToElement(driver, DemoWebShopPageUI.CHECKOUT_BTN);
        overrideImplicitTimeOut(driver, 10);
        isElementDisplay(driver, DemoWebShopPageUI.CHECKOUT_USER_TYPE_PAGE);
    }

    public void selectUserCheckoutPage() {

    }

    public void clickOnCheckoutAsGuest() throws InterruptedException {
        getWebElement(driver, DemoWebShopPageUI.CHECKOUT_AS_GUEST_BTN);
        clickToElement(driver, DemoWebShopPageUI.CHECKOUT_AS_GUEST_BTN);
        overrideImplicitTimeOut(driver, 10);
    }

    public void fillInformationBillingAddress() throws InterruptedException {
        // Fill in required information in Billing Address
        getWebElement(driver, DemoWebShopPageUI.FIRSTNAME_INPUT);
        sendKeyToElement(driver, DemoWebShopPageUI.FIRSTNAME_INPUT, "Quach");
        getWebElement(driver, DemoWebShopPageUI.LASTNAME_INPUT);
        sendKeyToElement(driver, DemoWebShopPageUI.LASTNAME_INPUT, "Nhung");
        getWebElement(driver, DemoWebShopPageUI.EMAIL_CHECKOUT_INPUT);
        sendKeyToElement(driver, DemoWebShopPageUI.EMAIL_CHECKOUT_INPUT, "quachnhung@example.com");
        getWebElement(driver, DemoWebShopPageUI.COMPANY_INPUT);
        sendKeyToElement(driver, DemoWebShopPageUI.COMPANY_INPUT, "Company");
        getWebElement(driver, DemoWebShopPageUI.COUNTRY_FIELD);
        clickToElement(driver, DemoWebShopPageUI.SELECT_COUNTRY);
        getWebElement(driver, DemoWebShopPageUI.CITY_INPUT);
        sendKeyToElement(driver, DemoWebShopPageUI.CITY_INPUT, "City");
        getWebElement(driver, DemoWebShopPageUI.ADDRESSED_1);
        sendKeyToElement(driver, DemoWebShopPageUI.ADDRESSED_1, "123 Street");
        getWebElement(driver, DemoWebShopPageUI.ZIP_POSTAL_CODE_INPUT);
        sendKeyToElement(driver, DemoWebShopPageUI.ZIP_POSTAL_CODE_INPUT, "12345");
        getWebElement(driver, DemoWebShopPageUI.PHONENUMBER_INPUT);
        sendKeyToElement(driver, DemoWebShopPageUI.PHONENUMBER_INPUT, "1234567890");
        getWebElement(driver, DemoWebShopPageUI.CONTINUE_BILLING_SAVE_BTN);
        clickToElement(driver, DemoWebShopPageUI.CONTINUE_BILLING_SAVE_BTN);
        overrideImplicitTimeOut(driver, 10);
    }

    public void payAndConfirmOrder() {
        getWebElement(driver, DemoWebShopPageUI.CONTINUE_PAYMENT_BTN);
        clickToElement(driver, DemoWebShopPageUI.CONTINUE_PAYMENT_BTN);
        overrideImplicitTimeOut(driver, 10);

        getWebElement(driver, DemoWebShopPageUI.CONTINUE_PAYMENT_INFOR_BTN);
        clickToElement(driver, DemoWebShopPageUI.CONTINUE_PAYMENT_INFOR_BTN);
        overrideImplicitTimeOut(driver, 10);

        getWebElement(driver, DemoWebShopPageUI.CONFIRM_BTN);
        clickToElement(driver, DemoWebShopPageUI.CONFIRM_BTN);
        overrideImplicitTimeOut(driver, 10);

        getWebElement(driver, DemoWebShopPageUI.CONTINUE_COMPLETED_BTN);
        waitForElementClickable(driver, DemoWebShopPageUI.CONTINUE_COMPLETED_BTN);
        clickToElement(driver, DemoWebShopPageUI.CONTINUE_COMPLETED_BTN);
        overrideImplicitTimeOut(driver, 10);

    }


}
