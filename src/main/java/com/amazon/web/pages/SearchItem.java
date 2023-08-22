package com.amazon.web.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.web.base.Amazonbase;

public class SearchItem extends Amazonbase{

    
    @FindBy(id = "twotabsearchtextbox")
    WebElement search_Bar;
    
    @FindBy(id="nav-flyout-searchAjax")
    WebElement Searchlist_size;

    @FindBy(xpath="//div[@aria-label='samsung mobile']")
    List<WebElement> Samsung_mobile;


    public SearchItem()
    {
        PageFactory.initElements(driver,this);
    }

    public AddToCart SearchSamsungMobile(String SearchMob)
    {

        search_Bar.sendKeys(SearchMob);
        Searchlist_size.isSelected();

        // select First name from the list
		List<WebElement> mobile = Samsung_mobile;
		for (int i = 0; i <= mobile.size();) {
			mobile.get(i).click();
			break;
		}
      return new AddToCart();

    }
}
