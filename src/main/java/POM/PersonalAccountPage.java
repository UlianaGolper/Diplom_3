package POM;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static ConstantsAndBrowserPath.Constants.PERSONAL_ACCOUNT_PAGE;

public class PersonalAccountPage {
    private final String url = PERSONAL_ACCOUNT_PAGE;
    private final By logOutButton = By.xpath(".//button[text()='Выход']");
    private final By constructorButton = By.linkText("Конструктор");
    private final By logo = By.className("AppHeader_header__logo__2D0X2");
    private final WebDriver driver;
    //надпись "профиль"


    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть страницу Личного кабинета")
    public void getPersonalAccountPage() {
        driver.get(url);
    }

    @Step("Нажать на кнопку Конструктор")
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    @Step("Нажать на Лого")
    public void clickLogo() {
        driver.findElement(logo).click();
    }

    @Step("Проверить отображение кнопки выход")
    public WebElement findlogOutButton() {
        return driver.findElement(logOutButton);
    }

    @Step("Нажать на кнопку Выход")
    public void clickLogOutButton() {
        driver.findElement(logOutButton).click();
    }

}

