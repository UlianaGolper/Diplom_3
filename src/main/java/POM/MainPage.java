package POM;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static ConstantsAndBrowserPath.Constants.MAIN_PAGE;

public class MainPage {
    private final String url = MAIN_PAGE;
    //кнопка "Войти в аккаунт"
    private final By enterButton = By.xpath("//*[.='Войти в аккаунт']");
    //кнопка "Личный кабинет"
    private final By personalAccountButton = By.linkText("Личный Кабинет");
    //кнопка "Оформить заказ"
    private final By makeAnOrderButton = By.xpath("//*[.='Оформить заказ']");
    //таб "Булки"
    private final By tabBuns = By.xpath(".//span[text()='Булки']");
    //таб "Соусы"
    private final By tabSauces = By.xpath(".//span[text()='Соусы']");
    //таб "Начинки"
    private final By tabFillings = By.xpath(".//span[text() = 'Начинки']");
    private final By activeTab = By.className("tab_tab_type_current__2BEPc");
    //заголовок раздела "Булки"
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть главную страницу")
    public void getMainPage() {
        driver.get(url);
    }

    @Step("Кликнуть по кнопке входа в аккаунт")
    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }

    @Step("Кликнуть по кнопке Личный кабинет")
    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    @Step("Выбрать таб Булки")
    public void clickTabBuns() {
        driver.findElement(tabBuns).click();
    }

    @Step("Выбрать таб Соусы")
    public void clickTabSauces() {
        driver.findElement(tabSauces).click();
    }

    @Step("Выбрать таб Начинки")
    public void clickTabFillings() {
        driver.findElement(tabFillings).click();
    }

    @Step("Найти кнопку оформить заказ")
    public WebElement findMakeAnOrderButton() {
        return driver.findElement(makeAnOrderButton);
    }

    @Step("Проверить активный раздел")
    public String checkActiveSection() {
        return driver.findElement(activeTab).getText();
    }
}
