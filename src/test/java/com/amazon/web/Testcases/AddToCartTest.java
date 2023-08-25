package com.amazon.web.testcases;

import com.amazon.web.pages.AddToCart;
import com.amazon.web.base.Amazonbase;
import com.amazon.web.pages.LoginPage;
import com.amazon.web.pages.SearchItem;
import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddToCartTest extends Amazonbase {
    LoginPage loginPage;
    SearchItem searchItem;
    AddToCart addToCart;

    public AddToCartTest() {

        super();

    }

    @BeforeTest
    public void setUp() throws IOException {

        intialization();

    }

    @BeforeMethod
    public void call_screens() {

        loginPage = new LoginPage();
        loginPage.click_SignIn_Button();
        loginPage.validate_Email_MobileNo_Password(props.getProperty("emailMob"), props.getProperty("password"));

        searchItem = new SearchItem();
        addToCart = searchItem.SearchSamsungMobile(props.getProperty("SearchMobile"));

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
