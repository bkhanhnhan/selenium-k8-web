package api_learning;

import Driver.DriverFactory;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FormInteractionMultipleMatching {

    public static void main(String[] args) {

        //Get Chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try{
            //Navigate to the target page
            driver.get("https://the-internet.herokuapp.com/login");

            //Define selector value
            By loginInputFieldSel = By.tagName("input");

            //Interaction
            List<WebElement> loginFormFieldSel = driver.findElements(loginInputFieldSel);
            final int USER_INDEX = 0;
            final int PASSWORD_INDEX = 1;
            if(!loginFormFieldSel.isEmpty()) {
                loginFormFieldSel.get(USER_INDEX).sendKeys("abc");
                loginFormFieldSel.get(PASSWORD_INDEX).sendKeys("12345678");
            } else {
                // Assert.fail("....")
            }

            //Debug Purpose Only
                Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }

        //Quit session
        driver.quit();
    }
}
