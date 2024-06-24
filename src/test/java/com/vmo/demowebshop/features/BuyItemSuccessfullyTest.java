package com.vmo.demowebshop.features;

import com.vmo.demowebshop.common.BaseTest;
import com.vmo.demowebshop.pageObject.DemoWebShopPageObject;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Epic("Demo Web Shop")
@Feature("Check out cart")
@Story("Buy item successfully")
public class BuyItemSuccessfullyTest extends BaseTest {
    private WebDriver driver;
    private DemoWebShopPageObject demoWebShopPageObject;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(@Optional("CHROME") String browser) {
        driver = getBrowserDriver(browser);
        demoWebShopPageObject = new DemoWebShopPageObject(driver);
    }

    @AfterMethod
    public void tearDown() {
//        driver.quit();
    }

    @Test
    public void buyItemSuccessfullyTest() throws InterruptedException {
        demoWebShopPageObject.openDemoWebShop();
        demoWebShopPageObject.getTitleOfCurrentPage("Demo Web Shop");

        demoWebShopPageObject.goToDigitalDownloadsPageSuccessfully();
        demoWebShopPageObject.addAnyItemToCart();
        demoWebShopPageObject.verifySuccessMessage();
        demoWebShopPageObject.verifyCartIncreasesAmount();
        demoWebShopPageObject.goToShoppingCartPageSuccessfully();

        demoWebShopPageObject.clickOnTermsOfServiceSuccessfully();
        demoWebShopPageObject.clickOnCheckout();
        demoWebShopPageObject.clickOnCheckoutAsGuest();
        demoWebShopPageObject.fillInformationBillingAddress();
        demoWebShopPageObject.payAndConfirmOrder();

    }
}