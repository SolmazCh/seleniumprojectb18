package test.day8_alerts_iframes_windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class iFramePractice {
    //TC #4 : Iframe practice --> inline Frame
    //1. Create a new class called: IframePractice
    //2. Create new test and make set ups

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        //2. Go to website:
        //3. Go to: http://practice.cybertekschool.com/iframe
        driver.get("http://practice.cybertekschool.com/iframe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

   @AfterMethod
    public void tearDown() throws Exception {
        // close browser
        Thread.sleep(2000);
        driver.close();
    }


    @Test
    public void iFrame() {
        //4. Assert: “Your content goes here.”
        WebElement iframe =driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        //switvhing to iframe using webelement
        driver.switchTo().frame(iframe);

        //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor
       WebElement yourContentGoesHereText = driver.findElement(By.xpath("//p"));
      Assert.assertTrue(yourContentGoesHereText.isDisplayed());
      driver.switchTo().parentFrame();

      WebElement h3Text = driver.findElement(By.xpath("//h3"));

        Assert.assertTrue(h3Text.isDisplayed());

    }
}