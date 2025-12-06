package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

public class CheckoutTests extends BaseTest {

    @Test(groups = "checkout")
    public void addItemToCartTest() {
        LoginPage login = new LoginPage(driver());
        login.open();
        login.login("standard_user", "secret_sauce");

        ProductsPage products = new ProductsPage(driver());
        Assert.assertEquals(products.getTitleText(), "Products");

        products.addItemToCart();
        products.openCart();

        CartPage cart = new CartPage(driver());
        Assert.assertEquals(cart.getHeaderText(), "Your Cart");
        Assert.assertTrue(cart.getItemCount() > 0);
    }
}
