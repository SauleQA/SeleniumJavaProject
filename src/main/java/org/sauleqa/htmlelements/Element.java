package org.sauleqa.htmlelements;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

@Slf4j
public class Element {

    By locator;
    Duration timeout = Duration.ofSeconds(3);

    public Element(By locator) {
        this.locator = locator;
    }

    public SelenideElement getElement() {
        return $(locator).shouldBe(visible);
    }

    public List<SelenideElement> getElements() {
        return $$(locator).shouldHave(CollectionCondition.sizeGreaterThan(0));
    }

    public void waitForElementToDisappear() {
        getElement().shouldBe(disappear, timeout);
    }

    public SelenideElement waitForElementToBeClickable() {
        return getElement().shouldBe(interactable, timeout);
    }

    public void waitForElementToHaveText(String text) {
        getElement().shouldHave(text(text), timeout);
    }

    public void click() {
        waitForElementToBeClickable().click();
    }

    public void setValue(String value) {
        getElement().clear();
        getElement().setValue(value);
    }

    public String getText() {
        return getElement().getText();
    }
}
