package com.amazon.web.Testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amazon.web.base.Amazonbase;
import com.amazon.web.pages.AddToCart;
import com.amazon.web.pages.LoginPage;
import com.amazon.web.pages.SearchItem;


public class AddToCartTest extends Amazonbase {

    LoginPage login_Page;
    SearchItem search_item;
    AddToCart  add_To_cart;

    public AddToCartTest()
    {
        super();
    }

    @BeforeTest
    public void setUp() throws IOException
    {
      intialization();
    }

    @BeforeMethod
    public void call_screens() 
    {
      
      login_Page=new LoginPage();
      login_Page.click_SignIn_Button();
      login_Page.validate_Email_MobileNo_Password(props.getProperty("email_Mob"),
                                 props.getProperty("password"));

      search_item = new SearchItem();
      add_To_cart=search_item.SearchSamsungMobile(props.getProperty("SearchMobile"));
    }

    @Test()
    public void click_Mobile() throws InterruptedException
    { 
        add_To_cart.clickMobile();
        add_To_cart.addItemTocart();     
    }

    @AfterMethod
    public void quitScreen()
    {
        driver.quit();
    }


    
}
