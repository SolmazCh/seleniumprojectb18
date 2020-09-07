package test.day6_TestNG_dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class Task4 {

    WebDriver driver;

    //TC #4: Selecting value from multiple select dropdown
    //1. Open Chrome browser
    //2. Go to http://practice.cybertekschool.com/dropdown

    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15000, TimeUnit.SECONDS);
    }

   @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1(){
        //3. Select all the options from multiple select dropdown.
        //4. Print out all selected values.
        Select multipleDropDownSelect = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));

        for(int i=0; i<6; i++) {
            multipleDropDownSelect.selectByIndex(i);
            System.out.println(multipleDropDownSelect.getAllSelectedOptions().get(i).getText());

        }
        //5. Deselect all values.
        multipleDropDownSelect.deselectAll();


    }



}
