package test.day8_alerts_iframes_windows;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class AlertsPractices {


    //TC #1: Information alert practice
    //1. Open browser
    //2. Go to website: http://practice.cybertekschool.com/javascript_alerts
    WebDriver driver;
    @BeforeMethod
    public  void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

 //  @AfterMethod
    public void tearDown() throws Exception {
        // close browser
        Thread.sleep(2000);
        driver.close();
    }



    @Test (priority = 1)
    public void information_alert_practice1() {
        //3. Click to “Click for JS Alert” button
        WebElement JSAlertButton = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        JSAlertButton.click();
        //4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();
        //5. Verify “You successfuly clicked an alert” text is displayed.
        WebElement succesText = driver.findElement(By.xpath("//p[.='You successfuly clicked an alert']"));

        System.out.println(succesText.isDisplayed());
    }



    @Test (priority = 2)
    public  void confirmation_alert_practice2(){
        WebElement confirmalertButton = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        //3. Click to “Click for JS Confirm” button
        confirmalertButton.click();
        //4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();
        //5. Verify “You clicked: Ok” text is displayed.
        WebElement succesText = driver.findElement(By.xpath("//p[.='You clicked: Ok']"));
        Assert.assertTrue(succesText.isDisplayed());
    }

    @Test(priority = 3)
    public void information_promt_practice3() throws InterruptedException{
        //3. Click to “Click for JS Prompt” button
        WebElement promtButton = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        promtButton.click();
        //4. Send “hello” text to alert
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");
        Thread.sleep(6000);
        //5. Click to OK button from the alert
        alert.accept();
        //6. Verify “You entered: hello” text is displayed.
        WebElement helloText = driver.findElement(By.xpath("//p[.='You entered: hello']"));
        Assert.assertTrue(helloText.isDisplayed());
    }
}
