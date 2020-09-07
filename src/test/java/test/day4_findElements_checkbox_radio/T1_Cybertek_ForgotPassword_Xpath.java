package test.day4_findElements_checkbox_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class T1_Cybertek_ForgotPassword_Xpath {
    //XPATH PRACTICES DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
    // #1: Practice Cybertek.com_ForgotPassword WebElement verification
    // 1. Open Chrome browser
    // 2. Go to http://practice.cybertekschool.com/forgot_password
    // 3. Locate all the WebElements on the page using XPATH locator only (total of 6)
    // a. “Home” link
    // b. “Forgot password” header
    // c. “E-mail” text
    // d.E-mail input box
    // e. “Retrieve password” button
    // f. “Powered by Cybertek School” text
    // 4. Verify all WebElements are displayed.

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/forgot_password");

       WebElement HomeElement = driver.findElement(By.xpath("//a[@class='nav-link']")); //Home Element

       WebElement ForgotPasswordElement =driver.findElement(By.xpath("//div[@id='content']"));

       WebElement EmailElement = driver.findElement(By.xpath("//label[.='E-mail']"));

       WebElement EmailInputBoxElement =driver.findElement(By.xpath("//input[@type='text']"));

       WebElement RetrievePasswordButtonElement = driver.findElement(By.xpath("//i[.='Retrieve password']"));

       WebElement CybertekSchoolElement =driver.findElement(By.xpath("//div[@style='text-align: center;']"));

        if(HomeElement.isDisplayed() && ForgotPasswordElement.isDisplayed() && EmailElement.isDisplayed() &&
        EmailInputBoxElement.isDisplayed() && RetrievePasswordButtonElement.isDisplayed() && CybertekSchoolElement.isDisplayed()){
            System.out.println("All of the elements are displayed, verification Passed!");
        }else{
            System.out.println("One or more element are not displayed, verificatin Passed!");
        }



        /*System.out.println("Home element is displayed: "+HomeElement.isDisplayed());
        System.out.println("Forgot Password element is displayed: "+ForgotPasswordElement.isDisplayed());
        System.out.println("Email element is displayed: "+EmailElement.isDisplayed());
        System.out.println("Email input box element is displayed: "+EmailInputBoxElement.isDisplayed());
        System.out.println("Retrieve password button is displayed: "+RetrievePasswordButtonElement.isDisplayed());
        System.out.println("Powered by Cybertek School element is displayed: "+CybertekSchoolElement.isDisplayed());*/




    }
}
