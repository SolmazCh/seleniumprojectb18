package test.day6_TestNG_dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class TestNGSeleniumPractice {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //Goal is to open new browser for each test
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.google.com");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(2000);
        driver.close();
    }


        @Test (priority = 2)
        public void google_title_test () {
            //go to google
            // make sure title is "Google"

            String expectedTitle = "Google";
            String actualTitle = driver.getTitle();
            Assert.assertEquals(actualTitle, expectedTitle);
        }


        @Test (priority = 1)
        public void google_search_title_verification () {
            // 1- Open browser
            // 2- go to https://google.com
            // 3-search apple
            WebElement appleSearchBox = driver.findElement(By.name("q"));
            // 4- verify title contains apple
            appleSearchBox.sendKeys("apple" + Keys.ENTER);

            String expectedinTitle = "apple";
            String actualTitle = driver.getTitle();

            Assert.assertTrue(actualTitle.contains(expectedinTitle) );


        }
    }


