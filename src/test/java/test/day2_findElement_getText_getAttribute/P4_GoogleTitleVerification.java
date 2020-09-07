package test.day2_findElement_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P4_GoogleTitleVerification {
    public static void main(String[] args) throws Exception{


/*
TC#4:	Google	search
1-Open	a	chrome	browser
2-Go	to:	https://google.com
3-Write	“apple”	in	search	box
4-Click	google	search	button
5-Verify	title:
Expected:	Title	should	start	with	“apple"
 */

        //TC #4: Google search
        //1- Open a chrome browser
        // for manual importing : Windows :alt+enter MAC : option+enter
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://google.com
        driver.get("https://www.google.com");

        //3- Write “apple” in search box
        driver.findElement(By.name("q")).sendKeys("apple");
        Thread.sleep(1000);
        //4- Click google search button
       driver.findElement(By.name("btnK")).click();
        //5- Verify title:
        //Expected: Title should start with “apple” word
        String actualTitle = driver.getTitle();
        String expectedInTitle = "apple";

        if (actualTitle.startsWith(expectedInTitle)){
            System.out.println("Google search title verification PASSED!");
        }else{
            System.out.println("Google search title verification FAILED!!!");
        }













    }
}
