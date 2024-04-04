package Day2503_Selenium1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class homework2503 {

    WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
    }

    @Test
    public void hw01() throws InterruptedException {
        driver.get("https://jqueryui.com/selectmenu/");
        Thread.sleep(5000);
        WebElement iframe = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(iframe);

        WebElement speed = driver.findElement(By.id("speed-button"));
        speed.click();

        WebElement fast = driver.findElement(By.xpath("//div[text()='Fast']"));
        fast.click();

        WebElement selectedSpeed = driver.findElement(By.xpath("//span[@id='speed-button']/span[@class='ui-selectmenu-text']"));
        Assert.assertEquals(selectedSpeed.getText(), "Fast");

        Thread.sleep(5000);

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
