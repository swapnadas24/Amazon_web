package com.amazon.web.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.amazon.web.util.TestUtil;
import com.amazon.web.util.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazonbase {
    public static WebDriver driver;
    public static ChromeOptions option;
    public static Properties props;
    public static FileInputStream objfile;

    public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

    public Amazonbase() 
    {

        try {
            // Load the properties File
            props = new Properties();
            FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+
                                 "/src/main/java/com/amazon/web/config/config.properties");
            props.load(objfile);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
 
    public static void intialization() throws IOException {

        String browserName= props.getProperty("browser");

        if(browserName.equals("chrome"))
        {
        WebDriverManager.chromedriver().setup();
		option = new ChromeOptions();
        // To stop unwanted pop-up of chrome browser
        option.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        option.setExperimentalOption("useAutomationExtension", false);
        driver = new ChromeDriver(option);

        }
         
        e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;


        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
       
       driver.get(props.getProperty("home_URL"));
    }
    
}

