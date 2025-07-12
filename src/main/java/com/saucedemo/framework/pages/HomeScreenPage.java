package com.saucedemo.framework.pages;

import java.util.List;
import java.util.ArrayList;

import com.microsoft.playwright.Page;

public class HomeScreenPage {

   private Page page;

   public  HomeScreenPage(Page page) {
          this.page = page;

   }

   private final String backPack = "[data-test='add-to-cart-sauce-labs-backpack']";
   private final String bikeLight = "[data-test='add-to-cart-sauce-labs-bike-light']";

   public void addToCartMultipleItems() {
    page.locator(backPack).click();
    page.locator(bikeLight).click();
   }

    public void selectSortOption(String value) {
    page.waitForSelector("[data-test='product-sort-container']");
    page.locator("[data-test='product-sort-container']").selectOption(value);
}

public List<Double> getAllProductPrices() {
    List<String> priceTexts = page.locator(".inventory_item_price").allTextContents();
    List<Double> prices = new ArrayList<>();
    for (String text : priceTexts) {
        prices.add(Double.parseDouble(text.replace("$", "")));
    }
    return prices;
}

public List<String> getAllProductNames() {
    return page.locator(".inventory_item_name").allTextContents();
}


   }
   




