package test.day4_findElements_checkbox_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class T2_Cybertek_AddRemoveElements {
    //XPATH PRACTICES DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
    // #2: Practice Cybertek.com_AddRemoveElements WebElement verification
    // 1. Open Chrome browser
    // 2. Go to http://practice.cybertekschool.com/add_remove_elements
    // 3. Click to “Add Element” button
    // 4. Verify “Delete” button is displayed after clicking.
    // 5. Click to “Delete” button.
    // 6. Verify “Delete” button is NOT displayed after clicking.
    // USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS

    public static void main(String[] args) {

       WebDriver driver = WebDriverFactory.getDriver("chrome");
       driver.manage().window().maximize();
       driver.get("http://practice.cybertekschool.com/add_remove_elements/");

        WebElement addElement =  driver.findElement(By.xpath("//button[@onclick='addElement()']"));
         addElement.click();


         WebElement deleteButtonElement = driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));

        System.out.println("Delete Button element is displayed: "+deleteButtonElement.isDisplayed());
        deleteButtonElement.click();

        try{
            deleteButtonElement.isDisplayed();
            System.out.println("Delete button element is displayed. Test Failed");
        }catch (RuntimeException e){
            System.out.println("Delete button element is not displayed! Test passed");
        }



       // System.out.println("Delete Button element is displayed: "+deleteButtonElement.isDisplayed());



    }
}
