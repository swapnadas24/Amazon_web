package com.amazon.web.pages;

import com.amazon.web.base.Amazonbase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCart extends Amazonbase {

    // Page Factory - OR:
    @FindBy(xpath = "//img[@class='s-image']")
    WebElement firstMobile;

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    WebElement clickAddToCart;

    // initialize the page objects:
    public AddToCart() {
        PageFactory.initElements(driver, this);
    }

    // Actions
    public void clickMobile() throws InterruptedException {
        Thread.sleep(2000);
        firstMobile.click();
        Thread.sleep(2000);
        String parentHandle = driver.getWindowHandle();
        for (String childHandle : driver.getWindowHandles()) {
            if (!parentHandle.equals(childHandle)) {
                driver.switchTo().window(childHandle);
            }
        }
    }

    public void addItemTocart() throws InterruptedException {

        clickAddToCart.click();
        Thread.sleep(5000);

    }
}