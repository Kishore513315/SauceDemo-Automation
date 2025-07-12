
package com.saucedemo.framework.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BaseTest {
    protected static Playwright playwright;
    protected static Browser browser;
    protected BrowserContext context;
    protected Page page;

    public Page getPage() {
        return page;
    }

    @BeforeClass
    public void browserLaunch() {
       playwright = Playwright.create();
       BrowserType.LaunchOptions options = new BrowserType.LaunchOptions()
       .setHeadless(false)
       .setSlowMo(1000);
       browser = playwright.chromium().launch(options);
       
    }

    @BeforeMethod
    public void setupTest() {
        context = browser.newContext();
        page =  context.newPage();
        page.navigate("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void close(){
        if (page != null) page.close();
        if (context != null) context.close();
    }
}

