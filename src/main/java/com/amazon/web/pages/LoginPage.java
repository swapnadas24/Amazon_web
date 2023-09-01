package com.amazon.web.pages;

import com.amazon.web.base.Amazonbase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Amazonbase {

    // Page Factory -OR:
    @FindBy(id = "nav-link-accountList")
      private WebElement clickSignIn;

    @FindBy(id = "ap_email")
      private WebElement enteremailmobileNo;

    @FindBy(id = "continue")
      private WebElement tabContinue;

    @FindBy(id = "ap_password")
      private WebElement enterPassword;

    @FindBy(id = "signInSubmit")
      private WebElement tapSigninButton;

    @FindBy(id = "nav-logo-sprites")
      private WebElement amazonLogo;

    // initialize the page objects
    public LoginPage() {

        PageFactory.initElements(driver, this);

    }

    public void clickSignInButton() {

        clickSignIn.click();

    }

    public String validateSignPageTitle() {

       return driver.getTitle();

    }

    public void validateEmailMobileNoPassword(String eIdMob, String pwd) throws InterruptedException {

        enteremailmobileNo.sendKeys(eIdMob);
        tabContinue.click();
        enterPassword.sendKeys(pwd);
        tapSigninButton.click();

    }

   // Actions
    public String validateHomePageTitle() {

        return driver.getTitle();

    }

    public boolean validateAmazonLogo() {

        return amazonLogo.isDisplayed();

    }

}
