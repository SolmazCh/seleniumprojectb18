package test.day11_page_object_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.Driver;

public class ActionsPractices {


    @Test
    public void scrolling_with_actions()throws InterruptedException{
        //get our page
        Driver.getDriver().get("http://practice.cybertekschool.com/");
        Driver.getDriver().manage().window().maximize();

        //creating actions instance to be able to use its methods
        Actions actions = new Actions(Driver.getDriver());

        //locating the web element we want to scroll its methods
        WebElement cybertekSchoolLink = Driver.getDriver().findElement(By.linkText("Cybertek School"));
        WebElement inputs =Driver.getDriver().findElement(By.linkText("Inputs"));

        Thread.sleep(2000);
        //using actions instance we use moveToElement method
        actions.moveToElement(cybertekSchoolLink).perform(); //evveli versionloarda build().perform() idi indi tek perform()


        Thread.sleep(2000);
        actions.moveToElement(inputs).click().perform();

       Driver.closeDriver();



    }



}
