package com.vmo.demowebshop.features;

import com.vmo.demowebshop.common.BaseTest;
import com.vmo.demowebshop.pageObject.DemoWebShopPageObject;
import com.vmo.demowebshop.utils.excelutils.ExcelUtil;
import com.vmo.demowebshop.pageObject.DemoWebShopPageObject;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Epic("Demo Web Shop")
@Feature("Login")
@Story("Verify login function")
public class LoginTest extends BaseTest {
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
    public void loginWithTestData() {
        demoWebShopPageObject.openDemoWebShop();
        demoWebShopPageObject.getTitleOfCurrentPage("Demo Web Shop");

        demoWebShopPageObject.loginWithDataTest(1);

        demoWebShopPageObject.loginWithDataTest(2);

        demoWebShopPageObject.loginWithDataTest(3);

        demoWebShopPageObject.loginWithDataTest(4);

        demoWebShopPageObject.loginWithDataTest(5);

        demoWebShopPageObject.loginWithDataTest(0);

    }
}
