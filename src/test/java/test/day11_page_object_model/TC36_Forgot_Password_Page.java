package test.day11_page_object_model;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class TC36_Forgot_Password_Page  {
    //TC#36 : Vytrack forgot password page verification à ERROR MESSAGE
    //1. Go to https://qa3.vytrack.com/user/reset-request
    //2. Enter random username
    //3. Click to request button
    //4. Verify error message is displayed
    //5. Verify error message text is as expected.
    //Expected: There is no active user with username or email address “given text”.
    //Note: Follow Page Object Model design pattern

    @Test
    public void forgot_password_error_message(){
        Driver.getDriver().get(ConfigurationReader.getProperty("forgotpassword_url"));
        ForgotPasswordPage forgotPasswordPage =new ForgotPasswordPage();

        String randomuserName ="dhjdhj";
        forgotPasswordPage.userOrEmailInput.sendKeys(randomuserName);
        forgotPasswordPage.requestButton.click();
        Assert.assertTrue(forgotPasswordPage.errorMessage.isDisplayed());

        String actualErrorText =forgotPasswordPage.errorMessage.getText();
        String expectedErrorText ="There is no active user with username or email address \""+randomuserName+"\".";

        Assert.assertEquals(actualErrorText,expectedErrorText);
        Driver.closeDriver();
    }
}
