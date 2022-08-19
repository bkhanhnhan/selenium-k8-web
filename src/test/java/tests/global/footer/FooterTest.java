package tests.global.footer;

import Driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import test_flows.global.FooterTestFlow;
import url.Urls;

public class FooterTest {

    @Test ()
    public void testFooterCategoryPage(){
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            driver.get(Urls.demoURL);
            FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
            footerTestFlow.verifyProductCatFooterComp();
        }catch(Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }
    @Test ()
    public void testFooterRegisterPage(){


    }

    @Test ()
    public void testFooterLoginPage(){

    }

     @Test ()
    public void testFooterHomePage(){

    }
}
