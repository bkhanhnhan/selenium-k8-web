package api_learning;

import Driver.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import url.Urls;

import java.time.Duration;

public class JsAlert implements Urls {

    private final static By jsAlertSel = By.cssSelector("[onclick=\"jsAlert()\"]");
    private final static By jsConfirmSel = By.cssSelector("[onclick=\"jsConfirm()\"]");
    private final static By jsPromptSel = By.cssSelector("[onclick=\"jsPrompt()\"]");
    private final static By jsResultSel = By.cssSelector("#result");

    public static void main(String[] args) {
        //get chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            //navigate to target base
            driver.get(baseUrl.concat(jSAlertSlug));

            //JS Alert
            handleAlert(driver, jsAlertSel, true);
            System.out.println("Result: " + driver.findElement(jsResultSel).getText());

            //JS Confirm
            handleAlert(driver, jsConfirmSel, false);
            System.out.println("Result: " + driver.findElement(jsResultSel).getText());

            //JS Prompt
            handleAlert(driver, jsPromptSel, "My name is ", true);
            System.out.println("Result: " + driver.findElement(jsResultSel).getText());

        } catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();
    }

    public static void handleAlert(WebDriver driver, By triggerAlertSel, boolean isAccepting){
        Alert alert = getAlert(driver, triggerAlertSel);
        System.out.println("Alert content: " + alert.getText());
        if (isAccepting) alert.accept();
        else alert.dismiss();
    }

    public static void handleAlert(WebDriver driver, By triggerAlertSel,
                                   String contentToEnter, boolean isAccepting){
        Alert alert = getAlert(driver, triggerAlertSel);
        System.out.println("Alert content: " + alert.getText());
        alert.sendKeys(contentToEnter);
        if (isAccepting) alert.accept();
        else alert.dismiss();
    }

    private static Alert getAlert(WebDriver driver, By triggerAlertSel){
        WebElement triggerJsAlertBtnElm = driver.findElement(triggerAlertSel);
        Alert alert;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        triggerJsAlertBtnElm.click();
        return wait.until(ExpectedConditions.alertIsPresent());
    }
    }
