package com.amazon.web.Testcases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.web.base.Amazonbase;
import com.amazon.web.pages.AddToCart;
import com.amazon.web.pages.SearchItem;

public class SearchItemTest extends Amazonbase{
   
    SearchItem search_item;
    AddToCart  add_To_cart;
 
    public SearchItemTest()
    {
       super();
    }
    
    @BeforeMethod
    public void setUp() throws IOException
    {
      intialization();
      search_item = new SearchItem();
    }
    
    @Test(priority = 1)
    public void pageTitleTest()
    {
       String home_page_title = search_item.validateHomePageTitle();
       Assert.assertEquals(home_page_title,"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
    }

    @Test(priority=2)
    public void pageLogoTest()
    {
     boolean flag= search_item.validateAmazonLogo();
     Assert.assertTrue(flag);
    }

    @Test(priority = 3)
    public void searchedItemTest()
    {
      
      add_To_cart= search_item.SearchSamsungMobile(props.getProperty("SearchMobile"));
      
    }

    @AfterMethod
    public void quitScreen()
    {
      driver.quit();
    }    

}