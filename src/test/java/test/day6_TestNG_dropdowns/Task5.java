package test.day6_TestNG_dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class Task5 {
    //TC #5: Selecting value from non-select dropdown

    WebDriver driver;

    //1. Open Chrome browser
    //2. Go to http://practice.cybertekschool.com/dropdown

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

   @AfterMethod
    public  void tearDown() throws InterruptedException{
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() {
        //3. Click to non-select dropdown
        WebElement linkSelectElement = driver.findElement(By.xpath("//a[@class='btn btn-secondary dropdown-toggle']"));
        linkSelectElement.click();
        //4. Select Facebook from dropdown
        WebElement facebookDropdownElement = driver.findElement(By.xpath("//a[@class='dropdown-item'][4]"));
        facebookDropdownElement.click();
        //5. Verify title is “Facebook - Log In or Sign Up”
        String actualTitle = driver.getTitle();
        String expectedTitle = "Facebook - Log In or Sign Up";
        Assert.assertEquals(actualTitle,expectedTitle);
    }


}