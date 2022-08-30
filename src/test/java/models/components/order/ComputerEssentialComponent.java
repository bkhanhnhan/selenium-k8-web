package models.components.order;

import models.components.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class ComputerEssentialComponent extends Component {

    public ComputerEssentialComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public abstract String selectProcessorType(String type);

    public abstract String selectRAMType(String type);

    protected String selectCompOption(String type){
        String selectorString = "//label[contains(text(),\"" + type + "\")]";
        By optionSelector = By.xpath(selectorString);

        WebElement optionElm = null;

        try{
            optionElm = component.findElement(optionSelector);
        }catch (Exception ignored){}

        if (optionElm != null){
            optionElm.click();
            return optionElm.getText();
        }else {
            throw new RuntimeException("The option " + type + "is not existing to select");
        }
    }
}