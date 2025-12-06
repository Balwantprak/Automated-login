package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;

    private By itemList = By.cssSelector(".cart_item");
    private By title = By.cssSelector("span.title");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getItemCount() {
        return driver.findElements(itemList).size();
    }

    public String getHeaderText() {
        return driver.findElement(title).getText();
    }
}
