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

public class Task3 {
    //TC #3: Selecting date on dropdown and verifying

    WebDriver driver;

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
        driver.close();
    }

    @Test
    public void test(){
        //3. Select “December 1st, 1921” and verify it is selected.
        //Select year using : visible text
        //Select month using : value attribute
        //Select day using : index number
        Select yearSelect = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        yearSelect.selectByVisibleText("1921");
        String actualYearText = yearSelect.getFirstSelectedOption().getText();
        String expectedYearText ="1921";

        Assert.assertEquals(actualYearText,expectedYearText);

        Select monthSelect = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        monthSelect.selectByValue("11");
        String actualMonthText = monthSelect.getFirstSelectedOption().getText();
        String expectedMonthText = "December";

        Assert.assertEquals(actualMonthText,expectedMonthText);


        Select daySelect = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        daySelect.selectByIndex(0);

        String actualDayText = daySelect.getFirstSelectedOption().getText();
        String expectedDayText ="1";
        Assert.assertEquals(actualDayText,expectedDayText);


    }














}
