package api_learning;

import Driver.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import url.Urls;

public class JSExcutor implements Urls {

    public static void main(String[] args) {
        //get chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            //navigate to target base
            driver.get(baseUrl.concat(floatingMenutSlug));

            //Scroll to bottom
            JavascriptExecutor javascriptExcutor = (JavascriptExecutor) driver;
            javascriptExcutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");

            //DEBBUG
            Thread.sleep(2000);

            //Scroll to top
            javascriptExcutor.executeScript("window.scrollTo(document.body.scrollHeight, 0);");

            //DEBUG
            Thread.sleep(2000);


        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}