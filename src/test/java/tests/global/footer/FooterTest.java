package tests.global.footer;

import org.testng.Assert;
import org.testng.annotations.Test;
import test_flows.global.FooterTestFlow;
import tests.BaseTest;
import url.Urls;

public class FooterTest extends BaseTest {

    @Test ()
    public void testFooterCategoryPage(){
        driver.get(Urls.demoURL);
        Assert.fail("Taking screenshot");
        FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
        footerTestFlow.verifyProductCatFooterComp();
    }

    @Test ()
    public void testFooterHomePage(){
        driver.get(Urls.demoURL);
        FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
        footerTestFlow.verifyFooterComponent();
    }

    public void testFooterRegisterPage(){

    }

    public void testFooterLoginPage(){
    }


}
