package test.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class TestBase {

   protected WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){

        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }


    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }



}
