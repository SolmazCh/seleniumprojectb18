package test.day6_TestNG_dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class Task2 {

//TC #2: Selecting state from State dropdown and verifying result

    WebDriver driver;

//1. Open Chrome browser
//2. Go to http://practice.cybertekschool.com/dropdown
    @BeforeMethod
    public  void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public  void tearDown()throws InterruptedException{
        Thread.sleep(2000);
        driver.close();
    }



    @Test
    public void test1() throws InterruptedException{
        //3. Select Illinois
        //4. Select Virginia
        //5. Select California
        //6. Verify final selected option is California.
        //Use all Select options. (visible text, value, index)
        Select statedropDown = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        statedropDown.selectByVisibleText("Illinois");
        Thread.sleep(2000);
        statedropDown.selectByValue("VA");
        Thread.sleep(2000);
        statedropDown.selectByIndex(5);
        String actualStateText = statedropDown.getFirstSelectedOption().getText();
        String expectedStateText = "California";
        Assert.assertEquals(actualStateText,expectedStateText);
    }





}
