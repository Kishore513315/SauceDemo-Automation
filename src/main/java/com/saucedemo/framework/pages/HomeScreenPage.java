package com.saucedemo.framework.pages;

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
   



}
