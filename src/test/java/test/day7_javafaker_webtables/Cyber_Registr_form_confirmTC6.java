package test.day7_javafaker_webtables;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class Cyber_Registr_form_confirmTC6 {
    //TC#6: Cybertek registration form confirmation
    //Note: Use JavaFaker when possible.

    WebDriver driver;
    @BeforeClass
    public void setUp() {
        //1. Open browser
        //2. Go to website: http://practice.cybertekschool.com/registration_form
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/registration_form");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }


    @AfterClass
    public void tearDown() throws InterruptedException{
        Thread.sleep(2000);
        driver.quit();

    }


    @Test
    public void registrForm() {
        Faker faker = new Faker();
        //3. Enter first name
        WebElement firstName = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
        firstName.sendKeys(faker.name().firstName());
        //4. Enter last name
        WebElement lastName = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
        lastName.sendKeys(faker.name().lastName());
        //5. Enter username
        WebElement userName = driver.findElement(By.xpath("(//input[@type='text'])[3]"));
        userName.sendKeys(faker.name().username().replace(".",""));
        //6. Enter email address
        WebElement email = driver.findElement(By.xpath("(//input[@type='text'])[4]"));
        email.sendKeys("s@gmail.com");
        //7. Enter password
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys(faker.letterify("sdgsdhjjh"));
        //8. Enter phone number
        WebElement phoneNumber = driver.findElement(By.xpath("//input[@name='phone']"));
        phoneNumber.sendKeys("245-785-4785");
        //9. Select a gender from radio buttons
        WebElement femaleGender =driver.findElement(By.xpath("//input[@value='female']"));
        femaleGender.click();
        //10.Enter date of birth
        WebElement date =driver.findElement(By.xpath("//input[@name='birthday']"));
        date.sendKeys("12/25/1985");
        //11.Select Department/Office
        Select department = new Select(driver.findElement(By.xpath("//select[@name='department']")));
        department.selectByIndex(1);

        //12.Select Job Title
        Select jobTitle = new Select(driver.findElement(By.xpath("//select[@name='job_title']")));
        jobTitle.selectByVisibleText("SDET");
        Assert.assertEquals(jobTitle.getFirstSelectedOption().getText(), "SDET");
        //13.Select programming language from checkboxes
        WebElement Java = driver.findElement(By.xpath("//input[@value='java']"));
        Java.click();
        //14.Click to sign up button
        WebElement signUp = driver.findElement(By.xpath("//button[.='Sign up']"));
        signUp.click();
        //15.Verify success message “You’ve successfully completed registration.” is
        WebElement successText = driver.findElement(By.xpath("//body/div//p"));
        Assert.assertTrue(successText.isDisplayed());
        //displayed.

    }
}
