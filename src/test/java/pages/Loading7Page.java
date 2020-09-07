package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Loading7Page {

    public Loading7Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // Done message
    @FindBy(xpath = "//strong[.='Done!']")
    public WebElement doneMessage;

    //Sponge Bob image
    @FindBy(xpath = "//img[@class='rounded mx-auto d-block']")
    public WebElement spongeBobImage;







}
