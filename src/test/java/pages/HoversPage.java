package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HoversPage {

    public HoversPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

        @FindBy(xpath = "//div[@class='figure'][1]")
                public WebElement img1;

        @FindBy(xpath = "//div[@class='figure'][2]")
                public WebElement img2;

         @FindBy(xpath = "//div[@class='figure'][3]")
                public WebElement img3;

         @FindBy(xpath = "//h5[.='name: user1']")
                 public WebElement user1;

         @FindBy(xpath = "//h5[.='name: user2']")
                 public WebElement user2;

         @FindBy(xpath = "//h5[.='name: user3']")
                  public WebElement user3;

    }

