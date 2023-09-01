package com.amazon.web.testcases;

import com.amazon.web.base.Amazonbase;
import com.amazon.web.pages.AddToCart;
import com.amazon.web.pages.LoginPage;
import com.amazon.web.pages.SearchItem;
import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddToCartTest extends Amazonbase {
    private LoginPage loginPage;
    private SearchItem searchItem;
    private AddToCart addToCart;

    public AddToCartTest() {

        super();

    }

    @BeforeTest
    public void setUp() throws IOException, InterruptedException {

        initialization();

    }

    @BeforeMethod
    public void call_screens() throws InterruptedException {

        loginPage = new LoginPage();
        loginPage.clickSignInButton();

        loginPage.validateEmailMobileNoPassword(props.getProperty("email_Mob"), props.getProperty("password"));

        searchItem = new SearchItem();
        addToCart = searchItem.searchSamsungMobile(props.getProperty("SearchMobile"));
    }

    @Test()
    public void click_Mobile() throws InterruptedException {

        addToCart.clickMobile();
        addToCart.addItemTocart();
    }

    @AfterMethod
    public void quitScreen() {

        driver.quit();
    }

}
