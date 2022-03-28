package com.testinium.test;

import com.testinium.driver.BaseTest;
import com.testinium.page.LoginPage;
import com.testinium.page.ProductPage;
import org.junit.Test;

public class ProductTest extends BaseTest {

    @Test
    public void productTest() {
        LoginPage loginPage = new LoginPage();
        ProductPage productPage = new ProductPage();
        loginPage.login();
        productPage.selectProduct();
        productPage.randomFavorites();
        productPage.getFavorites();
        productPage.puanCatalog();
        productPage.booksHobi();
        productPage.shoppingList();
        productPage.addProdouct();
        productPage.addHomeAddress();
        productPage.loguot();
    }
}
