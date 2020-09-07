package test.day7_javafaker_webtables;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.SmartBearUtilities;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class printNamesAndCitiesTask5 {

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

    public void TestTheMethod(){
       SmartBearUtilities.printNamesAndCities(driver);
    }











}
