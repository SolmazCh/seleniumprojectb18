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

public class SelectedStateFromState {
    /*
    TC #2: Selecting state from State dropdown and verifying result
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
3. Select Illinois
4. Select Virginia
5. Select California
6. Verify final selected option is California.
Use all Select options. (visible text, value, index)
     */

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

    public  void test2_select_dropdown_verification() throws InterruptedException{


        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        Thread.sleep(2000);
        stateDropdown.selectByValue("IL");

        stateDropdown.selectByVisibleText("Virginia");

        stateDropdown.selectByIndex(5);


        String actualselectedDropDown =stateDropdown.getFirstSelectedOption().getText();
        String expectedSelectDropDown ="California";

        Assert.assertEquals(actualselectedDropDown,expectedSelectDropDown);

        Assert.assertTrue(actualselectedDropDown.equalsIgnoreCase(expectedSelectDropDown));








    }




}
