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

public class LogOutTest {
    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    @Step("Проверка разлогина по кнопке выход")
    public void logOutTest() {
        LoginPage loginPage = new LoginPage(browserRule.getDriver());
        MainPage mainPage = new MainPage(browserRule.getDriver());
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(browserRule.getDriver());
        loginPage.getLoginPage();
        loginPage.logInUser(VALID_EMAIL, VALID_PASSWORD);
        mainPage.clickPersonalAccountButton();
        personalAccountPage.clickLogOutButton();
        assertTrue(loginPage.findEnterButton().isDisplayed());
    }
}
