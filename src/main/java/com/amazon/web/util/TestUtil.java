package com.amazon.web.util;

import com.amazon.web.base.Amazonbase;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

// Get TestUtil class.
public class TestUtil extends Amazonbase {

    public static long durationSeconds = 10;
    public static long durationMilliSeconds = 5000;

    public static void takeScreenshotAtEndOfTest() throws IOException {

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));

    }

}
