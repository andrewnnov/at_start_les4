package Steps;

import helpers.WebDriverManager;
import io.qameta.allure.Step;
import pages.CitilinkHomePage;

public class Steps {

    @Step("Перейти на страницу {url}")
    public static void goPage(String url) {
        WebDriverManager.getCurrentDriver().get(url);

    }

//    @Step("Получить курс {currencyName} по типу {currencyType}")
//    public static Double getCourse(ExchangePage page, String currencyName, String currencyType) {
//        page.preActions();
//        return page.getCource(currencyName, currencyType);
//    }
//
//    @Step("Перейти на страницу поиска {categoryName}/{subcategoryName}")
//    public static void goMenu(CitilinkHomePage page, String category, String chapterSubCategory, String subCategory) {
//        page.goMenu(category, chapterSubCategory, subCategory);
//    }
}
