package api_learning;

import Driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import url.Urls;

import java.util.List;

public class MouseHoverAndNarrowDownSearchingScope implements Urls {

    private final static By figureSel = By.className("figure");
    private final static By profileNameSel = By.cssSelector(".figcaption h5");
    private final static By profileLinkSel = By.cssSelector(".figcaption a");

    public static void main(String[] args) {
        //get chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            //navigate to target base
            driver.get(baseUrl.concat(hoverSlug));

            //Target parent element
            List<WebElement> figureElm = driver.findElements(figureSel);
            if (figureElm.isEmpty()){
                throw new RuntimeException("There's no profile image displayed");
            }

            //Define Action object
            Actions action = new Actions(driver);

            for (WebElement figElement : figureElm) {
                WebElement profileNameElm = figElement.findElement(profileNameSel);
                WebElement profileLinkElm = figElement.findElement(profileLinkSel);

                //Before mouse hover
                System.out.println(profileNameElm.getText() + ": " + profileNameElm.isDisplayed());
                System.out.println(profileLinkElm.getText() + ": " + profileLinkElm.isDisplayed());

                //Mouse hover
                action.moveToElement(figElement).perform();

                //AFTER mouse hover
                System.out.println(profileNameElm.getText() + ": " + profileNameElm.isDisplayed());
                System.out.println(profileLinkElm.getText() + ": " + profileLinkElm.isDisplayed());

            }

            Thread.sleep(2000);

        } catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();
    }
}
