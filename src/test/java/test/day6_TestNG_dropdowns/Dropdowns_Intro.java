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
/*
TC#1: Verifying “Simple dropdown” and “State selection” dropdown default values
1.Open Chrome browser
2.Go to http://practice.cybertekschool.com/dropdown
3.Verify “Simple dropdown” default selected value is correctExpected: “Please select an option”
4.Verify“State selection” default selected value is correctExpected: “Select a State”
 */
public class Dropdowns_Intro {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
         driver = WebDriverFactory.getDriver("chrome");
         driver.get("http://practice.cybertekschool.com/dropdown");
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


   @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(2000);
        driver.close();
    }





    @Test
    public void test1_default_value_verification(){
        Select simpleDropdown = new Select(driver.findElement(By.xpath("//select[@id ='dropdown']")));

        String actualDefaultofSimpleDropDown = simpleDropdown.getFirstSelectedOption().getText();
        String expectedDefaultofSimpleDropDown ="Please select an option";

        Assert.assertEquals(actualDefaultofSimpleDropDown,expectedDefaultofSimpleDropDown);

        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        String actualDefaultOfStateDropDown = stateDropdown.getFirstSelectedOption().getText();
        String expectedDefaultOfStateDropDown ="Select a State";

        Assert.assertEquals(actualDefaultOfStateDropDown,expectedDefaultOfStateDropDown);




    }






}
