package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginTests extends BaseTest {

    @DataProvider(name = "invalidLoginData")
    public Object[][] invalidData() {
        return new Object[][]{
                {"standard_user", "wrong_pass"},
                {"locked_out_user", "secret_sauce"},
                {"", "secret_sauce"},
                {"standard_user", ""}
        };
    }

    @Test(groups = "login")
    public void validLoginTest() {
        LoginPage login = new LoginPage(driver());
        login.open();
        login.login("standard_user", "secret_sauce");

        ProductsPage products = new ProductsPage(driver());
        Assert.assertEquals(products.getTitleText(), "Products");
    }

    @Test(groups = "login", dataProvider = "invalidLoginData")
    public void invalidLoginTest(String user, String pass) {
        LoginPage login = new LoginPage(driver());
        login.open();
        login.login(user, pass);

        Assert.assertNotNull(login.getErrorMessage(), "Error expected for invalid login!");
    }
}
