package com;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class RegistrationPage {

    // Поле ввода "Имя"
    @FindBy(how = How.XPATH, using = ".//fieldset[1]//input")
    private SelenideElement inputName;

    // Поле ввода "Email"
    @FindBy(how = How.XPATH, using = ".//fieldset[2]//input")
    private SelenideElement inputEmail;

    // Поле ввода "Пароль"
    @FindBy(how = How.XPATH, using = ".//fieldset[3]//input")
    private SelenideElement inputPassword;

    // Кнопка "Зарегистрироваться"
    @FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    private SelenideElement regButton;

    // Сообщение "Некрорректный пароль"
    @FindBy(how = How.XPATH, using = ".//*[@class='input__error text_type_main-default']")
    private SelenideElement passErrorMessage;

    // Ссылка "Войти"
    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    private SelenideElement loginLink;


    public RegistrationPage setName(String name) {
        inputName.click();
        inputName.setValue(name);
        return this;
    }

    public RegistrationPage setEmail(String email) {
        inputEmail.click();
        inputEmail.setValue(email);
        return this;
    }

    public RegistrationPage setPassword(String password) {
        inputPassword.click();
        inputPassword.setValue(password);
        return this;
    }

    public RegistrationPage regButtonClick() {
        regButton.click();
        return this;
    }
    public UserLoginPage loginLinkClick() {
        loginLink.click();
        return page(UserLoginPage.class);
    }

    public UserLoginPage redirectionCheck() {
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/login"));
        return page(UserLoginPage.class);
    }

    public String getPassErrorMessageText() {
        passErrorMessage.shouldBe(Condition.visible);
        return passErrorMessage.getText();
    }
}

