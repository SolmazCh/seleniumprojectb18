package test.day11_page_object_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class NegativeLoginTests {

    LoginPage loginPage;

    @Ignore
    @Test
    public void negative_lpgin_test() throws InterruptedException{

        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));

        WebElement userNameInput = Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput']"));
        WebElement passwordInput = Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput2']"));
        WebElement loginButton = Driver.getDriver().findElement(By.id("_submit"));

        String username =ConfigurationReader.getProperty("storemanager_username");
        userNameInput.sendKeys(username);

        Thread.sleep(2000);
        passwordInput.sendKeys("hfhsjsjj");
        loginButton.click();

        Thread.sleep(2000);
        WebElement errorMessage = Driver.getDriver().findElement(By.xpath("//div[@class='alert alert-error']"));

        Thread.sleep(2000);
        Assert.assertTrue(errorMessage.isDisplayed(), "Assert message is NOt displayed");

    }


    @Test
    public void negative_login_test_with_page_object(){
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));

        loginPage = new LoginPage();

        //sending username
        String username = ConfigurationReader.getProperty("storemanager_username");

        loginPage.usernameInput.sendKeys(username);

        //send our incorrect password
        loginPage.passwordInput.sendKeys("shjshjn");

        //click using our loginpage object
        loginPage.loginButton.click();

        //asserting error message isDisplayed
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());

        //asserting the text value of the error message
        String actualText = loginPage.errorMessage.getText();
        String expectedText ="Invalid user name or password.";

        Assert.assertEquals(actualText,expectedText);


    }



    @Test
    public void tc31_wrong_username_test(){
       //TC#31 : Vytrack negative login test à Wrong Username Test
        //1. Go to https://qa3.vytrack.com
        //2. Enter incorrect username
        //3. Enter correct password
        //4. Verify error message text is as expected
        //Expected: “Invalid user name or password.”
        //Note: Follow Page Object Model design pattern
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));
        loginPage =new LoginPage();

        String username ="agshdj";
        String password =ConfigurationReader.getProperty("storemanager_password");
        loginPage.login(username,password);

        Assert.assertTrue(loginPage.errorMessage.isDisplayed());

        String actualText = loginPage.errorMessage.getText();
        String expectedText ="Invalid user name or password.";
        Assert.assertEquals(actualText,expectedText);

    }







    }
