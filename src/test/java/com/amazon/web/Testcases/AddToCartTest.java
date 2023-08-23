package com.amazon.web.Testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.web.base.Amazonbase;
import com.amazon.web.pages.AddToCart;
import com.amazon.web.pages.SearchItem;

public class AddToCartTest extends Amazonbase {

    SearchItem search_item;
    AddToCart  add_To_cart;

    public AddToCartTest()
    {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException
    {
      intialization();
      search_item = new SearchItem();
      add_To_cart=search_item.SearchSamsungMobile(props.getProperty("SearchMobile"));
    }

    @Test()
    public void click_Mobile()
    { 
        add_To_cart.clickMobile();
        add_To_cart.validateMobilePageTitle();
        add_To_cart.addItemTocart();
        add_To_cart.clickTocart();
    }

    @AfterMethod
    public void quitScreen()
    {
      //  driver.quit();
    }


    
}
