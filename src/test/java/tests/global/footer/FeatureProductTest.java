package tests.global.footer;

import Driver.DriverFactory;
import models.components.global.footer.CustomerServiceColumnComponent;
import models.components.global.footer.FooterColumnComponent;
import models.components.global.footer.InformationColumnComponent;
import models.components.product.ProductGridComponent;
import models.components.product.ProductItemComponent;
import models.pages.HomePage;
import org.openqa.selenium.WebDriver;
import url.Urls;

import java.util.List;

public class FeatureProductTest {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            testFeatureProductHomePage(driver);
        }catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }

    private static void testFeatureProductHomePage(WebDriver driver){
        driver.get(Urls.demoURL);
        HomePage homePage = new HomePage(driver);
        List<ProductItemComponent> productItemComponents =
                homePage.productGridComponent().productItemComponents();

        productItemComponents.forEach(productItemComponent -> {
            System.out.println(productItemComponent.productTitleElm().getText());
        });
    }

}
