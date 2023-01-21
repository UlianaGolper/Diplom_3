package ConstantsAndBrowserPath;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class BrowserRule extends ExternalResource {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @Override
    protected void before() throws Throwable {
        System.getProperty("webdriver.CHROME_DRIVER");
        driver = new ChromeDriver();
        // System.getProperty("webdriver.YANDEX_DRIVER");
        // ChromeOptions options = new ChromeOptions();
        //options.setBinary("C:/Users/79114/AppData/Local/Yandex/YandexBrowser/Application/browser.exe");
        //driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Override
    protected void after() {
        driver.quit();
    }
}

