package test.day8_alerts_iframes_windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class WindowsTabsPractice {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        //2. Go to website:
        //3. Go to: 	http://practice.cybertekschool.com/windows
        driver.get("http://practice.cybertekschool.com/windows");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() throws Exception {
        // close browser
        Thread.sleep(2000);
        driver.close();
    }

   @Test
    public void p5_window_handle_practice(){
       //4. Assert:	Title	is	“Practice”
       String currentWindowHandle =driver.getWindowHandle();//return title of the link
       System.out.println("current WindowHandle: "+currentWindowHandle);
       //5. Click	to:	“Click	Here” text
       WebElement clickHereButton = driver.findElement(By.xpath("//a[.='Click Here']"));
       clickHereButton.click();
        //6. Switch	to	new	Window.
       //7. Assert:	Title	is	“New	Window”

       for(String each: driver.getWindowHandles()){ // will return all titles from the links
           driver.switchTo().window(each);
           if(driver.getTitle().equals("New Window")){
               Assert.assertTrue(driver.getTitle().equalsIgnoreCase("New Window"));
               break;
           }
          // System.out.println(driver.getTitle());



       }

   }
}
