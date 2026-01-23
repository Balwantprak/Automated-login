package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import utils.CSVReader;

public class LoginTests extends BaseTest {

    private static final String CSV_FILE_PATH = "src/test/resources/login_data.csv";

    @DataProvider(name = "validLoginData")
    public Object[][] validLoginData() {
        return CSVReader.readValidLoginData(CSV_FILE_PATH);
    }

    @DataProvider(name = "invalidLoginData")
    public Object[][] invalidLoginData() {
        return CSVReader.readInvalidLoginData(CSV_FILE_PATH);
    }

    @Test(groups = "login", dataProvider = "validLoginData")
    public void validLoginTest(String username, String password) {
        LoginPage login = new LoginPage(driver());
        login.open();
        login.login(username, password);

        ProductsPage products = new ProductsPage(driver());
        Assert.assertEquals(products.getTitleText(), "Products", 
            "Login failed for user: " + username);
    }

    @Test(groups = "login", dataProvider = "invalidLoginData")
    public void invalidLoginTest(String username, String password) {
        LoginPage login = new LoginPage(driver());
        login.open();
        login.login(username, password);

        Assert.assertNotNull(login.getErrorMessage(), 
            "Error expected for invalid login with user: " + username);
    }
}
