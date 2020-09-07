package test.VyTrack.UserStory3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Vehicle_Odometer_Info1 {
    //"1. Verify that truck driver should be able to see all vehicle odometer information on the grid.
    //1.1.Open chrome browser
    //  2.Go to:  https://qa2.vytrack.com/user/login
    //  3.login as a truck driver with username: user157  password: UserUser123
    //  4. Go to  -> Vehicle Odometer <-  under the module -> Fleet
    //  5. Verify odometer information on the grid

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        //Go to:  https://qa2.vytrack.com/user/login
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

   @AfterClass
    public void tearDown() throws InterruptedException{
    Thread.sleep(2000);
    driver.quit();
       }

    @Test(priority = 1)
    public void login() {
        //insert "user157" to login
        WebElement logInElement = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        logInElement.sendKeys("user157");

        // insert "UserUser123" as password
        WebElement passwordElement = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        passwordElement.sendKeys("UserUser123");

        // click the log in button
        WebElement logInButtonElement = driver.findElement(By.xpath("//button[@type='submit']"));
        logInButtonElement.click();

    }


    @Test(priority = 2)
    public void FleetTest() throws InterruptedException{
        // click the Fleet button and choose vehicle odometer button
        WebElement fleetButtonElement = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
        fleetButtonElement.click();

        WebElement vehicleOdometerButton = driver.findElement(By.xpath("//span[.='Vehicle Odometer']"));
        vehicleOdometerButton.click();

        Thread.sleep(2000);
        String actualTitle = driver.getTitle();
        String expectedTitle ="Vehicle Odometer - Entities - System - Car - Entities - System";
        Assert.assertEquals(actualTitle,expectedTitle);

    }


    @Test(priority = 3)
       //Verify that truck driver should be able to see all vehicle odometer information on the grid.
       public void FleetInformationTest() throws InterruptedException {

        List<WebElement> listOfInfoButtons = driver.findElements(By.xpath("//body//tbody//tr"));
             for (int i = 1; i < listOfInfoButtons.size(); i++) {
                 System.out.println("Odometer info: "+listOfInfoButtons.get(i).getText());
                 Thread.sleep(1000);

        }
    }





}
