package helpers;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebDriverManager {

    private static WebDriver currentDriver;

    public static WebDriver getCurrentDriver() {
        return currentDriver;
    }

    public static void initChrome() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(List.of("start-maximized", "--headless"));
        try {
            currentDriver = new ChromeDriver(chromeOptions);

        } catch (SessionNotCreatedException e) {
            Assertions.fail("Данный драйвер не совместим с текущим браузером. Используйте другой драйвер");
        }
        setDriverDefaultSettings();
    }

    public static void setDriverDefaultSettings() {
        currentDriver.manage().timeouts().implicitlyWait(Constants.DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        currentDriver.manage().deleteAllCookies();
    }

    public static void killCurrentDriver() {
        if (currentDriver != null) {
            currentDriver.quit();
            currentDriver = null;
        }
    }
}
