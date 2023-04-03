package org.sauleqa.pageobjects;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.sauleqa.htmlelements.Element;

@Slf4j
public class ProductCatalogue extends BasePage {

    String productCatalogueUrl = "https://www.rahulshettyacademy.com/client/dashboard/dash";
    Element products = new Element(By.xpath("//div[contains(@class,'mb-3')]"));

    public boolean isLoginSuccessfully() {
        String currentURL = WebDriverRunner.getWebDriver().getCurrentUrl();
        String toast = getToastText();
        log.info("Check that login was successful with toast {}, current page is {} ", toast, currentURL);
        return currentURL.equalsIgnoreCase(productCatalogueUrl)
                && toast.equalsIgnoreCase("Login Successfully");
    }

    public SelenideElement getProductByName(String name) {
        return products.getElements().stream().filter(product -> product.$(By.xpath(".//h5/b"))
                .getText().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public ProductCatalogue addProductToCart(String productName) {
        log.info("Add product with name {} to cart", productName);
        int currentNumberOfProductsInCart = 0;
        if (!numberOfProductsInCart.getText().isEmpty()) {
            currentNumberOfProductsInCart = Integer.parseInt(numberOfProductsInCart.getText());
        }
        getProductByName(productName).$(By.xpath(".//button[contains(text(),'Add To Cart')]")).click();
        loader.waitForElementToDisappear();
        String newNumberOfProductsInCart = String.valueOf(currentNumberOfProductsInCart + 1);
        numberOfProductsInCart.waitForElementToHaveText(newNumberOfProductsInCart);
        return this;
    }
}
