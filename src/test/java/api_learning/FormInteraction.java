package api_learning;

import Driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormInteraction {

    public static void main(String[] args) {

        //Get Chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try{
            //Navigate to the target page
            driver.get("https://the-internet.herokuapp.com/login");

            //Find elements
            WebElement usernameEle = driver.findElement(By.id("username_"));
            WebElement passwordEle = driver.findElement(By.cssSelector("#password"));
            WebElement loginBtEle = driver.findElement(By.cssSelector("[type='submit']"));

            //Interaction
            usernameEle.clear();
            usernameEle.sendKeys("tomsmith");
            passwordEle.sendKeys("SuperSecretPassword!");
            loginBtEle.click();
        //Debug Purpose Only
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }

        //Quit session
        driver.quit();
    }
}
