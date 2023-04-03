package org.sauleqa.pageobjects;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.sauleqa.htmlelements.Element;

@Slf4j
public class CartPage extends BasePage {

    Element cartProducts = new Element(By.xpath("//*[@class='cartSection']//h3"));
    Element checkoutButton = new Element(By.xpath("//*[@class='totalRow']//button"));

    public boolean isProductInCart(String productName) {
        log.info("Check is product with name {} in cart", productName);
        return cartProducts.getElements().stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
    }

    public CheckOutPage clickCheckoutButton() {
        log.info("Click checkout button");
        checkoutButton.click();
        return new CheckOutPage();
    }
}
