package com.amazon.web.pages;

import com.amazon.web.base.Amazonbase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCart extends Amazonbase {

    // Page Factory - OR:
    @FindBy(xpath = "//img[@class='s-image']")
    private WebElement firstMobile;

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    private WebElement clickAddToCart;

    // initialize the page objects:
    public AddToCart() {
        PageFactory.initElements(driver, this);
    }

    // Actions
    public void clickMobile() {

        firstMobile.click();
        String parentHandle = driver.getWindowHandle();
        for (String childHandle : driver.getWindowHandles()) {
            if (!parentHandle.equals(childHandle)) {

                driver.switchTo().window(childHandle);

            }
        }
    }

    public void addItemTocart() {

        clickAddToCart.click();
    }
}