package api_learning;

import Driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.ui.WaitForElementEnabled;
import url.Urls;

import javax.swing.plaf.DimensionUIResource;
import java.time.Duration;

public class DynamicControl implements Urls {

    public static void main(String[] args) {
        //get chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            //navigate to target base
            driver.get(baseUrl.concat(dynamicControlSlug));

            //define parent locators | checkbox + input form
            By checkboxFormSel = By.id("checkbox-example");
            By inputFormSel = By.id("input-example");

            //Checkbox form interaction
            WebElement checkboxFormElm = driver.findElement(checkboxFormSel);
            WebElement checkboxElm = checkboxFormElm.findElement(By.tagName("input"));
            if (!checkboxElm.isSelected()) checkboxElm.click();

            //DEBUG
            Thread.sleep(1000);

            //Input form interaction
            WebElement inputFormElm = driver.findElement(inputFormSel);
            WebElement inpuFieldtElm = inputFormElm.findElement(By.tagName("input"));
            WebElement inputBtnElm = inputFormElm.findElement(By.tagName("button"));
            if (!inpuFieldtElm.isEnabled())
                inputBtnElm.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(new WaitForElementEnabled(By.cssSelector("#input-example input")));
            inpuFieldtElm.sendKeys("Hello");

            //DEBUG
            Thread.sleep(2000);

        } catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();
    }
}
