package test.day3_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P3CybertekURLVerification {

    public static void main(String[] args) {


//TC #3: PracticeCybertek/ForgotPassword URL verification
// 1.Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

// 2.Go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");
// 3.Enter any email into input box
      WebElement nameElement = driver.findElement(By.name("email"));
              nameElement.sendKeys("cyber@gmail.com");
// 4.Click on Retrieve password
      WebElement retrievePasswordButton =  driver.findElement(By.id("form_submit"));
              retrievePasswordButton.click();
// 5.Verify URL contains: Expected: “email_sent”
        if(driver.getCurrentUrl().contains("email_sent")){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

// 6.Verify textbox displayed the content as expected.Expected: “Your e-mail’s been sent!”


        WebElement confirmationMessage =  driver.findElement(By.name("confirmation_message"));
        String actualText  = confirmationMessage.getText();
        String expectedText ="Your e-mail's been sent!";

        if(actualText.equals(expectedText)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }


   if(confirmationMessage.isDisplayed()){
       System.out.println("Passed");
   }else{
       System.out.println("Failed");
   }






    }
}
