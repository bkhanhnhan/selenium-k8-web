package tests.testng;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TestNGHooks1 {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("\t--> BeforeTest");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("\t\t--> BeforeClass");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("\t\t\t--> BeforeMethod");
    }
    @Test
    public void testSth(){
        System.out.println("\t\t\t\t--> Test");
    }
    @Test
    public void testSthElse(){
        System.out.println("\t\t\t\t\t--> Test STH ELSE");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("\t\t\t--> AfterMethod");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("\t\t--> AfterClass");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("\t--> AfterTest");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite");
    }
}
