package test.day10_jsexecutor_upload_actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class Uploading {


    @Test

    public void uploading_test()throws InterruptedException{

        Driver.getDriver().get("http://practice.cybertekschool.com/upload");
        Driver.getDriver().manage().window().maximize();

        WebElement choosFile = Driver.getDriver().findElement(By.id("file-upload"));
        Thread.sleep(3000);
        choosFile.sendKeys("C:\\Users\\solma_kxvrxkn\\Desktop\\Test");

        WebElement fileUpload = Driver.getDriver().findElement(By.id("file-submit"));
        fileUpload.click();

        WebElement uploadedMessage = Driver.getDriver().findElement(By.xpath("//div[@class='example']"));
        Assert.assertTrue(uploadedMessage.isDisplayed());

    }



}
