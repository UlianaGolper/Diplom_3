package POM;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static ConstantsAndBrowserPath.Constants.REGISTRATION_PAGE;

public class RegistrationPage {
    private final String url = REGISTRATION_PAGE;
    private final By nameField = By.xpath(".//div[label[text()='Имя']]/input");
    private final By emailField = By.xpath(".//div[label[text()='Email']]/input");
    //Поле ввода пароля
    private final By passwordField = By.xpath(".//div[label[text()='Пароль']]/input");
    //Кнопка "Зарегистрироваться"
    private final By registrationButton = By.xpath(".//button[text()='Зарегистрироваться']");
    //Кнопка "Войти"
    private final By enterButton = By.linkText("Войти");
    //Текст ошибки "Некорректный пароль"
    private final By incorrectPasswordText = By.className("input__error");
    private final WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть страницу регистрации пользователя")
    public void getRegistrationPage() {
        driver.get(url);
    }

    @Step("Ввести Имя")
    public void fillInNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    @Step("Ввести Email")
    public void fillInEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Ввести Пароль")
    public void fillInPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Кликнуть на кнопку Зарегистрироваться")
    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    @Step("Кликнуть на кнопку Войти")
    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }

    @Step("Найти ошибку ввода некорректного пароля")
    public WebElement findIncorrectPasswordText() {
        return driver.findElement(incorrectPasswordText);
    }
}
