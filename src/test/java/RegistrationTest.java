import ConstantsAndBrowserPath.BrowserRule;
import POM.LoginPage;
import POM.RegistrationPage;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RegistrationTest {
    private final Faker faker = new Faker();
    private final String name = String.valueOf(faker.name());
    private final String email = String.valueOf(faker.internet().safeEmailAddress());
    private final String validPassword = String.valueOf(faker.internet().password(6, 30));
    private final String inValidPassword = String.valueOf(faker.internet().password(1, 5));
    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Step("Проверка успешной регистрации")
    @Test
    public void successfulRegistration() {
        RegistrationPage registrationPage = new RegistrationPage(browserRule.getDriver());
        LoginPage loginPage = new LoginPage(browserRule.getDriver());
        registrationPage.getRegistrationPage();
        registrationPage.fillInNameField(name);
        registrationPage.fillInEmailField(email);
        registrationPage.fillInPasswordField(validPassword);
        registrationPage.clickRegistrationButton();
        assertTrue(loginPage.findEnterButton().isDisplayed());
    }

    @Step("Проверка неуспешной регистрации")
    @Test
    public void failedRegistration() {
        RegistrationPage registrationPage = new RegistrationPage(browserRule.getDriver());
        LoginPage loginPage = new LoginPage(browserRule.getDriver());
        registrationPage.getRegistrationPage();
        registrationPage.fillInNameField(name);
        registrationPage.fillInEmailField(email);
        registrationPage.fillInPasswordField(inValidPassword);
        registrationPage.clickRegistrationButton();
        assertTrue(registrationPage.findIncorrectPasswordText().isDisplayed());
    }
}

