package models.components.order;

import models.pages.BasePage;
import org.openqa.selenium.WebDriver;

public class ComputerItemDetailPage extends BasePage {

    public ComputerItemDetailPage(WebDriver driver) {
        super(driver);
    }

    public<T extends ComputerEssentialComponent> T computerComponent(Class<T> computerEssentialCompClass){
        return findComponent(computerEssentialCompClass, driver);
    }


}
