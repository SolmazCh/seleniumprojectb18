package test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class task1 {
    public static void main(String[] args) {
/*
TC	#1:	Google	Title	Verification

1.Open	Chrome	browser
2.Go	to	https://www.google.com
3.Verify	title:	Expected:	Google
 */


        WebDriverManager.chromedriver().setup();
         //1 open chrome browser

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //2.Go	to	https://www.google.com
        driver.get("https://www.google.com");
        //3.Verify	title:	Expected:	Google
        System.out.println("get title: "+driver.getTitle());
        System.out.println("get url: "+driver.getCurrentUrl());
        System.out.println("get page source: "+driver.getPageSource());

        String actual =driver.getTitle();
        String expected ="Google";

        if(actual.equals(expected)){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }


    }
}
