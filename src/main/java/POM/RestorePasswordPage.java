package POM;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static ConstantsAndBrowserPath.Constants.RESTORE_PASSWORD_PAGE;

public class RestorePasswordPage {
    private final String url = RESTORE_PASSWORD_PAGE;
    //Кнопка "Войти"
    private final By enterButton = By.linkText("Войти");
    private final WebDriver driver;


    public RestorePasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть страницу восстановления пользователя")
    public void getRestorePasswordPage() {
        driver.get(url);
    }

    @Step("Кликнуть по кнопке входа в аккаунт")
    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }
}

