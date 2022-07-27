package api_learning;

import Driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import url.Urls;

public class iFrame implements Urls {

    public static void main(String[] args) {
        //get chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            //navigate to target base
            driver.get(baseUrl.concat(iFrameSlug));

            //Locate iframe
            By iFrameSel = By.cssSelector("[id$='ifr']");
            WebElement iFrameElm = driver.findElement(iFrameSel);

            //Switch to the iframe
            driver.switchTo().frame(iFrameElm);

            //Locate element inside iframe
            WebElement editorInput = driver.findElement(By.id("tinymce"));
            editorInput.click();
            editorInput.clear();
            editorInput.sendKeys("New text value");
            Thread.sleep(1000);


            //Switch back parent frame
            driver.switchTo().defaultContent();
            driver.findElement(By.linkText("Elemental Selenium")).click();
            Thread.sleep(2000);

        } catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();
    }
}
