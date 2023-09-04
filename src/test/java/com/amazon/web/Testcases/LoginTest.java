package com.amazon.web.Testcases;

import com.amazon.web.base.Amazonbase;
import com.amazon.web.pages.LoginPage;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends Amazonbase {

    private LoginPage loginPage;

    public LoginTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException, InterruptedException {
        initialization();
        loginPage = new LoginPage();
    }

    @Test
    public void loginPageTest() throws InterruptedException {

        loginPage.clickSignInButton();
        Thread.sleep(3000);
        loginPage.validateSignPageTitle();
        loginPage.validateEmailMobileNoPassword(props.getProperty("emailMob"), props.getProperty("password"));

        boolean logo = loginPage.validateAmazonLogo();
        Assert.assertTrue(logo);
    }

    @AfterMethod
    public void quit() {
        driver.quit();
    }

}
