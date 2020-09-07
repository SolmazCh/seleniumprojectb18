package test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSelenium  {

    public static void main(String[] args) throws InterruptedException{
        //1- set up the web driver
        WebDriverManager.chromedriver().setup();
        //2- create the instance of the chrome driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // maximizes the browser page after opening it
      //  driver.manage().window().fullscreen();// maximizes the browser page after opening it, same with maximize()
        // 3- test driver is working
        driver.get("https://www.google.com");
        System.out.println("driver.getTitle()-->"+driver.getTitle());
        System.out.println("driver getCurrentURL -->"+driver.getCurrentUrl());

       // WebDriver driver2 = new FirefoxDriver(); // for using Firefox driver


        //BROWSER NAVIGATIONS
        // this line will take user to the previous page
        Thread.sleep(2000); // this line adds 2 sec of wait
        driver.navigate().back();

        Thread.sleep(2000);
        driver.navigate().forward(); // this line will go to the next page

        Thread.sleep(2000);
        driver.navigate().refresh();//This line will refresh the page

        driver.navigate().to("https://www.facebook.com");


        System.out.println("driver.getTitle()-->"+driver.getTitle());
        System.out.println( "driver.getCurrentUrL -->"+driver.getCurrentUrl() );

        System.out.println(driver.getPageSource());  // gets the page sources


        driver.close(); // close the current browser tab
       // driver.quit(); // will close all the tabs, and end the session


    }




}
