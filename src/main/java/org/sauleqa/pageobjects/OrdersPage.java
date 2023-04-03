package org.sauleqa.pageobjects;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.sauleqa.htmlelements.Element;

import java.util.List;

@Slf4j
public class OrdersPage extends BasePage {

    Element orders = new Element(By.xpath("//tbody//tr"));

    public List<SelenideElement> getOrders() {
        return orders.getElements();
    }

    public SelenideElement getLastOrder() {
        List<SelenideElement> orders = getOrders();
        int lastIndex = orders.size() - 1;
        return getOrders().get(lastIndex);
    }

    public String getOrderId(SelenideElement order) {
        return order.$(By.xpath("./th")).getText();
    }

    public String getOrderIdOfLastOrder() {
        SelenideElement lastOrder = getLastOrder();
        String orderID = getOrderId(lastOrder);
        log.info("Order ID of last order is {}", orderID);
        return orderID;
    }
}
