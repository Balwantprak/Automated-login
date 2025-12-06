package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private String url = "https://www.saucedemo.com/";

    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginBtn = By.id("login-button");
    private By errorText = By.cssSelector("h3[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(url);
    }

    public void login(String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }

    public String getErrorMessage() {
        try { return driver.findElement(errorText).getText(); }
        catch (Exception e) { return null; }
    }
}
