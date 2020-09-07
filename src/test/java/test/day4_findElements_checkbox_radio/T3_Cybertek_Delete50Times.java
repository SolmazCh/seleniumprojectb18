package test.day4_findElements_checkbox_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T3_Cybertek_Delete50Times {
    public static void main(String[] args) {

        //XPATH PRACTICES DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
        // TC #3: Practice Cybertek.com_AddRemoveElements WebElement verification

        // 1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        // 2. Go to http://practice.cybertekschool.com/add_remove_elements
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");
        // 3. Click to “Add Element” button 50 times
        WebElement addElementButton =driver.findElement(By.xpath("//button[.='Add Element']"));

        for(int i=1; i<=50; i++){
            addElementButton.click();

        }
        // 4. Verify 50 “Delete” button is displayed after clicking.
        WebElement deleteButton =driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));
        WebElement delete50Button = driver.findElement(By.xpath("//button[@onclick='deleteElement()'][50]"));
        System.out.println(delete50Button.isDisplayed());

        // 5. Click to ALL “Delete” buttons to delete them.
        List<WebElement> listOfDeleteButtons = driver.findElements(By.xpath("//button[.='Delete']"));
        System.out.println("Number of delete buttons in a page: "+listOfDeleteButtons.size());
        for(WebElement button: listOfDeleteButtons){
          button.click();
        }
        // 6. Verify “Delete” button is NOT displayed after clicking.

        try {
            if(deleteButton.isDisplayed()){
                System.out.println("Delete button is displayed: Test Failed");
            }else{
                System.out.println("Delete button is not displayed: Test Passed!!!");
            }
        }catch (RuntimeException e){
            System.out.println("Delete button does not displayed");
        }

        // USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
        // Hint: Need to use findElements method.












    }
}
