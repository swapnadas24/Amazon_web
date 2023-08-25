package com.amazon.web.testcases;

import com.amazon.web.base.Amazonbase;
import com.amazon.web.pages.LoginPage;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends Amazonbase {

    LoginPage loginPage;
    
    public LoginTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException {
        intialization();
        loginPage = new LoginPage();
    }

    @Test
    public void login_Page_Test() {
        loginPage.click_SignIn_Button();
        loginPage.validateSignPageTitle();
        loginPage.validate_Email_MobileNo_Password(props.getProperty("email_Mob"), props.getProperty("password"));

        boolean logo = loginPage.validateAmazonLogo();
        Assert.assertTrue(logo);
    }

    @AfterMethod
    public void quit() {
        driver.quit();
    }

}
