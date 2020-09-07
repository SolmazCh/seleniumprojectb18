package test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P1_GoogleTitleVerification {
    public static void main(String[] args) {

        // TC #1: Google Title	Verification
        // 1.Open Chrome	browser
        // Set up my webDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //make the browser full screen
        driver.manage().window().maximize();
        // 2.Go to	https://www.google.com
        driver.get("https://www.google.com");
      //  3.Verify title: Expected: Google

        String actualTitle= driver.getTitle();
        String expectedTitle= "Google";
        if(actualTitle.equals(expectedTitle)) {
            System.out.println("Google Title verification PASSED");
        } else{
            System.out.println("Google Title verification FAILED");
        }



    }
}
