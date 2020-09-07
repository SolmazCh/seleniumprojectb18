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

public class T8_SmartBear_Delete_Order {
    //TC #9: SmartBear delete order
    //1. Open browser and login to SmartBear
    //2. Delete “Mark Smith” from the list
    //3. Assert it is deleted from the list
 WebDriver driver;

    @BeforeClass
    public void setUp(){
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
    public void deleteOrder(){
        WebElement MarkSmithclickButton = driver.findElement(By.xpath("//td[.='Mark Smith']/..//td[1]"));
        MarkSmithclickButton.click();

        WebElement deleteButton = driver.findElement(By.id("ctl00_MainContent_btnDelete"));
        deleteButton.click();

        List<WebElement> nameList = driver.findElements(By.xpath("//td//td[2]"));

        for(WebElement eachName: nameList){
            if(!eachName.getText().equals("Mark Smith")){
                Assert.assertFalse(eachName.getText().equals("Mark Smith"));
            }
        }



    }
}
