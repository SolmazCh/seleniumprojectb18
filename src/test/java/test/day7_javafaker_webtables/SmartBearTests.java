package test.day7_javafaker_webtables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearTests {

    //TC #1: Smartbear software link verification
    WebDriver driver;
    @BeforeClass
    public  void setUp() {
        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void p1_smartbear_login_test() {
        //3. Enter username: “Tester”
      WebElement userNameButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
      userNameButton.sendKeys("Tester");
        //4. Enter password: “test”
        WebElement passwordButton = driver.findElement(By.xpath("//input[@type='password']"));
        passwordButton.sendKeys("test");
        //5. Click to Login button
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();
        //6. Print out count of all the links on landing page
       List<WebElement>  links =  driver.findElements(By.xpath("//body//a"));
        System.out.println("links counts: "+ links.size());
        //7. Print out each link text on this page

        for(WebElement eachLink: links){
            System.out.println(eachLink.getText());
        }
    }


}