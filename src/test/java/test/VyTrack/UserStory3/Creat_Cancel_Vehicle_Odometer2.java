package test.VyTrack.UserStory3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class Creat_Cancel_Vehicle_Odometer2 {
    //2.Verify that Truck driver should be able to create Vehicle odometer or cancel it.
    //2.1.Open chrome browser
    //  2.Go to:  https://qa2.vytrack.com/user/login
    //  3.login as a truck driver with username: user159  password: UserUser123
    //  4. Go to  -> Vehicle Odometer <-  under the modul  -> Fleet
    //  5. Click to -> Create Vehicle Odometer
    //  6. Verify that Truck driver should be able to create Vehicle odometer or cancel it.

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // 1.open Chrome driver
        //2. go to https://qa2.vytrack.com/user/login
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

  /* @AfterClass
    public void tearDown(){
        driver.quit();
    }*/

        @Test (priority = 1)
        public void login(){

            //insert "user159" to login
            WebElement logInElement = driver.findElement(By.xpath("//input[@id='prependedInput']"));
            logInElement.sendKeys("user159");

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

        //Assert actual and expected Title
       String actualTitle = driver.getTitle();
       String expectedTitle ="Vehicle Odometer - Entities - System - Car - Entities - System";
       Assert.assertEquals(actualTitle,expectedTitle);

    }

     @Test(priority = 3)

    public void createVehicleOdometer() throws InterruptedException{
         // click to "create vehicle odometer" button
        WebElement createVehicleOdometerButton = driver.findElement(By.xpath("//a[@title='Create Vehicle Odometer']"));
        createVehicleOdometerButton.click();

        // verify the page title is  "Vehicle Odometer - Entities - System - Car - Entities - System"
        String actualTitle = driver.getTitle();
        String expectedTitle = "Vehicle Odometer - Entities - System - Car - Entities - System";
        Assert.assertEquals(actualTitle, expectedTitle);
         Thread.sleep(3000);

        //click to cancel button to cancel the creating of vehicle odometer
         WebElement cancelButton = driver.findElement(By.xpath("//a[@title='Cancel']"));
        cancelButton.click();
        Thread.sleep(2000);


        //Assert actual and expected Title
        String actualTitle2 =driver.getTitle();
        String expectedTitle2 = "Vehicle Odometer - Entities - System - Car - Entities - System";
        Assert.assertEquals(actualTitle2,expectedTitle2);

        //Create vehicle odometer info
        Thread.sleep(4000);
         WebElement createVehicleOdometerButton2 = driver.findElement(By.xpath("//a[@title='Create Vehicle Odometer']"));
         createVehicleOdometerButton2.click();

         Thread.sleep(2000);
         WebElement odometerValueInput = driver.findElement(By.xpath("//input[@name='custom_entity_type[OdometerValue]']"));
         odometerValueInput.sendKeys("123456");

         Thread.sleep(2000);
         WebElement DateInput = driver.findElement(By.xpath("//input[@placeholder='Choose a date']"));
         DateInput.click();

         WebElement date = driver.findElement(By.xpath("//a[.='8']"));
         date.click();


         WebElement driverInput = driver.findElement(By.xpath("//input[@name='custom_entity_type[Driver]']"));
         driverInput.sendKeys("Soli");

         WebElement saveAndCloseButton = driverInput.findElement(By.xpath("//button[@class='btn btn-success action-button']"));
         saveAndCloseButton.click();
     }












}
