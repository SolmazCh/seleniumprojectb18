package test.day8_alerts_iframes_windows;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class WebtablePractices {

    WebDriver driver;

    @BeforeMethod
    public  void setUp() {
        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }




}
