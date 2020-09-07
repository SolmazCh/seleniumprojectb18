package test.day10_jsexecutor_upload_actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class TC15_Hover_test {
    //TC	#15:	Hover	Test
    //1. Go	to	http://practice.cybertekschool.com/hovers
    @Test
    public void hover_test() {
        Driver.getDriver().get("http://practice.cybertekschool.com/hovers");
        //2. Hover	over	to	first	image
        WebElement image1 = Driver.getDriver().findElement(By.xpath("//div[@class='figure'][1]"));
        WebElement user1 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user1']"));
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(image1).perform();
        //3. Assert:
        //a. “name:	user1”	is	displayed
        Assert.assertTrue(user1.isDisplayed());
        //4. Hover	over	to	second	image
        //5. Assert:
        WebElement image2 = Driver.getDriver().findElement(By.xpath("//div[@class='figure'][2]"));
        WebElement user2 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user2']"));
        //a. “name:	user2”	is	displayed
        action.moveToElement(image2).perform();
        Assert.assertTrue(user2.isDisplayed());
        //6. Hover	over	to	third	image
        //7. Confirm:
        //a. “name:	user3”	is	displayed
        WebElement image3 = Driver.getDriver().findElement(By.xpath("//div[@class='figure'][3]"));
        WebElement user3 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user3']"));
        action.moveToElement(image3).perform();
        Assert.assertTrue(user3.isDisplayed());
        Driver.closeDriver();

        
    }
}
