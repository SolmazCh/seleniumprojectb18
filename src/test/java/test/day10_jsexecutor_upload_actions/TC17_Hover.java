package test.day10_jsexecutor_upload_actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class TC17_Hover {



    @Test
    public void Hover_test() {
        //TC	#16:	Hover	Test
        //1. Go	to	https://demos.telerik.com/kendo-ui/dragdrop/index
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        Driver.getDriver().manage().window().maximize();
        Actions action = new Actions(Driver.getDriver());
        //2. Drag	and	drop	the	small	circle	to	bigger	circle.
        WebElement smallCircle =Driver.getDriver().findElement(By.xpath("//div[@id='draggable']"));
        WebElement bigCircle = Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));
        action.dragAndDrop(smallCircle,bigCircle).perform();
        //2nd way
       // action.clickAndHold(smallCircle).moveToElement(bigCircle).release().perform();
        //3. Assert:
        //-Text	in	big	circle	changed to:	“You	did	great!”
        Assert.assertTrue(bigCircle.getText().equals("You did great!"));

        Driver.closeDriver();
    }
}
