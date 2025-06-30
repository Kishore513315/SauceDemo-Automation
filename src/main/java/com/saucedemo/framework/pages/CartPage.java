package com.saucedemo.framework.pages;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CartPage {

    private final Page page;

    public  CartPage(Page page) {
        this.page = page;
    }

    private final String itemsInCart = ".inventory_item_name";

    // See items in cart
    public String[] getItemNamesFromCart() {
        Locator items =  page.locator(itemsInCart);
        int count = items.count();
        String[] names = new String[count];
        for(int i = 0; i < count; i ++) {
            names[i] = items.nth(i).textContent();
        }
        return names;
    }

    // Remove one item from cart
    public void removeItemInCart(String dataTestId) {
        page.locator("[data-test='" + dataTestId + "']").click();
    }

    // Click continue shopping on cart page
    public void continueShoppingInCartPage() {
        page.locator("[data-test='continue-shopping']").click();
    
    }
}
