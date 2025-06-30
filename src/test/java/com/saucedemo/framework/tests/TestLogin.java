package com.saucedemo.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.framework.base.BaseTest;
import com.saucedemo.framework.pages.LoginPage;

public class TestLogin extends BaseTest {

@Test
public void loginTest() {

    LoginPage loginPage = new LoginPage(page);
    loginPage.login("standard_user", "secret_sauce");

    String currentUrl = page.url();
    System.out.println("current URL: " + currentUrl);

    Assert.assertTrue(page.url().contains("inventory"), "Login Failed - Inventory Page not reached");
}

    
    
@Test
public void testInvalidLogin() {

    LoginPage loginPage = new LoginPage(page);
    loginPage.login("kishore_user", "Login_demo");

    String errorMessage = page.locator("[data-test='error']").textContent();

    System.out.println("Error Message:" + errorMessage);

    Assert.assertTrue(errorMessage.contains("do not match"), "Error Message is not displayed");

    }



}
