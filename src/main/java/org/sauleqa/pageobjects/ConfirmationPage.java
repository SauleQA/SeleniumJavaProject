package org.sauleqa.pageobjects;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.sauleqa.htmlelements.Element;

@Slf4j
public class ConfirmationPage {

    public static String orderNum;
    Element confirmText = new Element(By.xpath("//*[@class='hero-primary']"));
    Element orderNumber = new Element(By.xpath("//tr[@class='ng-star-inserted']/td[@class='em-spacer-1']/label"));

    public String getConfirmText() {
        String result = confirmText.getText();
        log.info("Get confirm message of order : {}", result);
        return result;
    }

    public ConfirmationPage getOrderNumber() {
        String orderNumberText = orderNumber.getText();
        orderNum = orderNumberText.substring(2, orderNumberText.length() - 2);
        log.info("Get number of order : {}", orderNum);
        return this;
    }
}
