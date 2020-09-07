package test.day8_alerts_iframes_windows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.SmartBearUtilities;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T11_removeName {


    //TC #11 : Create a method called removeName()
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

  /*  @AfterClass
    public void tearDown()throws InterruptedException{
        Thread.sleep(2000);
        driver.close();
    }*/


    public void removeName(WebDriver driver, String name){
        //1. Accepts two parameters: WebDriver, String name
        //2. Method will remove the given name from the list of Smartbear

        List<WebElement> nameList = driver.findElements(By.xpath("//td//td[2]"));
        List<WebElement> checkBoxes =driver.findElements(By.xpath("//input[@type='checkbox']"));
        WebElement deleteButton = driver.findElement(By.id("ctl00_MainContent_btnDelete"));

        for(int i=0; i<nameList.size(); i++){
            if(nameList.get(i).getText().equals(name)){
                checkBoxes.get(i).click();
                deleteButton.click();
                break;
            }
        }

    }


    @Test
    public void removeNameTest() {
        //3. Create a new TestNG test, and call your method.
        //4. Assert that your method removed the given name
        removeName(driver, "Bob Feather");
        List<WebElement> nameList = driver.findElements(By.xpath("//td//td[2]"));

        for(WebElement eachName: nameList){
            if(!eachName.getText().equals("Bob Feather")){
                Assert.assertFalse(eachName.getText().equals("Bob Feather"));
            }
        }

    }










}
