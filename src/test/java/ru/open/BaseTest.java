package ru.open;

import helpers.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected WebDriver chromeDriver;

    @BeforeEach
    public void beforeEach() {
        WebDriverManager.initChrome();
        chromeDriver = WebDriverManager.getCurrentDriver();
    }

    @AfterEach
    public void afterEach() {
        WebDriverManager.killCurrentDriver();
    }
}


