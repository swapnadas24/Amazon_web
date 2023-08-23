package com.amazon.web.Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.web.base.Amazonbase;
import com.amazon.web.pages.LoginPage;

public class LoginTest extends Amazonbase {

    LoginPage login_Page;
   
    public LoginTest()
    {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException
    {
        intialization();
        login_Page= new LoginPage();
    }
    @Test
    public void login_Page_Test()
    {
      login_Page.click_SignIn_Button();
      login_Page.validateSignPageTitle();
      login_Page.validate_Email_MobileNo_Password(props.getProperty("email_Mob"),
                                 props.getProperty("password"));
      

      boolean logo=login_Page.validateAmazonLogo();
      Assert.assertTrue(logo);
    }

    @AfterMethod
    public void quit()
    {
      driver.quit();
    }

    
}
