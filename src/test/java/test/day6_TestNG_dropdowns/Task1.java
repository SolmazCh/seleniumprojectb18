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

public class Task1 {

    //TC#1: Verifying “Simple dropdown” and “State selection” dropdown default values


    //1. Open Chrome browser
    //2. Go to http://practice.cybertekschool.com/dropdown

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(2000);
        driver.quit();
    }



    //3. Verify “Simple dropdown” default selected value is correct
    //Expected: “Please select an option”
    @Test
    public void Test1(){
        Select simpleDropDown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        String actualSelectedOption = simpleDropDown.getFirstSelectedOption().getText();
        String expectedOptionText = "Please select an option";
        Assert.assertEquals(actualSelectedOption,expectedOptionText);

        //4. Verify “State selection” default selected value is correct
        //Expected: “Select a State”

        Select stateDropDown = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        String actualStateDefaultText = stateDropDown.getFirstSelectedOption().getText();
        String expectedDefaultText ="Select a State";
        Assert.assertTrue(actualStateDefaultText.equals(expectedDefaultText));



    }















}
