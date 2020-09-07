package test.day7_javafaker_webtables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.SmartBearUtilities;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class SmartBearOrderVerify {
    //TC#3: Smartbear software order verification
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        //1. Open browser and login to Smartbear software
        //2. Click on View all orders
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        SmartBearUtilities.login(driver);

    }

    @Test
    public void webTable(){
        //3. Verify Susan McLaren has order on date “01/05/2010”

        WebElement McLarenOrderElement = driver.findElement(By.xpath("//td[.='Susan McLaren']/../td[5]"));
        String actualText = McLarenOrderElement.getText();
        String expectedText ="01/05/2010";

        Assert.assertEquals(actualText,expectedText);
    }









}
