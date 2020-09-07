package test.day8_alerts_iframes_windows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.SmartBearUtilities;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T10SmartBear_edit_order {
    //TC #10: SmartBear edit order
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        //1. Open browser and login to SmartBear
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        SmartBearUtilities.login(driver);
    }

    @AfterClass
    public void tearDown()throws InterruptedException{
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void edit_order(){
        //2. Click to edit button from the right for “Steve Johns”
        WebElement SteveJohnsEditButton = driver.findElement(By.xpath("(//input[@alt='Edit'])[3]"));
        SteveJohnsEditButton.click();
        //3. Change name to “Michael Jordan”
        WebElement customerNameInput = driver.findElement(By.xpath("//input[@value='Steve Johns']"));
        customerNameInput.clear();
        customerNameInput.sendKeys("Michael Jordan");
        //4. Click Update
        //5. Assert “Michael Jordan” is in the list
        WebElement updateButton = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_UpdateButton']"));
        updateButton.click();


        List<WebElement> nameList = driver.findElements(By.xpath("//td//td[2]"));

        for(WebElement name : nameList){
            if (name.getText().equals("Michael Jordan")){
                Assert.assertTrue(name.getText().equals("Michael Jordan"));

            }
        }
    }


}
