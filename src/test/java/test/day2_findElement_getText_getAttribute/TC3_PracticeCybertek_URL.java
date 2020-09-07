package test.day2_findElement_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC3_PracticeCybertek_URL {
    /*
    TC #3: Practice Cybertek/ForgotPassword URL verification
    1.Open Chrome browser
    2.Go to http://practice.cybertekschool.com/forgot_password
    3.Enter any email into input box
    4.Click on Retrieve password
    5.Verify URL contains: Expected: “email_sent”
    6.Verify textbox displayed the content as expected.Expected: “Your e-mail’s been sent!”
     */
    public static void main(String[] args) {

        //1.Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        //2.Go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");
        // 3.Enter any email into input box
        driver.findElement(By.name("email")).sendKeys("cybertek@gmail.com");
       // 4.Click on Retrieve password
        driver.findElement(By.id("form_submit")).click();
        // 5.Verify URL contains: Expected: “email_sent”

         String currentURL =driver.getCurrentUrl();
         String expectedURL ="email_sent";

         if(currentURL.contains(expectedURL)){
             System.out.println("URL Passed");
         }else{
             System.out.println("URL Failed!!!");
         }
      // 6.Verify textbox displayed the content as expected.Expected: “Your e-mail’s been sent!”

     String actualtextBox =  driver.findElement(By.name("confirmation_message")).getText();
     String expectedTextBox ="Your e-mail's been sent!";

        System.out.println(actualtextBox);

     if(actualtextBox.equals(expectedTextBox)){
         System.out.println("TextBox Passed");
     }else{
         System.out.println("TextBox Failed!!!");
     }





    }
}
