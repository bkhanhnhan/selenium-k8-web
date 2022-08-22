package test_flows.global;

import models.components.global.TopmenuComponent;
import static models.components.global.TopmenuComponent.MainCatItem;
import static models.components.global.TopmenuComponent.SubListComponent;
import models.components.global.footer.FooterColumnComponent;
import models.components.global.footer.FooterComponent;
import models.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import url.Urls;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FooterTestFlow {

    private final WebDriver driver;

    public FooterTestFlow(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyFooterComponent(){
        BasePage basePage = new BasePage(driver);
        FooterComponent footerComponent = basePage.footerComp();
        verifyInformationColumn(footerComponent.informationColumnComp());
        verifyCustomerServiceColumn(footerComponent.customerServiceColumnComp());
        verifyAccountColumn(footerComponent.myAccountColumnComp());
        verifyFollowUsColumn(footerComponent.followUsColumnCompo());
    }

    private void verifyInformationColumn(FooterColumnComponent footerColumnComponent) {
        String baseUrl = Urls.demoURL;
        List<String> expectedLinks = Arrays.asList(
                "Sitemap", "Shipping & Returns", "Privacy Notice", "Conditions of Use",
                "About us", "Contact us");
        List<String> expectedHrefs = Arrays.asList(
                baseUrl + "/sitemap", baseUrl + "/shipping-returns", baseUrl + "/privacy-policy", baseUrl + "/conditions-of-use",
                baseUrl + "/about-us", baseUrl + "/contactus");
        verifyFooterColumn(footerColumnComponent, expectedLinks, expectedHrefs);

    }

    private void verifyCustomerServiceColumn(FooterColumnComponent footerColumnComponent) {
        String baseUrl = Urls.demoURL;
        List<String> expectedLinks = Arrays.asList(
                "Search", "News", "Blog", "Recently viewed products",
                "Compare products list", "New products");
        List<String> expectedHrefs = Arrays.asList(
                baseUrl + "/search", baseUrl + "/news", baseUrl + "/blog", baseUrl + "/recentlyviewedproducts",
                baseUrl + "/compareproducts", baseUrl + "/newproducts");
        verifyFooterColumn(footerColumnComponent, expectedLinks, expectedHrefs);
    }

    private void verifyAccountColumn(FooterColumnComponent footerColumnComponent) {
        String baseUrl = Urls.demoURL;
        List<String> expectedLinks = Arrays.asList(
                "My account", "Orders", "Addresses", "Shopping cart", "Wishlist");
        List<String> expectedHrefs = Arrays.asList(
                baseUrl + "/customer/info", baseUrl + "/customer/orders", baseUrl + "/customer/addresses",
                baseUrl + "/cart", baseUrl + "/wishlist");
        verifyFooterColumn(footerColumnComponent, expectedLinks, expectedHrefs);
    }

    private void verifyFollowUsColumn(FooterColumnComponent footerColumnComponent) {
        String baseUrl = Urls.demoURL;
        List<String> expectedLinks = Arrays.asList(
                "Facebook", "Twitter", "RSS", "YouTube", "Google+");
        List<String> expectedHrefs = Arrays.asList(
                "http://www.facebook.com/nopCommerce", "https://twitter.com/nopCommerce",
                baseUrl + "/news/rss/1", "http://www.youtube.com/user/nopCommerce", "https://plus.google.com/+nopcommerce");
        verifyFooterColumn(footerColumnComponent, expectedLinks, expectedHrefs);
    }

    public void verifyProductCatFooterComp(){
        BasePage basePage = new BasePage(driver);
        TopmenuComponent topmenuComponent = basePage.topmenuComponent();
        List<MainCatItem> mainCatElm = topmenuComponent.mainItemElms();
        if(mainCatElm.isEmpty()){
            Assert.fail("[ERR] There is no item on top menu");
        }

//        MainCatItem randomMainItemElm = mainCatElm.get(new SecureRandom().nextInt(mainCatElm.size()));
        MainCatItem randomMainItemElm = mainCatElm.get(1);
        String randomCateHref = randomMainItemElm.cateItemLinkElm().getAttribute("href");

        // get sublist
        List<SubListComponent>sublistComponents = randomMainItemElm.subListComponents();

        if (sublistComponents.isEmpty()){
            randomMainItemElm.cateItemLinkElm().click();
        }else {
            int randomIndex = new SecureRandom().nextInt(cateItemComponents.size());
            CateItemComponent randomCateItem = cateItemComponents.get(randomIndex);
            randomCateHref = randomCateItem.getComponent().getAttribute("href");
            randomCateItem.getComponent().click();
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains(randomCateHref));

        //Verify footer component
        verifyFooterComponent();
    }

    private static void verifyFooterColumn(
            FooterColumnComponent footerColumnComponent, List<String> expectedLinkTexts, List<String> expectedHrefs){
        List<String> actualLinkTexts = new ArrayList<>();
        List<String> actualHrefs = new ArrayList<>();

        for (WebElement link : footerColumnComponent.linksElm()) {
            actualLinkTexts.add(link.getText().trim());
            actualHrefs.add(link.getAttribute("href"));

        }
        if(actualLinkTexts.isEmpty() || actualHrefs.isEmpty()){
            Assert.fail("[ERR] Texts or hyperlink is empty in footer column");
        };

        //Verify link text
        Assert.assertEquals(actualLinkTexts, expectedLinkTexts, "[ERR] Actual and expected link texts are different");

        //Verify Hrefs
        Assert.assertEquals(actualHrefs, expectedHrefs, "[ERR] Actual and expected hyper link texts are different");

    }
}
