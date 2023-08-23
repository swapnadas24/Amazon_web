package com.amazon.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.web.base.Amazonbase;

public class AddToCart extends Amazonbase {

    //Page Factory - OR:
    @FindBy(xpath = "//img[@class='s-image']")
    WebElement first_Mobile;  

    @FindBy(xpath="//input[@id='add-to-cart-button']")
    WebElement click_addToCart;
    
    @FindBy(id="attach-view-cart-button-form") 
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

    public void addItemTocart() throws InterruptedException
    {

        click_addToCart.click();
        Thread.sleep(2000);
        click_Cart.click();  
        Thread.sleep(3000);    
    }
}