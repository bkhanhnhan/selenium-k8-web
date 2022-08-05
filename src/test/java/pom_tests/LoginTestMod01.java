package pom_tests;

import Driver.DriverFactory;
import models.pages.LoginPageMod01;
import org.openqa.selenium.WebDriver;

public class LoginTestMod01 {

    public static void main(String[] args) {

        //Get Chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try{
            //Navigate to the target page
            driver.get("https://the-internet.herokuapp.com/login");

            LoginPageMod01 loginPage =  new LoginPageMod01(driver);
            loginPage.username().sendKeys("teo@sth.com");
            loginPage.password().sendKeys("12345678");
            loginPage.loginBtn().click();

        }catch (Exception e){
            e.printStackTrace();
        }

        //Quit session
        driver.quit();
    }
}
