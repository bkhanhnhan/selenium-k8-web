package support.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectEX extends Select {

    private final String OPTION_01 = "Option 1";

    public SelectEX(WebElement element) {
        super(element);
    }

    public void selectOption1(){
        selectByVisibleText(OPTION_01);
    }


}
