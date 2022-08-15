package tests.global.footer;

import Driver.DriverFactory;
import models.components.global.footer.CustomerServiceColumnComponent;
import models.components.global.footer.FooterColumnComponent;
import models.components.global.footer.InformationColumnComponent;
import models.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import support.verification.Verifier;
import test_flows.global.FooterTestFlow;
import url.Urls;

public class FooterTest {

    @Test (priority = 1, dependsOnMethods = {"testFooterRegisterPage"})
    public void testFooterCategoryPage(){
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get(Urls.demoURL);
        FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
        footerTestFlow.verifyFooterComponent();

    }
    @Test (priority = 2)
    public void testFooterRegisterPage(){
        String actualResult = "Teo";
        String expecctedResult = "Ti";

//        Verifier.verifyEquals(actualResult,expecctedResult);
        Assert.assertEquals(actualResult,expecctedResult, "[ERR] Welcome message is incorret!");

        System.out.println("Hello");
        Assert.assertTrue(actualResult.equals(expecctedResult), "...");
        Assert.assertFalse(actualResult.equals(expecctedResult), "...");
        Assert.fail();
        Assert.fail("....");

        }

    @Test (priority = 3)
    public void testFooterLoginPage(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(1, 2);
        softAssert.assertEquals(true, true);
        softAssert.assertEquals(1, 3);

        softAssert.assertAll();

        System.out.println("Hello");
    }

//    @Test (priority = 4)
    public void testFooterHomePage(){
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get(Urls.demoURL);
        try {
            HomePage homePage = new HomePage(driver);
            InformationColumnComponent informationColumnComp =
                    homePage.footerComp().informationColumnComp();
            CustomerServiceColumnComponent customerServiceColumnComp =
                    homePage.footerComp().customerServiceColumnComp();

            testFooterColumn(informationColumnComp);
            testFooterColumn(customerServiceColumnComp);
        } catch (Exception ignored){

        }

        driver.quit();
    }
    private static void testFooterColumn(FooterColumnComponent footerColumnComponent){
        System.out.println(footerColumnComponent.headerElm().getText());
        footerColumnComponent.linksElm().forEach(link -> {
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
        });
    }
}
