package test.day11_page_object_model;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class TC35ForgotPasswordVerify {
    //TC#35 : Vytrack forgot password page verifications à TITLE and URL
    //1. Go to https://qa3.vytrack.com
    //2. Click to “Forgot your password?” link
    //3. Verify title changed to expected
    //Expected: “Forgot Password”
    //4. Verify url is as expected:
    //Expected: “https://qa3.vytrack.com/user/reset-request”
    //Note: Follow Page Object Model design pattern

    @Test
    public void forgot_password_verify()throws InterruptedException{

        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));

        LoginPage loginPage = new LoginPage();

        loginPage.forgotYourPasswordLink.click();

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle ="Forgot Password";

        Thread.sleep(2000);
        Assert.assertEquals(actualTitle,expectedTitle);
        Thread.sleep(2000);
        String actualURL =Driver.getDriver().getCurrentUrl();
        String expectedUrl ="https://qa2.vytrack.com/user/reset-request";
        Assert.assertEquals(actualURL,expectedUrl);

        Driver.closeDriver();

    }





}
