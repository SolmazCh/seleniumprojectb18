package test.day7_javafaker_webtables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class T7_month_dropdown {
    //TC#7: Cybertek “month” dropdown default value
    WebDriver driver;
    @BeforeClass
    public void setUp() {
        //1. Open browser
        //2. Go to website: http://practice.cybertekschool.com/dropdowns
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

  /*  @AfterClass
    public void tearDown() throws InterruptedException{
        Thread.sleep(2000);
        driver.close();
    }*/


    @Test
    public void month_default_values_test() {
        //3. Verify default value is always showing the current month
        //o Expected: If currently in June, should show June selected.
        Select month = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        String actualMonth = month.getFirstSelectedOption().getText();
        String expectedMonth = LocalDate.now().getMonth().toString();
        Assert.assertTrue(actualMonth.equalsIgnoreCase(expectedMonth));
    }


    //TC#8: Cybertek “month” dropdown list of default values verification
    //1. Do both verifications in the same test
    //2. Verify list of months are correct as expected.
    //o Expected: Options should contain all 12 months of the year.

    @Test
    public void month_list_verification(){
        month_default_values_test();
        List<String> expectedMonth = new ArrayList<>();
        expectedMonth.addAll(Arrays.asList("January","February","March","April","May",
                "June","July","August","September","October","November"));
        List<WebElement> actualMonth = driver.findElements(By.xpath("//select[@id='month']//option"));
        for(int i=0; i<expectedMonth.size(); i++){
            Assert.assertEquals(actualMonth.get(i).getText(), expectedMonth.get(i));
            System.out.println(actualMonth.get(i).getText().equals(expectedMonth.get(i)));
        }

    }


}