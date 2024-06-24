package com.vmo.demowebshop.features;

import com.vmo.demowebshop.common.BaseTest;
import com.vmo.demowebshop.pageObject.DemoWebShopPageObject;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Epic("Demo Web Shop")
@Feature("Add item to cart")
@Story("Add 2 books highest rated to cart")
public class Buy2BooksHighestRatedTest extends BaseTest {
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
        driver.quit();
    }

    @Test
    public void buy2BooksHighestRatedTest() throws InterruptedException {
        demoWebShopPageObject.openDemoWebShop();
        demoWebShopPageObject.getTitleOfCurrentPage("Demo Web Shop");
        demoWebShopPageObject.goToBookProductionPageSuccessfully();
        demoWebShopPageObject.addToCartTopTwoBooks();
        demoWebShopPageObject.verifySuccessMessage();
        demoWebShopPageObject.verifyCartIncreasesAmount();
        //    demoWebShopPageObject.hoverOnShoppingCartAndVerify();


    }
}
