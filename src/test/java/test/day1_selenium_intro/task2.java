package test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class task2 {
    public static void main(String[] args) {

        /*
        	TC#2:	Cybertek	verifications
        	1.Open	Chrome	browser
        	2.Go	to	https://practice.cybertekschool.com
        	3.Verify	URL	containsExpected:	cybertekschool
        	4.Verify	title:	Expected:	Practice
         */

      WebDriverManager.operadriver().setup();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com");

        String word ="cybertekschool";
        if(driver.getCurrentUrl().contains(word)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

        String actualTitle =driver.getTitle();
        String expectedTitle ="Practice";

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }








    }
}
