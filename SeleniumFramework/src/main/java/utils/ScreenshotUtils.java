package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {
	
	private static final Logger logger = LogManager.getLogger(ScreenshotUtils.class);
	
	public static String captureScreenshot(WebDriver driver, String fileName) {
		String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
		String screenshotName = fileName + "_" + timestamp + ".png";
        String screenshotPath = "./screenshots/" + screenshotName;
        
        try {
            // Create screenshots folder if it doesn't exist
            File screenshotFolder = new File("./screenshots/");
            if (!screenshotFolder.exists()) {
                screenshotFolder.mkdir();
                logger.info("Screenshots folder created");
            }
            
            // Take screenshot
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            File dest = new File(screenshotPath);
            FileUtils.copyFile(src, dest);
            
            logger.info("Screenshot captured: " + screenshotPath);
            return screenshotPath;
        } catch (IOException e) {
            logger.error("Failed to capture screenshot", e);
            return null;
        }
		

		
	}

}
