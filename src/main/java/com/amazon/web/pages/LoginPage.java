package com.amazon.web.pages;

import com.amazon.web.base.Amazonbase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Amazonbase {

      // Page Factory -OR:

      @FindBy(id = "nav-link-accountList")
      WebElement click_SignIn;

      @FindBy(id = "ap_email")
      WebElement enter_email_mobileNo;

      @FindBy(id = "continue")
      WebElement tab_continue;

      @FindBy(id = "ap_password")
      WebElement enter_password;

      @FindBy(id = "signInSubmit")
      WebElement tap_Signin_button;

      @FindBy(id = "nav-logo-sprites")
      WebElement AmazonLogo;

      // initialize the page objects
      public LoginPage() {

          PageFactory.initElements(driver, this);

      }

   public void click_SignIn_Button() throws InterruptedException {
     
        click_SignIn.click();
        Thread.sleep(5000);

   }

   public String validateSignPageTitle() {
     
      return driver.getTitle();

   }

   public void validate_Email_MobileNo_Password(String e_Id_mob, String pwd) throws InterruptedException {

      enter_email_mobileNo.sendKeys(e_Id_mob);
      tab_continue.click();
      Thread.sleep(3000);
      enter_password.sendKeys(pwd);
      tap_Signin_button.click();
      Thread.sleep(3000);

   }

   // Actions
   public String validateHomePageTitle() {
      return driver.getTitle();
   }

   public boolean validateAmazonLogo() {
      return AmazonLogo.isDisplayed();
   }

}
