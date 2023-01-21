import ConstantsAndBrowserPath.BrowserRule;
import POM.LoginPage;
import POM.MainPage;
import POM.PersonalAccountPage;
import io.qameta.allure.Step;
import org.junit.Rule;
import org.junit.Test;

import static ConstantsAndBrowserPath.Constants.VALID_EMAIL;
import static ConstantsAndBrowserPath.Constants.VALID_PASSWORD;
import static org.junit.Assert.assertTrue;

public class ReturnToMainPageTest {
    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    @Step("Проверка перехода по клику на «Конструктор»")
    public void returnToTheMainPageTestByConstructorButton() {
        LoginPage loginPage = new LoginPage(browserRule.getDriver());
        MainPage mainPage = new MainPage(browserRule.getDriver());
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(browserRule.getDriver());
        loginPage.getLoginPage();
        loginPage.logInUser(VALID_EMAIL, VALID_PASSWORD);
        mainPage.clickPersonalAccountButton();
        personalAccountPage.clickConstructorButton();
        assertTrue(mainPage.findMakeAnOrderButton().isDisplayed());
    }

    @Test
    @Step("Проверка перехода по клику на логотип Stellar Burgers")
    public void returnToTheMainPageTestByLogo() {
        LoginPage loginPage = new LoginPage(browserRule.getDriver());
        MainPage mainPage = new MainPage(browserRule.getDriver());
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(browserRule.getDriver());
        loginPage.getLoginPage();
        loginPage.logInUser(VALID_EMAIL, VALID_PASSWORD);
        mainPage.clickPersonalAccountButton();
        personalAccountPage.clickLogo();
        assertTrue(mainPage.findMakeAnOrderButton().isDisplayed());
    }
}
