package com.saucedemo.framework.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    private Page page;

   private final String usernameInput = "#user-name";
   private final String passwordInput = "#password";
   private final String loginButton = "#login-button";

   public LoginPage(Page page) {
    this.page = page;
   }

        
        public void login(String username, String password) {
            page.locator(usernameInput).fill(username);
            page.locator(passwordInput).fill(password);
            page.locator(loginButton).click();

            try {
        page.waitForURL("**/inventory.html", new Page.WaitForURLOptions().setTimeout(5000));
    } catch (Exception e) {
        System.out.println("Login probably failed: Still on login page");
        System.out.println("Page content: " + page.content());
    }


        } 

    
    
}
