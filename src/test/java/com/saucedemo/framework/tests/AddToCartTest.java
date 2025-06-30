package com.saucedemo.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.saucedemo.framework.base.BaseTest;
import com.saucedemo.framework.pages.HomeScreenPage;
import com.saucedemo.framework.pages.LoginPage;

public class AddToCartTest extends BaseTest {

    @Test
    public void addMultipleItemsTocartTest() {
      Page page = getPage();

      LoginPage loginPage = new LoginPage(page);
      loginPage.login("standard_user", "secret_sauce");
      
      HomeScreenPage homePage = new HomeScreenPage(page);
      homePage.addToCartMultipleItems();

      String cartCount = page.locator(".shopping_cart_badge").textContent();
      Assert.assertEquals(cartCount, "2", " Cart count should be 2");

    }

}
