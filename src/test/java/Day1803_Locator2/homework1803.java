package Day1803_Locator2;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class homework1803 {
    WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void tc02() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Assert.assertEquals(driver.getTitle(), "OrangeHRM");
        Thread.sleep(5000);
        WebElement userNameTxt = driver.findElement(By.name("username"));
        WebElement passwordTxt = driver.findElement(By.name("password"));
        userNameTxt.sendKeys("Admin");
        passwordTxt.sendKeys("admin123");
        passwordTxt.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        WebElement dashboard = driver.findElement(By.xpath("//aside[@class='oxd-sidepanel']"));
        Assert.assertTrue(dashboard.isDisplayed());
        WebElement PIMTab = driver.findElement(By.xpath("//span[text()='PIM']/ancestor::a"));
        if(!PIMTab.getAttribute("class").contains("active")) {
            PIMTab.click();
        }
        Thread.sleep(3000);

        WebElement reGetPIMTab = driver.findElement(By.xpath("//span[text()='PIM']/ancestor::a"));
        Assert.assertTrue(reGetPIMTab.getAttribute("class").contains("active"));

        WebElement addEmployeeTab = driver.findElement(By.xpath("//a[text()='Add Employee']"));
        addEmployeeTab.click();

        Thread.sleep(3000);
        WebElement firstNameTxt = driver.findElement(By.xpath("//input[@name='firstName']"));
        WebElement middleNameTxt = driver.findElement(By.xpath("//input[@name='middleName']"));
        WebElement lastNameTxt = driver.findElement(By.xpath("//input[@name='lastName']"));

        String firstName = "Auto";
        String middleName = "Abc";
        String lastName = "Tester";

        firstNameTxt.click();
        firstNameTxt.sendKeys(firstName);

        middleNameTxt.click();
        middleNameTxt.sendKeys(middleName);

        lastNameTxt.click();
        lastNameTxt.sendKeys(lastName);

        WebElement saveBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        saveBtn.click();

        Thread.sleep(10000);
        Assert.assertTrue(driver.getCurrentUrl().contains("viewPersonalDetails"), "Current url: " + driver.getCurrentUrl() + ", not contains viewPersonalDetails");
        WebElement employeeName = driver.findElement(By.xpath("//div[@class='orangehrm-edit-employee-name']/h6"));

        Assert.assertEquals(employeeName.getText(), firstName + " " + lastName);
    }

    @Test
    public void tc03() throws InterruptedException {
        driver.get("https://www.globalsqa.com/samplepagetest/");

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.globalsqa.com/samplepagetest/");

        String name = "Auto";
        String email = "abc@def.ghi";
        String website = "https://abcd.com";
        String expertise = "Functional Testing";
        String education = "Graduate";
        String comment = "this is the comment";

        WebElement nameTxt = driver.findElement(By.xpath("//div[contains(.,'Name')]/input"));
        WebElement emailTxt = driver.findElement(By.xpath("//div[contains(.,'Email')]/input"));
        WebElement websiteTxt = driver.findElement(By.xpath("//div[contains(.,'Website')]/input"));
        WebElement functionalTestingCB = driver.findElement(By.xpath("//input[@value='" + expertise + "']"));
        WebElement graduateRBtn = driver.findElement(By.xpath("//input[@value='" + education + "']"));
        WebElement commentTxt = driver.findElement(By.xpath("//textarea"));
        WebElement submitBtn = driver.findElement(By.xpath("//button[@type='submit']"));


        nameTxt.click();
        nameTxt.sendKeys(name);

        emailTxt.click();
        emailTxt.sendKeys(email);

        websiteTxt.click();
        websiteTxt.sendKeys(website);

        functionalTestingCB.click();

        graduateRBtn.click();

        //scroll down at the end of the page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");

        commentTxt.click();
        commentTxt.sendKeys(comment);

        submitBtn.click();

        Thread.sleep(5000);

        WebElement contactForm = driver.findElement(By.xpath("//div[contains(@id,'contact-form')]"));
        Assert.assertTrue(contactForm.isDisplayed());

        WebElement responseNameTxt = driver.findElement(By.xpath("//p[contains(.,'Name')]"));
        WebElement responseEmailTxt = driver.findElement(By.xpath("//p[contains(.,'Email')]"));
        WebElement responseWebsiteTxt = driver.findElement(By.xpath("//p[contains(.,'Website')]"));
        WebElement responseExpertiseTxt = driver.findElement(By.xpath("//p[contains(.,'Expertise')]"));
        WebElement responseEducationTxt = driver.findElement(By.xpath("//p[contains(.,'Education')]"));
        WebElement responseCommentTxt = driver.findElement(By.xpath("//p[contains(.,'Comment')]"));

        Assert.assertTrue(responseNameTxt.getText().contains(name));
        Assert.assertTrue(responseEmailTxt.getText().contains(email));
        Assert.assertTrue(responseWebsiteTxt.getText().contains(website));
        Assert.assertTrue(responseExpertiseTxt.getText().contains(expertise));
        Assert.assertTrue(responseEducationTxt.getText().contains(education));
        Assert.assertTrue(responseCommentTxt.getText().contains(comment));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
