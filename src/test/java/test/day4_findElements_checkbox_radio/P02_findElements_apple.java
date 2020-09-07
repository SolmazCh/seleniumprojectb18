package test.day4_findElements_checkbox_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P02_findElements_apple {
    public static void main(String[] args) {

     //   TC #02: FINDELEMENTS_APPLE
        //   1.Open Chrome browser
        WebDriver  driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //   2.Go to https://www.apple.com
        driver.get("https://www.apple.com");
        //   3.Click to iPhone
        WebElement iPhoneElement = driver.findElement(By.xpath("//a[@data-analytics-title='iphone']"));
        iPhoneElement.click();
        //   4.Print out the texts of all links
        List<WebElement> iPhoneLinks = driver.findElements(By.xpath("//body//a"));
        int LinkWithOutText =0;
        int LinkWithText=0;
        for(WebElement eachLink: iPhoneLinks){
            System.out.println(eachLink.getText());
            if(eachLink.getText().isEmpty()){
                LinkWithOutText++;
            }else{
                LinkWithText++;
            }


        }

        System.out.println("Link without Text: "+LinkWithOutText);
        System.out.println("Link with Text: "+LinkWithText);
        System.out.println("All Links: "+iPhoneLinks.size());
        //   5.Print out how many link is missing text

        //   6.Print out how many link has text
        //   7.Print out how many total link











    }
}
