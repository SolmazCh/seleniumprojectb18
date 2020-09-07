package test.day2_findElement_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC5_Zerobank_Basic_Auth {
    /*
    TC #5: Basic authentication Zero Bank
    1.Open Chrome browser
    2.Go to http://zero.webappsecurity.com/login.html
    3.Enter username: username
    4.Enter password: password
    5.Click sign in button
    6.Verify username is displayed on the page
    7.Verify the title Zero –Account Summary
    8.Verify the link Account Summary’s href value contains: “account-summary”Print out results in validation formats
     */

    public static void main(String[] args) {
        //1.Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //2.Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");
       // 3.Enter username: username
        driver.findElement(By.name("user_login")).sendKeys("username");
        //4.Enter password: password
        driver.findElement(By.id("user_password")).sendKeys("password");
         //5.Click sign in button
        driver.findElement(By.name("submit")).click();
       // 6.Verify username is displayed on the page

        if(driver.findElement(By.linkText("username")).getText().equals("username")){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
        // 7.Verify the title Zero – Account Summary
        String actualTitle =driver.getTitle();
        String expectedTitle ="Zero - Account Summary";

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title Passed");
        }else{
            System.out.println("Title Failed!!!");
        }
        //8.Verify the link Account Summary’s href value contains: “account-summary”
        // Print out results in validation formats

       String actualLinkValue = driver.findElement(By.linkText("Account Summary")).getAttribute("href");
        String expectedLinkValue ="account-summary";


        if(actualLinkValue.contains(expectedLinkValue)){
            System.out.println("Link value Passed");
        }else{
            System.out.println("Link value Failed!!!");
        }


    }
}
