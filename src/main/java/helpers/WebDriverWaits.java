package helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WebDriverWaits {

    public static boolean isVisible(WebElement element) {
        return element.isDisplayed();
    }

    private static void waitUntilElementBeVisible(WebElement element) {
        if (isVisible(element)) return;
        new WebDriverWait(WebDriverManager.getCurrentDriver(), Constants.DEFAULT_TIMEOUT)
                .until(ExpectedConditions.visibilityOf(element));
    }

    private static void waitUntilElementBeClickable(WebElement element) {
        new WebDriverWait(WebDriverManager.getCurrentDriver(), Constants.DEFAULT_TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    private static void waitUntilElementTextContains(WebElement element, String text) {
        new WebDriverWait(WebDriverManager.getCurrentDriver(), Constants.DEFAULT_TIMEOUT)
                .until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public static void waitUntilElementTextContainsByLocator(By locator, String text) {
        new WebDriverWait(WebDriverManager.getCurrentDriver(), Constants.DEFAULT_TIMEOUT)
                .until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    public static void waitUntilElementsCountWillBe(String xpath, Integer number) {
        new WebDriverWait(WebDriverManager.getCurrentDriver(), Constants.DEFAULT_TIMEOUT)
                .until(ExpectedConditions.numberOfElementsToBe(By.xpath(xpath), number));
    }

    public static boolean isClickable(WebElement element) {
        try {
            waitUntilElementBeClickable(element);
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    public static boolean isElementTextContains(WebElement element, String text) {
        try {
            waitUntilElementTextContains(element, text);
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    public static boolean isElementNotExist(WebElement element) {
        int timer = 0;
        WebDriverManager.getCurrentDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        try {
            while (isVisible(element) && timer < Constants.DEFAULT_TIMEOUT/3) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                timer++;
            }
            return false;
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return true;
        } finally {
            WebDriverManager.getCurrentDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }

    public static void waitUntilAttributeWillBe(WebElement element, String attribute, String value) {
        new WebDriverWait(WebDriverManager.getCurrentDriver(), Constants.DEFAULT_TIMEOUT)
                .until((ExpectedCondition<Boolean>) driver -> element.getAttribute(attribute).contains(value));
    }
}
