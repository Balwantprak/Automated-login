package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    private WebDriver driver;

    private By title = By.cssSelector("span.title");
    private By addToCart = By.cssSelector("button.btn_inventory");
    private By cart = By.id("shopping_cart_container");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitleText() {
        return driver.findElement(title).getText();
    }

    public void addItemToCart() {
        driver.findElements(addToCart).get(0).click();
    }

    public void openCart() {
        driver.findElement(cart).click();
    }
}
