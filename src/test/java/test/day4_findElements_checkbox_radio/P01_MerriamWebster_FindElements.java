package test.day4_findElements_checkbox_radio;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P01_MerriamWebster_FindElements {
    public static void main(String[] args) {

        //TC #0: FINDELEMENTS
        // 1.Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        // 2.Go to https://www.merriam-webster.com/
        driver.get("https://www.merriam-webster.com/");
        // 3.Print out the texts of all links
      List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));
        // 4.Print out how many link is missing text


        int linksWithoutText=0;
        int linksWithText=0;
        for(WebElement eachLink: listOfLinks){
            System.out.println(eachLink.getText());
            if(eachLink.getText().isEmpty()){
                linksWithoutText++;
            } else{ // 5.Print out how many link has text
                linksWithText++;
            }
        }

        System.out.println("links without texts: "+linksWithoutText);
        System.out.println("link with texts: "+linksWithText);
        // 6.Print out how many total link
        int totalLink = listOfLinks.size();
        System.out.println("all links count: "+totalLink);


    }
}