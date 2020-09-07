package test.day9_testbase_properties_driverUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

public class DriverUtilisPractice {


    @Test
    public void driver_practice(){
        Driver.getDriver().get("https://www.google.com");

        WebElement googleSearch =Driver.getDriver().findElement(By.name("q"));
        googleSearch.sendKeys(ConfigurationReader.getProperty("testdata")+ Keys.ENTER);
    }



    @Test
    public void singleton_practice(){
        String str1 = Singleton.getWord();
        System.out.println("str1="+str1);
        String str3 =Singleton.getWord();
        System.out.println("str3= "+str3);
    }


}
