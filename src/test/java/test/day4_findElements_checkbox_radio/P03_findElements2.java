package test.day4_findElements_checkbox_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P03_findElements2 {

    public static void main(String[] args) throws Exception{

        // 03: FINDELEMENTS_APPLE
        // 1.Open Chrome browser
        // 2.Go to https://www.apple.com
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.apple.com");


        //creating counters:
        int emptyLinkCounter =0;
        int linksWithText=0;

        // 3.Click to all of the headers one by one
        // a.Mac, iPad, iPhone, Watch, TV, Music, Support

        //Creating list of Webelements to store all the links in the header list.
        List<WebElement> appleHeader =driver.findElements(By.xpath("//ul[@class='ac-gn-list']//li//a"));

        //The loop where we specify where to start from and where to ends appleHeader list

        for(int i=1; i<8; i++){

            appleHeader.get(i).click();
            Thread.sleep(1000);
            List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));
            //4. Print out how many links on each page with the titles of the pages
            System.out.println("Number of links on page: "+driver.getTitle() + " "+listOfLinks.size());
            //text of links
            //5. loop through all
            //6. Print out how many link is missing text Total
            // 7.Print out how many link has textTOTAL
            // 8.Print out how many total linkTOTAL

            for (WebElement link : listOfLinks) {
                String textOfLink = link.getText();
                if (!textOfLink.isEmpty()) {
                    //System.out.println(textOfLink);
                    linksWithText++;
                } else {
                    emptyLinkCounter++;
                }
            }
            driver.navigate().back();
            appleHeader = driver.findElements(By.xpath("//ul[@class='ac-gn-list']/li/a"));
        }
        System.out.println("Number of EmptyLinks: \t" + emptyLinkCounter);
        System.out.println("Number of Links with text: \t" + linksWithText);






        }



    }

