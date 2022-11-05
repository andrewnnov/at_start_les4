package ru.open;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests extends BaseTest {


    @Feature("Проверка тайтла")
    @Test
    public void firstTestTitle() {
        chromeDriver.get("https://bellintegrator.ru/");
        String title = chromeDriver.getTitle();
        System.out.println(title);
        Assertions.assertTrue(title.contains("Bell Integrator"), "Title doesn't contains " + title);
    }
}
