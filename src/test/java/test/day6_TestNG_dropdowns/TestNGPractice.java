package test.day6_TestNG_dropdowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGPractice {
   // public static void main(String[] args) {
      //  test1();}


    @BeforeClass
    public void before_class(){
        System.out.println("Before class is running........");
    }

    @AfterClass
    public void after_class(){
        System.out.println("After class is running.....");
    }

    @BeforeMethod
    public void setUp(){
        System.out.println("Before Method is running...");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("After Method is running...");
    }


    @Test
    public static void test1(){
        System.out.println("Test1 running");

        String actualTitle ="Homepage"; ///getTitle
        String expectedTitle ="Homepage";

        Assert.assertEquals(actualTitle, expectedTitle);


     /*   if(actualTitle.equals(expectedTitle)){
            System.out.println("Verification passed");
        }else{
            System.out.println("Verifications failed");
        }   */
    }

   @Test
    public void test2(){
        System.out.println("test2 running");
    }


    @Test
    public void test3(){
        System.out.println("Test3 is running...");

        String actualTitle ="Amazon prime";
        String expectedTitle ="prime";
        String testString ="shjhjshfjsh";

        Assert.assertTrue(actualTitle.contains(expectedTitle));

        Assert.assertFalse(actualTitle.contains(testString));
    }




}
