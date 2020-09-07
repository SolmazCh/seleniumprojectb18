package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ForgotPasswordPage {

    public ForgotPasswordPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //locating userNameOrEmail input box
    @FindBy(id = "prependedInput")
    public WebElement userOrEmailInput;

    //locating Request button
    @FindBy(xpath = "//button[.='Request']")
    public WebElement requestButton;

    //locating ReturnToLogin Link
    @FindBy(xpath = "//a[.='« Return to Login']")
    public WebElement ReturnToLoginLink;

    //locating Error message
    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement errorMessage;

}
