import ConstantsAndBrowserPath.BrowserRule;
import POM.MainPage;
import io.qameta.allure.Step;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConstructorTest {
    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    @Step("Проверить переходы по разделам «Булки», «Соусы»,«Начинки»")
    public void tabsSwitchingTest() {
        MainPage mainPage = new MainPage(browserRule.getDriver());
        mainPage.getMainPage();
        assertEquals("Булки", mainPage.checkActiveSection());
        mainPage.clickTabFillings();
        assertEquals("Начинки", mainPage.checkActiveSection());
        mainPage.clickTabSauces();
        assertEquals("Соусы", mainPage.checkActiveSection());
    }
}

