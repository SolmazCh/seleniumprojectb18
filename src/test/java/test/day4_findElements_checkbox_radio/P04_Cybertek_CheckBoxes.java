package test.day4_findElements_checkbox_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class P04_Cybertek_CheckBoxes {
    public static void main(String[] args) {

        //Practice:	Cybertek Checkboxes
        // 1.Go	to	http://practice.cybertekschool.com/checkboxes
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/checkboxes");
        // 2.Confirm	checkbox	#1	is	NOT	selected	by	default
       WebElement checkBox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));

       if(!checkBox1.isSelected()){
           System.out.println("Checkbox 1 is not selected. Verification Passed! ");
       }else{
           System.out.println("CheckBox 1 is selected. Verification Failed!!");
       }
        // 3.Confirm	checkbox	#2	is	SELECTED	by	default.

        WebElement checkBox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));
       if(checkBox2.isSelected()){
           System.out.println("checkbox 2 is selected. Verification Passed!!");
       }else{
           System.out.println("checkbox 2 is not selected. Verification Failed!!!");
       }
        // 4.Click	checkbox	#1	to	select	it.
        checkBox1.click();
        // 5.Click	checkbox	#2	to	deselect	it.
        checkBox2.click();
        // 6.Confirm	checkbox	#1	is	SELECTED.
        if(checkBox1.isSelected()){
            System.out.println("Checkbox 1 is selected. Verification Passed! ");
        }else{
            System.out.println("CheckBox 1 is not selected. Verification Failed!!");
        }
        // 7.Confirm	checkbox	#2	is	NOT

        if(!checkBox2.isSelected()){
            System.out.println("checkbox 2 is not selected. Verification Passed!!");
        }else{
            System.out.println("checkbox 2 is selected. Verification Failed!!!");
        }





    }
}
