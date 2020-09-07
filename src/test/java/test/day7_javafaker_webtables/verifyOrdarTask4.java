package test.day7_javafaker_webtables;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.SmartBearUtilities;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class verifyOrdarTask4 {
     //PRACTICE #4: Method: verifyOrder
    //• Create a method named verifyOrder in SmartBearUtils class.
    //• Method takes WebDriver object and String(name).
    //• Method should verify if given name exists in orders.
    //• This method should simply accepts a name(String), and assert whether
    //given name is in the list or not.
    //• Create a new TestNG test to test if the method is working as expected.

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        SmartBearUtilities.login(driver);
    }

    @AfterClass
    public void tearDown() throws InterruptedException{
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void Test1(){
        SmartBearUtilities.verifyOrder(driver, "Paul Brown");
    }
}
