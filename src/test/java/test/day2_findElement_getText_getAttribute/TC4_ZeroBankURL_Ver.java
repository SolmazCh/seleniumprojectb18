package test.day2_findElement_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC4_ZeroBankURL_Ver {
    /*
TC #4: Zero Bank URLverification
1.Open Chrome browser
2.Go to http://zero.webappsecurity.com/login.html
3.Get attribute value of href from the “forgot your password”link
4.Verify attribute value containsExpected: “/forgot-password.html”
     */

    public static void main(String[] args) {

        //1.Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //2.Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");
        //3.Get attribute value of href from the “forgot your password”link
        String hrefValue = driver.findElement(By.linkText("Forgot your password ?")).getAttribute("href");

       System.out.println("href value: "+hrefValue);










    }
}
