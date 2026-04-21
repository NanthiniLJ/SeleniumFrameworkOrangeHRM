package tests;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import base.BaseTest;
import dataproviders.DataProviders;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PIMPage;
import utils.ScreenshotUtils;

public class PIMTest extends BaseTest{
	
    private static final Logger logger = LogManager.getLogger(PIMTest.class);
	
	@Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
	public void pimTest(String username, String password, String type) throws InterruptedException {
		
		ExtentTest test = extent.createTest("PIM Test - " + type);
		
		logger.info("========== PIM Test Started ==========");
		
		LoginPage loginpage = new LoginPage(getDriver());
		DashboardPage dashboardPage = new DashboardPage(getDriver());
		PIMPage pimPage = new PIMPage(getDriver());
		
		test.info("Step 1: Logging in");
		loginpage.loginAs(username, password);
		
		if (type.equalsIgnoreCase("valid")) {	
			test.info("Step 2: Verifying Dashboard");
			Assert.assertTrue(dashboardPage.isDashboardVisible(), "Dashboard not visible");
			
			ScreenshotUtils.captureScreenshot(driver, "Dashboard_Visible");
			
			test.info("Step 3: Navigate to PIM");
			dashboardPage.goToPIM();			
			ScreenshotUtils.captureScreenshot(driver, "PIM_Page");
			
			test.info("Step 4: Adding Employee");
			pimPage.addEmployee("test6", "six");

			test.info("Step 5: Searching Employee");
			dashboardPage.goToPIM();
			pimPage.searchEmployee("test6");
			ScreenshotUtils.captureScreenshot(driver, "Employee_Search_Result");
			
			test.info("Step 6: Validating Employee Presence");
	        Assert.assertTrue(pimPage.isEmployeeFound("test6"));
	
	        test.pass("Employee added and verified successfully");
		} else {
			test.info("Invalid login - skipping PIM validation");
            Assert.assertFalse(dashboardPage.isDashboardVisible());
            test.pass("PIM test skipped due to invalid login");

		}
		
		logger.info("========== PIM Test Completed ==========");
		
	}

}
