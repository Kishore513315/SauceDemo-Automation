package com.saucedemo.framework.tests;

import com.saucedemo.framework.base.BaseTest;
import com.saucedemo.framework.pages.LoginPage;

import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
//import org.testng.asserts.Assertion;

public class MenuAboutLinkTest extends BaseTest {

    @Test
    public void aboutLinkTest() {
        
         LoginPage loginPage = new LoginPage(page);
         loginPage.login("standard_user", "secret_sauce");

         page.locator("#react-burger-menu-btn").click();
         page.locator("#about_sidebar_link").click();

        page.waitForLoadState();


         assertTrue(page.url().contains("saucelabs"), "User should be in Saucelabs page");

        String title = page.title();
        System.out.println("Page Title: " + title);
        assertTrue(title.toLowerCase().contains("sauce labs"), "Title should contain 'Sauce Labs'");
   
         
   }

}
