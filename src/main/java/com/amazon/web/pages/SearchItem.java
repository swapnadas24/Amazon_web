package com.amazon.web.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.web.base.Amazonbase;
import com.amazon.web.util.TestUtil;

public class SearchItem extends Amazonbase{

    //Page Factory -OR:
    @FindBy(id = "twotabsearchtextbox")
    WebElement search_Bar;
    
    @FindBy(id="nav-flyout-searchAjax")
    WebElement Searchlist_size;

    @FindBy(xpath="//div[@aria-label='samsung mobile']")
    List<WebElement> Samsung_mobile;
    
    @FindBy(id="nav-logo-sprites")
    WebElement AmazonLogo;

    //initialize the page objects:
    public SearchItem()
    {
        PageFactory.initElements(driver,this);
    }

    //Actions
    public String validateHomePageTitle()
    {
      return driver.getTitle();
    }

    public boolean validateAmazonLogo()
    {
        return AmazonLogo.isDisplayed();
    }

    public AddToCart SearchSamsungMobile(String SearchMob)
    {

        search_Bar.sendKeys(SearchMob);
        Searchlist_size.isSelected();
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);

        // select First name from the list
		List<WebElement> mobile = Samsung_mobile;
		for (int i = 0; i <= mobile.size();) {
			mobile.get(i).click();
			break;
		}
      return new AddToCart();

    }
}