package org.sauleqa.pageobjects;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.sauleqa.htmlelements.Element;

@Slf4j
public class BasePage {

    Element goToCartButton = new Element(By.xpath("//button[@routerlink='/dashboard/cart']"));
    Element numberOfProductsInCart = new Element(By.xpath("//button[@routerlink='/dashboard/cart']/label"));
    Element goToOrders = new Element(By.xpath("//button[@routerlink='/dashboard/myorders']"));
    Element loader = new Element(By.xpath("//*[contains(@class,'ng-animating')]"));
    Element toast = new Element(By.xpath("//*[@id='toast-container']"));

    public CartPage goToCart() {
        log.info("Open Cart page");
        goToCartButton.click();
        return new CartPage();
    }

    public OrdersPage goToOrders() {
        log.info("Open Orders page");
        goToOrders.click();
        return new OrdersPage();
    }

    public String getToastText() {
        return toast.getText();
    }
}
