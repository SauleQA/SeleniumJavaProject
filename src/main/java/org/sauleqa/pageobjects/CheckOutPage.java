package org.sauleqa.pageobjects;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.sauleqa.htmlelements.Element;

@Slf4j
public class CheckOutPage extends BasePage {

    Element userAddress = new Element(By.xpath("//*[@class='user__address']//input"));
    Element userAddressSelectOptions = new Element(By.xpath("//*[@class='user__address']//section//button//span"));
    Element confirmButton = new Element(By.xpath("//*[@class='actions']//a"));

    public CheckOutPage setUserAddress(String address) {
        log.info("Set value {} to Address field", address);
        userAddress.setValue(address);
        return this;
    }

    public CheckOutPage selectUserAddressOption(String option) {
        log.info("Select value {} from address options", option);
        userAddressSelectOptions.getElements().stream().filter(country -> country.getText()
                .equalsIgnoreCase(option)).findFirst().orElse(null).click();
        return this;
    }

    public ConfirmationPage clickConfirmButton() {
        log.info("Click confirm button");
        confirmButton.click();
        return new ConfirmationPage();
    }
}
