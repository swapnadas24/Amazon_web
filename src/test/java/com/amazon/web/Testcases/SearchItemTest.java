package com.amazon.web.Testcases;

import com.amazon.web.base.Amazonbase;
import com.amazon.web.pages.SearchItem;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchItemTest extends Amazonbase {

    private SearchItem searchItem;

    public SearchItemTest() {

        super();

    }

    @BeforeMethod
    public void setUp() {

        initialization();
        searchItem = new SearchItem();

    }

    @Test(priority = 1)
    public void pageTitleTest() {

        String homePageTitle = searchItem.validateHomePageTitle();
        Assert.assertEquals(homePageTitle,
                "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
    }

    @Test(priority = 2)
    public void pageLogoTest() {

        boolean flag = searchItem.validateAmazonLogo();
        Assert.assertTrue(flag);
    }

    @Test(priority = 3)
    public void searchedItemTest() {

        searchItem.searchSamsungMobile(props.getProperty("SearchMobile"));

    }

    @AfterMethod
    public void quitScreen() {

        driver.quit();

    }
}