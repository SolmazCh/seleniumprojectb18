package test.day9_testbase_properties_driverUtil;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.base.TestBase;

import java.util.Set;

public class WindowHandleWarmup extends TestBase {

    //TC-WarmUp # : Window Handle practice
    //1. Create a new class called: WindowHandleWarmup
    //2. Create new test and make set ups
    //3. Go to : https://www.amazon.com
    //4. Copy paste the lines from below into your class

    @BeforeMethod
    @Override
    public void setUpMethod() {
        super.setUpMethod();
    }

    @AfterMethod
    @Override
    public void tearDownMethod() {
        super.tearDownMethod();
    }

    @Test
    public void multiple_window_test() {


        driver.get("https://www.amazon.com");

        // we are down casting our driver to JavascriptExecuter to be able to use its methods
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");
        //5. Create a logic to switch to the tab where Etsy.com is open
        Set<String> windowHandles = driver.getWindowHandles();

        for(String each: windowHandles){
                driver.switchTo().window(each);
                System.out.println("current title: "+driver.getTitle());

                if(driver.getCurrentUrl().contains("etsy")){
                    //6. Assert: Title contains “Etsy”
                    String actualTitle =driver.getTitle();
                    Assert.assertTrue(actualTitle.contains("Etsy"));
                    break;
                }

        }


    }
}