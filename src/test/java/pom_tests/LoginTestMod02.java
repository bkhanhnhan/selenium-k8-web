package pom_tests;

import Driver.DriverFactory;
import models.pages.LoginPageMod01;
import models.pages.LoginPageMod02;
import org.openqa.selenium.WebDriver;

public class LoginTestMod02 {

    public static void main(String[] args) {

        //Get Chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try{
            //Navigate to the target page
            driver.get("https://the-internet.herokuapp.com/login");

            LoginPageMod02 loginPage =  new LoginPageMod02(driver);
            loginPage.inputUsername("teo@sth.com");
            loginPage.inputPassword("12345678");
            loginPage.clickOnLoginBtn();

        }catch (Exception e){
            e.printStackTrace();
        }

        //Quit session
        driver.quit();
    }
}
