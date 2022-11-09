package ru.open;

import Steps.Steps;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.CitilinkHomePage;

public class Tests extends BaseTest {


    @Feature("Проверка тайтла")
    @Test
    public void firstTestTitle() {
        chromeDriver.get("https://bellintegrator.ru/");
        String title = chromeDriver.getTitle();
        System.out.println(title);
        Assertions.assertTrue(title.contains("Bell Integrator"), "Title doesn't contains " + title);
    }

    @Test
    public void cityLinkTest() {
        Steps.goPage("https://www.citilink.ru/");
        CitilinkHomePage citilinkHomePage = new CitilinkHomePage();
    }
}
