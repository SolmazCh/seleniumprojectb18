package test.day10_jsexecutor_upload_actions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.Driver;

public class TC18_ContextClick {



    @Test
    public void ContextClick() {
        //TC	#17:	Context	Click	– HOMEWORK
        //1. Go	to	https://the-internet.herokuapp.com/context_menu
        Driver.getDriver().get("https://the-internet.herokuapp.com/context_menu");
        Driver.getDriver().manage().window().maximize();
        //2. Right	click	to	the	box.
        WebElement boxElement = Driver.getDriver().findElement(By.xpath("//div[@id='hot-spot']"));
        Actions actions = new Actions(Driver.getDriver());
        actions.contextClick(boxElement).perform();
        //3. Alert	will	open.
        //4. Accept	alert
        Alert alert =Driver.getDriver().switchTo().alert();
        alert.accept();
        //No	assertion	needed	for	this	practice.
    }
}
