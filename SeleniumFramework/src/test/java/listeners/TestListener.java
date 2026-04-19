package listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.BaseTest;
import utils.ExtentReportManager;
import utils.ScreenshotUtils;

public class TestListener implements ITestListener {
	
	    private static final Logger logger = LogManager.getLogger(TestListener.class);
	    ExtentReports extent = ExtentReportManager.getInstance();
	    ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	    
	    @Override
	    public void onTestStart(ITestResult result) {
	        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
	        test.set(extentTest);
	    }
	    
	    @Override
	    public void onTestFailure(ITestResult result) {
	    	test.get().fail(result.getThrowable());
	        logger.error("Test Failed: " + result.getName());
	        ScreenshotUtils.captureScreenshot(BaseTest.driver, result.getName() + "_FAILED");
	    }
	    
	    @Override
	    public void onTestSuccess(ITestResult result) {
	    	test.get().pass("Test Passed");
	        logger.info("Test Passed: " + result.getName());
	    }
	    
	    @Override
	    public void onTestSkipped(ITestResult result) {
			test.get().skip("Test Skipped");
	        logger.warn("Test Skipped: " + result.getName());
	    }
	    
	    @Override
	    public void onFinish(org.testng.ITestContext context) {
	        extent.flush();
	    }
	

}
