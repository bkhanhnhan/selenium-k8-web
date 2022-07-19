package api_learning;

import Driver.DriverFactory;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementDisplay {

    public static void main(String[] args) {

        //Get Chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        driver.get("https://the-internet.herokuapp.com/login");

        List<WebElement> elementList = driver.findElements(By.tagname("abc"));
        if (!elementList.isEmpty()){
            //Assert.fail("...");
        }

        try{
            //Navigate to the target page
            driver.get("https://the-internet.herokuapp.com/login");

            //Define selector value
            By usernameSel = By.id("username");
            By passwordSel = By.cssSelector("#password");
            By loginBtnSel = By.cssSelector("[type='submit']");

            //Find elements
            WebElement usernameElm = driver.findElement(usernameSel);
            WebElement passwordElm = driver.findElement(passwordSel);
            WebElement loginBtnElm = driver.findElement(loginBtnSel);

            //Get Attribute Value
            System.out.println("Login button type: "
                    + loginBtnElm.getAttribute("type"));
            System.out.println("Login button background color: "
                    + loginBtnElm.getCssValue("background-color"));

            //Interaction
            usernameElm.sendKeys("tomsmith");
            passwordElm.sendKeys("SuperSecretPassword!");
            loginBtnElm.click();

            //Go back to previous page
            driver.navigate().back();

            //Refresh
            driver.navigate().refresh();

            //Re-interact
            usernameElm = driver.findElement(usernameSel);
            passwordElm = driver.findElement(passwordSel);
            loginBtnElm = driver.findElement(loginBtnSel);
            usernameElm.sendKeys("123123123");
            passwordElm.sendKeys("123123123");
            loginBtnElm.click();

            //Debug Purpose Only
                Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }

        //Quit session
        driver.quit();
    }
}
