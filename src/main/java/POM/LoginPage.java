package POM;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static ConstantsAndBrowserPath.Constants.LOGIN_PAGE;

public class LoginPage {
    private final String url = LOGIN_PAGE;
    //Поле ввода email
    private final By emailField = By.xpath(".//label[text()='Email']/parent::*/input");
    //Поле ввода пароля
    private final By passwordField = By.xpath(".//label[text()='Пароль']/parent::*/input");
    //Кнопка "Войти"
    private final By enterButton = By.xpath(".//button[text() = 'Войти']");
    //Кнопка "Зарегистрироваться"
    private final By registrationButton = By.xpath(".//a[text() = 'Зарегистрироваться']");
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть страницу входа в аккаунт")
    public void getLoginPage() {
        driver.get(url);
    }

    @Step("Заполнить форму входа")
    public void logInUser(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(enterButton).click();
    }

    @Step("Кликнуть на кнопку Войти") //если понадобится в других тестах
    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }

    @Step("Найти кнопку Войти")
    public WebElement findEnterButton() {
        return driver.findElement(enterButton);
    }

    @Step("Кликнуть на кнопку Зарегистрироваться")
    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

}
