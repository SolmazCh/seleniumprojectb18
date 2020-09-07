package test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

public class ttt {
    public static void main(String[] args) throws Exception {

        WebDriverManager.operadriver().setup();
        WebDriver driver=new OperaDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        Thread.sleep(2000);
        System.out.println("get tile "+driver.getTitle());
        System.out.println("get url "+driver.getCurrentUrl());
        driver.get("https://www.facebook.com");
        driver.navigate().back();




    }
}
