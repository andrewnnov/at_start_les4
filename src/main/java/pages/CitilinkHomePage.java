package pages;

import helpers.WebDriverManager;
import helpers.WebDriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CitilinkHomePage {
    private WebDriver driver;
    protected String itemCatalogButtonLocator = "//button[@data-label='Каталог товаров']";
    //protected String noteBooksAndComputerLocator = "//a[@data-title='Ноутбуки и компьютеры']";
    protected String videoCardButtonLocator = "//a[@class='CatalogMenu__subcategory-link' and @data-title='Видеокарты']";


    public CitilinkHomePage() {
        this.driver = WebDriverManager.getCurrentDriver();
    }

    public void goToVideoCardsSearchPage() {
        driver.findElement(By.xpath(itemCatalogButtonLocator)).click();
        hoverOnCategory("Ноутбуки и компьютеры");
        WebElement videoCardButton = driver.findElement(By.xpath(videoCardButtonLocator));
        WebDriverWaits.isVisible(videoCardButton);
        videoCardButton.click();
    }

    public void hoverOnCategory(String categoryName) {
        String categoryButtonLocator = "//a[@data-title='" + categoryName + "']";
        WebElement categoryButton = driver.findElement(By.xpath(categoryButtonLocator));
        Actions actions = new Actions(driver);
        actions.moveToElement(categoryButton).perform();

    }
}
