import ConstantsAndBrowserPath.BrowserRule;
import POM.*;
import io.qameta.allure.Step;
import org.junit.Rule;
import org.junit.Test;

import static ConstantsAndBrowserPath.Constants.VALID_EMAIL;
import static ConstantsAndBrowserPath.Constants.VALID_PASSWORD;
import static org.junit.Assert.assertTrue;

public class LogInTest {
    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Step("Вход по кнопке «Войти в аккаунт» на главной")
    @Test
    public void successfulLogInFromMainPage() {
        MainPage mainPage = new MainPage(browserRule.getDriver());
        LoginPage loginPage = new LoginPage(browserRule.getDriver());
        mainPage.getMainPage();
        mainPage.clickEnterButton();
        loginPage.logInUser(VALID_EMAIL, VALID_PASSWORD);
        assertTrue(mainPage.findMakeAnOrderButton().isDisplayed());
    }

    @Step("Вход через кнопку «Личный кабинет»")
    @Test
    public void successfulLogInFromPersonalAccountPage() {
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(browserRule.getDriver());
        LoginPage loginPage = new LoginPage(browserRule.getDriver());
        MainPage mainPage = new MainPage(browserRule.getDriver());
        mainPage.getMainPage();
        mainPage.clickPersonalAccountButton();
        loginPage.logInUser(VALID_EMAIL, VALID_PASSWORD);
        assertTrue(mainPage.findMakeAnOrderButton().isDisplayed());
    }


    @Step("Вход через кнопку в форме регистрации")
    @Test
    public void successfulLogInFromRegistrationPage() {
        RegistrationPage registrationPage = new RegistrationPage(browserRule.getDriver());
        LoginPage loginPage = new LoginPage(browserRule.getDriver());
        MainPage mainPage = new MainPage(browserRule.getDriver());
        registrationPage.getRegistrationPage();
        registrationPage.clickEnterButton();
        loginPage.logInUser(VALID_EMAIL, VALID_PASSWORD);
        assertTrue(mainPage.findMakeAnOrderButton().isDisplayed());
    }


    @Step("Вход через кнопку в форме восстановления пароля")
    @Test
    public void successfulLogInFromRestorePasswordPage() {
        RestorePasswordPage restorePasswordPage = new RestorePasswordPage(browserRule.getDriver());
        LoginPage loginPage = new LoginPage(browserRule.getDriver());
        MainPage mainPage = new MainPage(browserRule.getDriver());
        restorePasswordPage.getRestorePasswordPage();
        restorePasswordPage.clickEnterButton();
        loginPage.logInUser(VALID_EMAIL, VALID_PASSWORD);
        assertTrue(mainPage.findMakeAnOrderButton().isDisplayed());
    }

}
