package test.day3_cssSelector_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class CssSelectorExample {

    public static void main(String[] args) {

      //  Search Amazon
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
      //  1.Open browser
       // 2. Go to https://amazon.com
        driver.get("https://www.amazon.com");
      //  3. Enter any search term (use cssSelector to locate search box)
      WebElement amazonSearch =  driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));
             amazonSearch.sendKeys("toys"+ Keys.ENTER);
        //4. Verify title contains the search term

        if(driver.getTitle().contains("toys")){
            System.out.println("Title passed");
        }else{
            System.out.println("Title Failed!");
        }





    }
}
