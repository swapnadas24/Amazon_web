package com.amazon.web.pages;


import com.amazon.web.base.Amazonbase;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchItem extends Amazonbase {

    // Page Factory -OR:
    @FindBy(id = "twotabsearchtextbox")
    WebElement searchBar;

    @FindBy(id = "nav-flyout-searchAjax")
    WebElement SearchlistSize;

    @FindBy(xpath = "//div[@aria-label='samsung mobile']")
    List<WebElement> SamsungMobile;

    @FindBy(id = "nav-logo-sprites")
    WebElement AmazonLogo;

    // initialize the page objects:
    public SearchItem() {
        PageFactory.initElements(driver, this);
    }

    // Actions
    public String validateHomePageTitle() {
        return driver.getTitle();
    }

    public boolean validateAmazonLogo() {
        return AmazonLogo.isDisplayed();
    }

    public AddToCart SearchSamsungMobile(String SearchMob) throws InterruptedException {

        searchBar.sendKeys(SearchMob);
        SearchlistSize.isSelected();
        Thread.sleep(5000);

        // select First name from the list
        List<WebElement> mobile = SamsungMobile;
        for (int i = 0; i <= mobile.size();) {
            mobile.get(i).click();
            break;
        }
        return new AddToCart();

    }
}
