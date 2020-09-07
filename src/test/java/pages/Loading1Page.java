package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Loading1Page {
    public Loading1Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //Start button
    @FindBy(xpath = "//button[.='Start']")
    public WebElement startButton;

    //username input
    @FindBy(xpath = "//input[@type='username']")
    public WebElement usernameInput;

    //password input
    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordInput;

    //submit button
    @FindBy(xpath = "//button[.='Submit']")
    public WebElement submitButton;

    //loading bar
    @FindBy(id = "loading")
    public WebElement loadingBar;

    //
    @FindBy(id = "flash")
   public WebElement errorMessage;
}
