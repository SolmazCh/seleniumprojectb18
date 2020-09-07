package test.day2_findElement_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P3_LinkTextLocator {
    /*
    TC #3: Back and forth navigation
    1-Open a chrome browser
    2-Go to: https://google.com
    3-Click to Gmail from top right.
    4-Verify title contains:Expected: Gmail
    5-Go back to Google by using the .back();
    6-Verify title equals:Expected: Google
     */


    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com");
        driver.findElement(By.linkText("Gmail" )).click();
        //4-Verify title contains:Expected: Gmail
        String actualGmailTitle =driver.getTitle();
        String expectedTitle="Gmail";

        if(actualGmailTitle.contains(expectedTitle)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
        // 5-Go back to Google by using the .back();
        driver.navigate().back();
        // 6-Verify title equals:Expected: Google
        String actualGoogleTitle =driver.getTitle();
        Thread.sleep(2000);
        String expectedGoogleTitle ="Google";

        if(actualGoogleTitle.contains(expectedGoogleTitle)){
            System.out.println("Google verification Passed");
        }else{
            System.out.println("Google title verification Failed");
        }




    }
}
