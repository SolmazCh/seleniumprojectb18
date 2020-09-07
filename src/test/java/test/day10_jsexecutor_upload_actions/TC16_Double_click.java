package test.day10_jsexecutor_upload_actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class TC16_Double_click {
    //TC	#16:	Double	Click Test
    @Test
    public void doubleClick() throws InterruptedException{
        //1. Go	to	https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
       Driver.getDriver().manage().window().maximize();

        //2. Switch	to	iframe.
        Thread.sleep(2000);
        Driver.getDriver().switchTo().frame("iframeResult");
        //3. Double	click	on	the	text	“Double-click	me	to	change	my	text	color.”
        Thread.sleep(2000);
        Actions action = new Actions(Driver.getDriver());
        WebElement text = Driver.getDriver().findElement(By.id("demo"));
        action.moveToElement(text).doubleClick().perform();
        //4. Assert:	Text’s	“style”	attribute	value	contains	“red”.
        Thread.sleep(2000);
        Assert.assertTrue(text.getAttribute("style").contains("red"));

        Driver.closeDriver();
    }
}