package test.day7_javafaker_webtables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.SmartBearUtilities;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class smartBearOrderVerification {
   /*
TC#3: Smartbear software order verification
1.Open browser and login to Smartbear software
2.Click on View all orders
3.Verify Susan McLaren has order on date “01/05/2010”
 */

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // 1.Open browser
        //   2.Go to website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        SmartBearUtilities.login(driver);

    }
    @AfterMethod
    public void tearDown() throws Exception {
        // close browser
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void webTable() {
        //2.Click on View all orders

        WebElement CalcButton= driver.findElement(By.xpath("//li[@class='selected']/a"));
        CalcButton.click();

        //3.Verify Susan McLaren has order on date “01/05/2010”
        //td[.='Susan McLaren']/../td[5]
        String ExpectedTable="01/05/2010";
        String actualTable= driver.findElement(By.xpath("//td[.='Susan McLaren']/../td[5]")).getText();
        Assert.assertEquals(actualTable,ExpectedTable);

    }




}
