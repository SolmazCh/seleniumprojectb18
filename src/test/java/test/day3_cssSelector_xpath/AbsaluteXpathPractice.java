package test.day3_cssSelector_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class AbsaluteXpathPractice {
    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
     WebElement homeLink =  driver.findElement(By.xpath("/html/body/nav/ul/li/a"));

if(homeLink.isDisplayed()){
    System.out.println("Home link is displayed:Passed");
}else{
    System.out.println("Home link is displayed Failed!");
}

    }
}
