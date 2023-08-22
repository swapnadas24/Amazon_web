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
import org.openqa.selenium.firefox.FirefoxDriver;

import com.amazon.web.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazonbase {
    public static WebDriver driver;
    public static ChromeOptions option;
    public static Properties props;
    public static FileInputStream objfile;

    public Amazonbase() 
    {

        try {
            // Load the properties File
            props = new Properties();
            FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+
                                 "/src/main/java/com/interview/config/config.properties");
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

        }else if(browserName.equals("FF"))
        {
         WebDriverManager.safaridriver().setup();
         driver=new FirefoxDriver();
        }
       
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
       
       driver.get(props.getProperty("home_URL"));
    }
    
}
