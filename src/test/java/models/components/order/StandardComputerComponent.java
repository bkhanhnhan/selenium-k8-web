package models.components.order;

import models.components.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

@ComponentCssSelector(".product-essential")
public class StandardComputerComponent extends ComputerEssentialComponent{

    private static final By productAttributeSel = By.cssSelector("select[id^=\"product_attribute\"]");

    public StandardComputerComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    @Override
    public String selectProcessorType(String type) {
        final int PROCESSOR_DROPDOWN_INDEX = 0;
        WebElement processorDropdownElm = component.findElements(productAttributeSel).get(PROCESSOR_DROPDOWN_INDEX);

        return selectOpt(processorDropdownElm, type);
    }

    @Override
    public String selectRAMType(String type) {
        final int RAM_DROPDOWN_INDEX = 1;
        WebElement ramDropdownElm = component.findElements(productAttributeSel).get(RAM_DROPDOWN_INDEX);

        return selectOpt(ramDropdownElm, type);

    }

    private String selectOpt (WebElement dropdownElm, String type){
        Select select = new Select(dropdownElm);
        List<WebElement> allOptions = select.getOptions();
        String fullStrOptions = null;
        for (WebElement allOption : allOptions) {
            String currentOptText = allOption.getText();
            String optTextWithoutSpaces = currentOptText.trim().replace(" ","");
            if (optTextWithoutSpaces.startsWith(type)){
                fullStrOptions = currentOptText;
                break;
            }
        }

        if (fullStrOptions == null){
            throw new RuntimeException("[ERR] The option: " + type + " is not existing");
        }

        select.selectByVisibleText(fullStrOptions);
        return fullStrOptions;
    }
}
