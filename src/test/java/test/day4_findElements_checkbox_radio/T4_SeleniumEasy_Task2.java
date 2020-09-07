package test.day4_findElements_checkbox_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T4_SeleniumEasy_Task2 {
    public static void main(String[] args) {


        //.TC	#3:	Selenium Easy	Checkbox	Verification	–Section2
        // 1.Open	Chrome	browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        // 2.Go	to	https://www.seleniumeasy.com/test/basic-checkbox-demo.html
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        // .Verify	“Check	All”	button	text	is	“Check	All”
        WebElement checkAllButton = driver.findElement(By.xpath("//input[@id='check1']"));
      String checkAllButtonText =  checkAllButton.getAttribute("value");
      String expectedText ="Check All";
      if(checkAllButtonText.equals(expectedText)){
          System.out.println("Check All button text verification Passed");
      }else{
          System.out.println("Check All button text  verification Failed!!!");
      }
        // 4.Click	to	“Check	All”	button
           checkAllButton.click();
        // 5.Verify	all	check	boxes	are	checked

        List<WebElement> checkboxList =driver.findElements(By.xpath("//input[@class='cb1-element']"));

        for(WebElement checkbox: checkboxList){
           if( checkbox.isSelected()){
               System.out.println("Checkbox is selected Passed!!");
           }else{
               System.out.println("Check box is not selected Failed!");
           }
        }

        // 6.Verify	button	text	changed	to	“Uncheck"
    String buttonTextAfterClick =  driver.findElement(By.xpath("//input[@id='check1']")).getAttribute("value");
        String expectedValueAfterClick ="Uncheck All";

        if(buttonTextAfterClick.equals(expectedValueAfterClick)){
            System.out.println("Final verification passed");
        }else {
            System.out.println("Final verification Failed!!");
        }





    }
}
