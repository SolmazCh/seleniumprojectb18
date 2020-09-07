package test.day4_findElements_checkbox_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class P05_ChechBox_ {
    public static void main(String[] args) {
        //TC	#2:	SeleniumEasy	Checkbox Verification–Section1
        // 1.Open	Chrome	browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        // 2.Go	to	https://www.seleniumeasy.com/test/basic-checkbox-demo.html
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        // 3.Verify	“Success–Check	box	is	checked”	message	is	NOT displayed.

        WebElement successCheckBox = driver.findElement(By.xpath("//input[@id='isAgeSelected']"));
        WebElement successMessage =driver.findElement(By.xpath("//div[@id='txtAge']"));

        if(!successCheckBox.isSelected() && !successMessage.isDisplayed() ){
            System.out.println("Default value verification Passed!");
        }else{
            System.out.println("Default verification Failed!!!!");
        }



        // 4.Click	to	checkbox	under	“Single	Checkbox	Demo”	section

        successCheckBox.click();
        // 5.Verify	“Success	–Check	box	is	checked”	message	is displayed.
        WebElement checkBoxisChecked = driver.findElement(By.xpath("//div[@id='txtAge']"));

        if(successCheckBox.isSelected() && successMessage.isDisplayed() ){
            System.out.println("Default value verification Passed!");
        }else{
            System.out.println("Default verification Failed!!!!");
        }




    


    }
}
