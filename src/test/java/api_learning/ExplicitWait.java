package api_learning;

import Driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.ui.WaitMoreThanOneTab;
import url.Urls;

import java.time.Duration;

import static url.Urls.loginSlug;

public class ExplicitWait {

    public static void main(String[] args) {
        //get chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            //navigate to target base
            driver.get(Urls.baseUrl.concat(loginSlug));

            By taolaoSel = By.cssSelector("#teo");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(new WaitMoreThanOneTab());

        } catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();
    }
}
