package com.amazon.web.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazonbase {
    static WebDriver driver;
    static ChromeOptions option;
    static Properties props;
    static FileInputStream objfile;

    public static void intialization() throws IOException {
       
        WebDriverManager.chromedriver().setup();
		option = new ChromeOptions();
		
        // To stop unwanted pop-up of chrome browser
        option.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        option.setExperimentalOption("useAutomationExtension", false);
        option.addArguments("--start-maximized");
        driver = new ChromeDriver(option);
		
		// locators file
        props = new Properties();
        objfile=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/interview/config/config.properties");
        props.load(objfile);
        
        driver.get(props.getProperty("home_URL"));

    }
    
}
