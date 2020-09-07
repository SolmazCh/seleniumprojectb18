package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SmartBearUtilities {


    public static void login(WebDriver driver){
        WebElement userNameButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        userNameButton.sendKeys("Tester");
        WebElement passwordButton = driver.findElement(By.xpath("//input[@type='password']"));
        passwordButton.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();


    }


    public static void verifyOrder(WebDriver driver, String name) {
        List<WebElement> nameList = driver.findElements(By.xpath("//tbody//tr//tr//td[2]"));
        for (WebElement eachName : nameList) {   // iter yazib hazir for loop yaradir
            if (eachName.getText().equals(name)) {
                Assert.assertTrue(true);
                return;
            }

        }
           Assert.fail("The name does not exist in the list! Verification failed");
    }


    public static void printNamesAndCities(WebDriver driver) {
        List<WebElement> nameList = driver.findElements(By.xpath("//tbody//tr//tr//td[2]"));
        List<WebElement> cityList = driver.findElements(By.xpath("//tbody//tr//tr//td[7]"));
        int nameNumber = 1;
        int cityNumber = 1;
        for (int i=0; i<nameList.size(); i++) {
              System.out.println("Name" + nameNumber + ": " + nameList.get(i).getText() + ", City" + cityNumber + ": "+cityList.get(i).getText() );
                nameNumber++;
                cityNumber++;

        }


    }
}
