package base;

import java.util.Properties;

import config.ConfigReader;
import factory.DriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExtentManager;

//import config.ConfigReader;

public class BaseTest {
	
	protected static ExtentReports extent;
	
	private static final Logger logger = LogManager.getLogger(BaseTest.class);
	protected Properties prop;
	protected ConfigReader configReader;
	public static WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
		
		extent = ExtentManager.getInstance();
		
		logger.info("========== Starting Test Setup ==========");

		String browserName = prop.getProperty("browser");
		String url = prop.getProperty("url");
		
		
		if(browserName.equalsIgnoreCase("chrome")) {	
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}
		else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else {
			throw new IllegalArgumentException("Unsupported browser: " +browserName);
		}
		
		DriverManager.setDriver(driver);
		getDriver().manage().window().maximize();
		getDriver().get(url);
		logger.info("Navigated to URL: " + url);
	}
	
	protected WebDriver getDriver() {
		return DriverManager.getDriver();
		
	}
	
	@AfterSuite
	public void tearDown() {
		if(getDriver() != null)
		{
			getDriver().quit();
			DriverManager.unload();
			logger.info("Browser closed successfully.");
		}
		if (extent != null) {
	        extent.flush();
	    }
		logger.info("========== Test Setup Completed ==========");
	}

}
