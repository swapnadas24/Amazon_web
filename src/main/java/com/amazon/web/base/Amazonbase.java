package com.amazon.web.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import com.amazon.web.util.TestUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazonbase {

    public static WebDriver driver;
    private static ChromeOptions option;
    private static SafariOptions option1;
    protected static Properties props;
    static FileInputStream objfile;

    public Amazonbase() {

        try {
            // Load the properties File
            props = new Properties();
            FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")
            +  "/src/main/java/com/amazon/web/config/config.properties");
            props.load(objfile);

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    public static void initialization() throws IOException, InterruptedException {

        String browserName = props.getProperty("browser");

        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            option = new ChromeOptions();
            // To stop unwanted pop-up of chrome browser
            option.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
            option.setExperimentalOption("useAutomationExtension", false);
            driver = new ChromeDriver(option);

        } else if(browserName.equals("safari")) {

            WebDriverManager.safaridriver().setup();
            option1 = new SafariOptions();
            driver = new SafariDriver(option1);

        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.durationSeconds));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(TestUtil.durationMilliSeconds));

        driver.get(props.getProperty("homeURL"));

    }
}

