package com.saucedemo.framework.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import com.microsoft.playwright.Page;
import com.saucedemo.framework.base.BaseTest;
import com.saucedemo.framework.pages.HomeScreenPage;
import com.saucedemo.framework.pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SortFunctionalityTest extends BaseTest {

    @Test
    public void sortPriceLowToHigh() {
        Page page = getPage();

    LoginPage loginPage = new LoginPage(page);
    loginPage.login("standard_user", "secret_sauce");

    
    System.out.println("After Login - URL: " + page.url());
    System.out.println("Page Title" + page.title());


    HomeScreenPage homeScreenPage = new HomeScreenPage(page);
    //homeScreenPage.selectSortOption("lohi");     //Sorting Prices low to high 
   // homeScreenPage.selectSortOption("za");       //Sorting product names z to a
   //homeScreenPage.selectSortOption("az");    //Sorting product names a to z
   homeScreenPage.selectSortOption("hilo");

 
    List<Double> actualPrices = homeScreenPage.getAllProductPrices();
    List<Double> expectedPrices = new ArrayList<>(actualPrices);
    //Collections.sort(expectedPrices);
    Collections.sort(expectedPrices, Collections.reverseOrder());
    Assert.assertEquals(actualPrices, expectedPrices, "Prices are not sorted high to low");
    

    /* 
    List<String> actualNames = homeScreenPage.getAllProductNames();
    List<String> expectedNames = new ArrayList<>(actualNames);
    //Collections.sort(expectedNames, Collections.reverseOrder());
    Collections.sort(expectedNames);
    Assert.assertEquals(actualNames, expectedNames, "Products are not sorted from a to z");
    */
    }

}
