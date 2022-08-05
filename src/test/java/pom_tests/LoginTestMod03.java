package pom_tests;

import Driver.DriverFactory;
import models.components.LoginFormComponents;
import models.pages.LoginPageMod02;
import models.pages.LoginPageMod03;
import org.openqa.selenium.WebDriver;

public class LoginTestMod03 {

    public static void main(String[] args) {

        //Get Chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try{
            //Navigate to the target page
            driver.get("https://the-internet.herokuapp.com/login");

            LoginPageMod03 loginPage =  new LoginPageMod03(driver);
            LoginFormComponents loginFormComponents = loginPage.loginFormComponents();
            loginFormComponents.inputUsername("teo@sth.com");
            loginFormComponents.inputPassword("12345678");
            loginFormComponents.clickOnLoginBtn();

        }catch (Exception e){
            e.printStackTrace();
        }

        //Quit session
        driver.quit();
    }
}
