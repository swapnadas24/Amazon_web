package com.amazon.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.web.base.Amazonbase;

public class AddToCart extends Amazonbase {

    //Page Factory - OR:
    @FindBy(xpath = "//img[@data-image-index='1']")
    WebElement first_Mobile;  

    @FindBy(id="add-to-cart-button")
    WebElement click_addToCart;
    
    @FindBy(id="attach-sidesheet-view-cart-button-announce")
    WebElement click_Cart;
    
    //initialize the page objects:
    public AddToCart()
    {
    PageFactory.initElements(driver,this);
    }

    //Actions
    public void clickMobile()
    {
        first_Mobile.click();

        String parentHandle=driver.getWindowHandle();
        for(String childHandle: driver.getWindowHandles())
        {
            if(!parentHandle.equals(childHandle))
            {
            driver.switchTo().window(childHandle);
            }
        }
    }

    public String validateMobilePageTitle()
    {
       return driver.getTitle();
    }

    public void addItemTocart()
    {
        click_addToCart.click();
        
    }
    public void clickTocart()
    {
        click_Cart.click();
    }

    

}