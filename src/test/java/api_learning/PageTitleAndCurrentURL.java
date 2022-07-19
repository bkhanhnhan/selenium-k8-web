package api_learning;

import Driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageTitleAndCurrentURL {

    public static void main(String[] args) {

        //Get Chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try{
            //Navigate to the target page
            driver.get("https://the-internet.herokuapp.com/login");

            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());
        }catch (Exception e){
            e.printStackTrace();
        }

        //Quit session
        driver.quit();
    }
}
