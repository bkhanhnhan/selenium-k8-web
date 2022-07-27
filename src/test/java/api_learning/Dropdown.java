package api_learning;

import Driver.DriverFactory;
import org.asynchttpclient.uri.Uri;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import support.ui.SelectEX;
import url.Urls;

public class Dropdown implements Urls {

    public static void main(String[] args) {
        //get chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            //navigate to target base
            driver.get(baseUrl.concat(dropdownSlug));

            //dropdown locator and element
            By dropdownSel = By.id("dropdown");
            WebElement dropdownElm = driver.findElement(dropdownSel);

            //select dropdown
            SelectEX select = new SelectEX(dropdownElm);

            //Select by visible text | option 1
            select.selectOption1();
            Thread.sleep(1000);

            //Select by index | option 2
            select.selectByIndex(2);
            Thread.sleep(1000);

            //Select by value
            select.selectByValue("1");
            Thread.sleep(1000);

        } catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();
    }
}
