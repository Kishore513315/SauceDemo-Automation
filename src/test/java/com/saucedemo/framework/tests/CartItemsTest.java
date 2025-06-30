package com.saucedemo.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.saucedemo.framework.base.BaseTest;
import com.saucedemo.framework.pages.CartPage;
import com.saucedemo.framework.pages.HomeScreenPage;
import com.saucedemo.framework.pages.LoginPage;

public class CartItemsTest extends BaseTest {

    @Test
    public void itemsInCartTest() {
        Page page = getPage();
    
    // login
    LoginPage loginPage = new LoginPage(page);
    loginPage.login("standard_user", "secret_sauce");
    
    // Add items to cart from homepage
    HomeScreenPage homeScreenPage = new HomeScreenPage(page);
    homeScreenPage.addToCartMultipleItems();

    // click on cart icon
    page.locator(".shopping_cart_container > a").click();

    //validate items in cart
    CartPage cartPage = new CartPage(page);
    String[] items = cartPage.getItemNamesFromCart();

    Assert.assertTrue(items[0].contains("Backpack") || items[1].contains("Backpacl"), "Backpack should be shown in cart");
    Assert.assertTrue(items[0].contains("Bike Light") || items[1].contains("Bike Light"), "Bike Light should be shown in cart");
    
    //Remove one Item from cart
    cartPage.removeItemInCart("remove-sauce-labs-bike-light");

    //Click on continue shopping in cart page
    cartPage.continueShoppingInCartPage();

    //Check we are back on homescreen by checking product title
    boolean backAtHomePage = page.locator(".title").textContent().equals("Products");
    Assert.assertTrue(backAtHomePage, "Page displayed should be the homepage products screen");
    

}

}
