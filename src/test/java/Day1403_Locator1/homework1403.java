package Day1403_Locator1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class homework1403 {

    WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void hw01() {
        driver.get("https://demo.nopcommerce.com/");
        Assert.assertEquals(driver.getTitle(),"nopCommerce demo store");
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys("computer");
        WebElement searchBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        searchBtn.click();
    }

    @Test
    public void hw02() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Assert.assertEquals(driver.getTitle(), "OrangeHRM");
        Thread.sleep(5000);
        WebElement userNameTxt = driver.findElement(By.name("username"));
        WebElement passwordTxt = driver.findElement(By.name("password"));
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        userNameTxt.sendKeys("Admin");
        passwordTxt.sendKeys("admin123");
        passwordTxt.sendKeys(Keys.ENTER);
        WebElement dashboard = driver.findElement(By.id("app"));
        Assert.assertTrue(dashboard.isDisplayed());
    }

    @Test
    public void hw03() {
        driver.get("http://zero.webappsecurity.com/");

        Assert.assertEquals(driver.getTitle(), "Zero - Personal Banking - Loans - Credit Cards");

        WebElement signinBtn = driver.findElement(By.id("signin_button"));
        signinBtn.click();

        WebElement loginTextBox = driver.findElement(By.id("user_login"));
        WebElement passwordTextBox = driver.findElement(By.id("user_password"));

        loginTextBox.sendKeys("username");
        passwordTextBox.sendKeys("password");

        WebElement signInBtn = driver.findElement(By.name("submit"));
        signInBtn.click();

        driver.get("http://zero.webappsecurity.com/bank/transfer-funds.html");
        Assert.assertEquals(driver.getTitle(), "Zero - Transfer Funds");

        WebElement usernameDrop = driver.findElement(By.className("icon-user"));
        usernameDrop.click();

        WebElement logoutBtn = driver.findElement(By.id("logout_link"));
        logoutBtn.click();

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}