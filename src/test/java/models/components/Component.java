package models.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Constructor;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Component {

    protected WebDriver driver;
    protected WebElement component;
    protected WebDriverWait wait;

    public Component(WebDriver driver, WebElement component) {
        this.driver = driver;
        this.component = component;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
    }

    public WebElement getComponent() {
        return component;
    }

    public WebElement findElement(By by){
        return component.findElement(by);
    }

    public List<WebElement> findElements(By by){
        return component.findElements(by);
    }

    public<T extends Component> T findComponent(Class<T> componentClass, WebDriver driver){
        return findComponents(componentClass, driver).get(0);
    }
    public<T extends Component> List<T> findComponents(Class<T> componentClass, final WebDriver driver){
        By componentSelector;
        try{
            componentSelector = getComponentSelector(componentClass);
        }catch (Exception e){
            throw new IllegalArgumentException("[ERR] The component must have css selector");
        }
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(componentSelector));
        List<WebElement> result = component.findElements(componentSelector);

        //Define component class construction params
        Class<?>[] params= new Class[]{WebDriver.class, WebElement.class};
        final Constructor<T> constructor;
        try {
             constructor = componentClass.getConstructor(params);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERR] The component must have constructor with params"
                    + Arrays.toString(params));
            }

        //Convert all elements to components
        List<T> component = result.stream().map(webElement -> {
            try{
                return constructor.newInstance(driver, webElement);
            }catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList());

        return component;
    }

    private By getComponentSelector(Class<? extends Component> componentClass){
        if (componentClass.isAnnotationPresent(ComponentCssSelector.class)){
            return By.cssSelector(componentClass.getAnnotation(ComponentCssSelector.class).value());
        } else if (componentClass.isAnnotationPresent(ComponentXPathSelector.class)) {
            return By.xpath(componentClass.getAnnotation(ComponentXPathSelector.class).value());
        } else {
            throw new IllegalArgumentException("Component class" + componentClass + " must have annotation "
                    + ComponentCssSelector.class.getSimpleName() + " or " + ComponentXPathSelector.class.getSimpleName());
        }
    }
}
