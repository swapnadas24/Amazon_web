package com.amazon.web.Testcases;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.web.base.Amazonbase;
import com.amazon.web.pages.SearchItem;

public class SearchItemTest extends Amazonbase{
   
    SearchItem search_item;

    public SearchItemTest()
    {
    //    super();
    }
    
    @BeforeMethod
    public void setUp() throws IOException
    {
        intialization();
        search_item = new SearchItem();
    }

    @Test
    public void searchedItemTest()
    {
      search_item.SearchSamsungMobile(props.getProperty("SearchMobile"));
    }

    @AfterMethod
    public void quitScreen(){
      // driver.quit();
    }    

}