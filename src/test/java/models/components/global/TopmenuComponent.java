package models.components.global;

import models.components.Component;
import models.components.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

@ComponentCssSelector(value = ".top-menu")
public class TopmenuComponent extends Component {

    public TopmenuComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public List<MainCatItem> mainItemElms(){
        return findComponents(MainCatItem.class,driver);
    }

    @ComponentCssSelector(".top-menu > li")
    public static class MainCatItem () extends Component{

        public MainCatItem(WebDriver driver, WebElement component) {
            super(driver, component);
        }

        public WebElement cateItemLinkElm(){
            return component.findElement(By.tagName("a"));
        }

        public List<SubListComponent> subListComponents(){
            Actions actions = new Actions(driver);
            actions.moveToElement(component).perform();
            return findComponents(SubListComponent.class,driver);
        }

    }

    @ComponentCssSelector(".sublist li a")
    public static class SubListComponent extends Component{

        public SubListComponent(WebDriver driver, WebElement component) {
            super(driver, component);
        }
    }
}
