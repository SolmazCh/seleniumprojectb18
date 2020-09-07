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

public class delete_edit3_gridSettings4 {
    //3.Verify that truck driver should be able to delete or edit Vehicle odometer.
    //4.Verify that truck driver should be able to reset grid by click on grid setting"

    //3.1.Open chrome browser
    //  2.Go to:  https://qa2.vytrack.com/user/login
    //  3.login as a truck driver with username: user158  password: UserUser123
    //  4. Go to  -> Vehicle Odometer <-  under the modul  -> Fleet
    //  5. Click on one of the vehicle odometer information
    //  6. Verify that truck driver should be able to delete or edit Vehicle odometer.
    //4.1. Click to the ->Grid settings<- button
    //  2. Verify that truck driver should be able to reset grid


    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // 1.open Chrome driver
        driver = WebDriverFactory.getDriver("chrome");
        //2. go to https://qa2.vytrack.com/user/login
        driver.get("https://qa2.vytrack.com/user/login");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test(priority = 1)
    public void login(){
        //insert "user158" to login
        WebElement logInElement = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        logInElement.sendKeys("user158");
        // insert "UserUser123" as password
        WebElement passwordElement = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        passwordElement.sendKeys("UserUser123");
        // click the log in button
        WebElement logInButtonElement = driver.findElement(By.xpath("//button[@type='submit']"));
        logInButtonElement.click();

    }


    @Test(priority = 2)
    public void FleetTest() throws InterruptedException{

        Thread.sleep(2000);
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


        Thread.sleep(2000);
        WebElement gridInfo = driver.findElement(By.xpath("//tr[@class='grid-row row-click-action'][1]"));
        gridInfo.click();

        WebElement editBUtton = driver.findElement(By.xpath("//a[@title='Edit Vehicle Odometer']"));
        editBUtton.click();
        Thread.sleep(2000);

        WebElement deleteButton =driver.findElement(By.xpath("//a[@title='Delete Vehicle Odometer']"));
        deleteButton.click();

        WebElement deleteconfirm = driver.findElement(By.xpath("//a[.='Yes, Delete']"));
        deleteconfirm.click();

        Thread.sleep(2000);
        WebElement gridSettingButton = driver.findElement(By.xpath("//a[@title='Grid Settings']"));
        gridSettingButton.click();
        Thread.sleep(3000);


        List<WebElement> listOfGrids = driver.findElements(By.xpath("//table//tbody//tr[@class='renderable']"));

        for(WebElement eachGrid: listOfGrids){
            System.out.println(eachGrid.getText());
            Thread.sleep(1000);
            eachGrid.click();
        }
    }






}
