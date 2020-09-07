package test.VyTrack.UserStory3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Vehicle_Info_Visible1{
    //"1. Verify that truck driver should be able to see all vehicle odometer information on the grid.
    //2.Verify that Truck driver should be able to create Vehicle odometer or cancel it.
    //3.Verify that truck driver should be able to delete or edit Vehicle odometer.
    //4.Verify that truck driver should be able to reset grid by click on grid setting"

    WebDriver driver;

    @BeforeClass
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

/*@AfterClass
    public void tearDown() throws InterruptedException{
    // quit the page
    Thread.sleep(2000);
    driver.quit();
}*/

    @Test(priority = 1)
    public void login() {

        WebElement logInElement = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        logInElement.sendKeys("user159");

        WebElement passwordElement = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        passwordElement.sendKeys("UserUser123");

        WebElement logInButtonElement = driver.findElement(By.xpath("//button[@type='submit']"));
        logInButtonElement.click();

    }

    @Test(priority = 2)
    public void FleetTest1() throws InterruptedException{

        Thread.sleep(2000);
        WebElement fleetButtonElement = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
        fleetButtonElement.click();

        WebElement vehicleOdometerButton = driver.findElement(By.xpath("//span[.='Vehicle Odometer']"));
        vehicleOdometerButton.click();

        Thread.sleep(2000);
        String actualTitle = driver.getTitle();
        String expectedTitle = "Vehicle Odometer - Entities - System - Car - Entities - System";
        Assert.assertEquals(actualTitle, expectedTitle);

    }


    @Test(priority = 3)
    //1. Verify that truck driver should be able to see all vehicle odometer information on the grid.
    public void FleetInformationTest() throws InterruptedException {
        List<WebElement> listOfInfoButtons = driver.findElements(By.xpath("//body//tbody//tr"));
        for (int i = 1; i < listOfInfoButtons.size(); i++) {
            listOfInfoButtons.get(i);
            Thread.sleep(1000);
            //driver.navigate().back();
        }
    }


    @Test(priority = 4)
    //2.Verify that Truck driver should be able to create Vehicle odometer or cancel it.
    public void createVehicleOdometer() throws InterruptedException {
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
        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "Vehicle Odometer - Entities - System - Car - Entities - System";
        Assert.assertEquals(actualTitle2, expectedTitle2);

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


    @Test(priority = 5)
    public void FleetTest() throws InterruptedException{
        //3.Verify that truck driver should be able to delete or edit Vehicle odometer.
        //4.Verify that truck driver should be able to reset grid by click on grid setting"


        WebElement editBUtton = driver.findElement(By.xpath("//a[@title='Edit Vehicle Odometer']"));
        editBUtton.click();
        Thread.sleep(2000);

        WebElement deleteButton = driver.findElement(By.xpath("//a[@title='Delete Vehicle Odometer']"));
        deleteButton.click();

        WebElement deleteconfirm = driver.findElement(By.xpath("//a[.='Yes, Delete']"));
        deleteconfirm.click();

        Thread.sleep(2000);
        WebElement gridSettingButton = driver.findElement(By.xpath("//a[@title='Grid Settings']"));
        gridSettingButton.click();
        Thread.sleep(3000);

        List<WebElement> listOfGrids = driver.findElements(By.xpath("//table//tbody//tr[@class='renderable']"));

        for (WebElement eachGrid : listOfGrids) {
            System.out.println(eachGrid.getText());
            Thread.sleep(1000);
            eachGrid.click();
        }

    }


}