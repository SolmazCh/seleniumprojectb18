package test.day3_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P4ZeroBankURLVerification {
    public static void main(String[] args) {

        //TC #4: Zero Bank URL verification
        // 1.Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // 2.Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");
        // 3.Get attribute value of href from the “forgot your password”link
       WebElement forgotPasswordLink = driver.findElement(By.partialLinkText("Forgot"));

       // 4.Verify attribute value contains Expected: “/forgot-password.html”
       String attributeOfhref =  forgotPasswordLink.getAttribute("href");
        System.out.println("Actual Href value: "+attributeOfhref);
        String expectedhrefValue ="forgot-password.html";
        if(attributeOfhref.contains(expectedhrefValue)){
            System.out.println("Href value verification Passed");
        }else{
            System.out.println("Href value verification Failed");
        }


        System.out.println("Is forgot password displayed? "+forgotPasswordLink.isDisplayed());




    }
}
