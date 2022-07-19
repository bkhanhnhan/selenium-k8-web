package api_learning;

import Driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkTestInteraction {

    public static void main(String[] args) {

        //Get Chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try{
            //Navigate to the target page
            driver.get("https://the-internet.herokuapp.com/login");

            //Define selector value
            By linkTextSel = By.linkText("Elemental Selenium");

            //Find elements
            WebElement linkTextElem = driver.findElement(linkTextSel);
            linkTextElem.click();

            //Debug Purpose Only
                Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }

        //Quit session
        driver.quit();
    }
}
