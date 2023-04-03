package org.sauleqa.pageobjects;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.sauleqa.htmlelements.Element;

import static org.sauleqa.configs.TestConfig.USER_EMAIL;
import static org.sauleqa.configs.TestConfig.USER_PASSWORD;

@Slf4j
public class LoginPage extends BasePage {

    Element userEmail = new Element(By.id("userEmail"));
    Element userEmailError = new Element(By.xpath("//label[@for='email']//following-sibling::div[contains(@class, 'invalid-feedback')]/div"));
    Element userPassword = new Element(By.id("userPassword"));
    Element userPasswordError = new Element(By.xpath("//label[@for='password']//following-sibling::div[contains(@class, 'invalid-feedback')]/div"));
    Element loginButton = new Element(By.id("login"));
    Element loginError = new Element(By.xpath("//*[@role='alertdialog']"));

    public void setEmailAndPassword(String email, String password) {
        userEmail.setValue(email);
        userPassword.setValue(password);
    }

    public LoginPage loginWithIncorrectCredentials(String email, String password) {
        log.info("Login by incorrect credentials email {} and password {}", email, password);
        setEmailAndPassword(email, password);
        loginButton.click();
        return this;
    }

    public ProductCatalogue login() {
        log.info("Login by correct email {} and password {}", USER_EMAIL, USER_PASSWORD);
        setEmailAndPassword(USER_EMAIL, USER_PASSWORD);
        loginButton.click();
        loader.waitForElementToDisappear();
        return new ProductCatalogue();
    }

    public String getLoginErrorMessage() {
        String error = loginError.getText();
        log.info("Get login error message : {}", error);
        return error;
    }

    public String getEmailErrorMessage() {
        String error = userEmailError.getText();
        log.info("Get login email error message : {}", error);
        return error;
    }

    public String getPasswordErrorMessage() {
        String error = userPasswordError.getText();
        log.info("Get login password error message : {}", error);
        return error;
    }
}
