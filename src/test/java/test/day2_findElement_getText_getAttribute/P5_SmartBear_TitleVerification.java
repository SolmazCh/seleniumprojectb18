package test.day2_findElement_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P5_SmartBear_TitleVerification {
    /*
    TC#5:	Basic	login	authentication

    1-Open	a	chrome	browser2
    -Go	to:	http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    3-Verify	title	equals:Expected:	Web	Orders	Login
    4-Enter	username:	Tester
    5-Enter	password:	test
    6-Click	“Sign	In”	button
    7-Verify	title equals:Expected: Web Order
     */


    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        //-Go	to:	http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx

      driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        //3-Verify	title	equals:Expected:	Web	Orders	Login

        String actualTitle = driver.getTitle();
        String expectedTitle ="Web Orders Login";

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

         //4-Enter	username: Tester
        driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
          Thread.sleep(2000);
        // 5-Enter	password: test
        // 6-Click	“Sign In” button
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
        // 7-Verify	title equals:Expected: Web Order
        driver.findElement(By.name("ctl00$MainContent$login_button")).click();
        if(driver.getTitle().equals("Web Order")){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }





    }
}
