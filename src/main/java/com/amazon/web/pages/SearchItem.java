package com.amazon.web.pages;

import com.amazon.web.base.Amazonbase;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchItem extends Amazonbase {

    // Page Factory -OR:
    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBar;

    @FindBy(id = "nav-flyout-searchAjax")
    private WebElement searchListSize;

    @FindBy(xpath = "//div[@aria-label='samsung mobile']")
    private List<WebElement> samsungMobile;

    @FindBy(id = "nav-logo-sprites")
    private WebElement amazonLogo;

    // initialize the page objects:
    public SearchItem() {
        PageFactory.initElements(driver, this);
    }

    // Actions
    public String validateHomePageTitle() {
        return driver.getTitle();
    }

    public boolean validateAmazonLogo() {
        return amazonLogo.isDisplayed();
    }

    public AddToCart searchSamsungMobile(String searchMob) {

        searchBar.sendKeys(searchMob);
        searchListSize.isSelected();

        // select First name from the list
        List<WebElement> mobile = samsungMobile;
        for (int i = 0; i <= mobile.size();) {
            mobile.get(i).click();
            break;
        }
        return new AddToCart();

    }
}
