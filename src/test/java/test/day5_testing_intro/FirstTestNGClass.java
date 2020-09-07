package test.day5_testing_intro;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstTestNGClass {

    @BeforeMethod
    public void setUp(){
        System.out.println("Before method running...");
    }


    @AfterMethod
    public void tearDown(){
        System.out.println("After method running...");
    }

    @Test // test annotion
    public void test1(){
        System.out.println("Test1 is running...");
    }


    public void test2(){
        System.out.println("Test2 is running...");
    }






}
