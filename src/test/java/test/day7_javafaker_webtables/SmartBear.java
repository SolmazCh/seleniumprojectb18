package test.day7_javafaker_webtables;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class SmartBear {
    //TC#2: Smartbear software order placing
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        //1. Open browser
        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

   @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void p1_smartbear_login_test() {
        //3. Enter username: “Tester”
        WebElement userNameButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        userNameButton.sendKeys("Tester");
        //4. Enter password: “test”
        WebElement passwordButton = driver.findElement(By.xpath("//input[@type='password']"));
        passwordButton.sendKeys("test");
        //5. Click to Login button
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();

        //6. Click on Order

        WebElement OrderButton = driver.findElement(By.xpath("//a[.='Order']"));
        OrderButton.click();
        //7. Select familyAlbum from product, set quantity to 2
        Select productSelect = new Select(driver.findElement(By.xpath("//select[@name='ctl00$MainContent$fmwOrder$ddlProduct']")));
        productSelect.selectByIndex(1);

        WebElement quantityButton = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtQuantity']"));
        quantityButton.sendKeys(Keys.BACK_SPACE);// instead of clear, other way to clear when needed
        quantityButton.sendKeys("2");


        //8. Click to “Calculate” button
        WebElement calculateButton = driver.findElement(By.xpath("//input[@value='Calculate']"));
        calculateButton.click();
        //9. Fill address Info with JavaFaker
        //• Generate: name, street, city, state, zip code
        Faker addressFaker = new Faker();
       String name = addressFaker.address().firstName()+" "+addressFaker.address().lastName();
       WebElement customerName = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtName']"));
       customerName.sendKeys(name);
       WebElement street = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']"));
       street.sendKeys(addressFaker.address().streetAddress());
        WebElement city = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']"));
        city.sendKeys(addressFaker.address().city());
        WebElement state = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']"));
        state.sendKeys(addressFaker.address().state());
        WebElement zip= driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox5']"));
        zip.sendKeys(addressFaker.address().zipCode().replace("-",""));


        //10.Click on “visa” radio button
        WebElement visaRadioButton= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_0']"));
       visaRadioButton.click();
        //11.Generate card number using JavaFaker
        WebElement cardNumber = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox6']"));
       cardNumber.sendKeys(addressFaker.finance().creditCard().replaceAll("-",""));
        //12.Click on “Process”

        WebElement expireDate = driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1"));
        expireDate.sendKeys("11/23");




        WebElement processElement = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']"));
        processElement.click();
        //13.Verify success message “New order has been successfully added.”

       WebElement textsucces = driver.findElement(By.xpath("//div[@class='buttons_process']/strong"));

        Assert.assertTrue(textsucces.isDisplayed());

    }




}