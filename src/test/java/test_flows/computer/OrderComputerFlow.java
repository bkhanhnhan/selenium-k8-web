package test_flows.computer;

import models.components.order.ComputerEssentialComponent;
import models.components.order.ComputerItemDetailPage;
import org.openqa.selenium.WebDriver;

public class OrderComputerFlow<T extends ComputerEssentialComponent> {

    private final WebDriver driver;

    private final Class<T> computerEssentialComponent;

    public OrderComputerFlow(WebDriver driver, Class<T> computerEssentialComponent) {
        this.driver = driver;
        this.computerEssentialComponent = computerEssentialComponent;
    }

    public void buildComputerSpecAndAddCart(){
        ComputerItemDetailPage computerItemDetailPage = new ComputerItemDetailPage(driver);
        T computerEssentialComp = computerItemDetailPage.computerComponent(computerEssentialComponent);
        computerEssentialComp.selectProcessorType("Fast");
        computerEssentialComp.selectRAMType("4 GB");

        try {
            Thread.sleep(5000);
        }catch (Exception e){}
    };
}
