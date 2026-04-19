package tests;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

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
		logger.info("========== PIM Test Started ==========");
		
		LoginPage loginpage = new LoginPage(getDriver());
		DashboardPage dashboardPage = new DashboardPage(getDriver());
		PIMPage pimPage = new PIMPage(getDriver());
		
		logger.info("Step 1: Logging in");
		loginpage.loginAs(username, password);
		

		logger.info("Step 2: Verifying Dashboard");
		Assert.assertTrue(dashboardPage.isDashboardVisible(), "Dashboard not visible");
		ScreenshotUtils.captureScreenshot(driver, "Dashboard_Visible");
		
		logger.info("Step 3: Navigate to PIM");
		dashboardPage.goToPIM();
		ScreenshotUtils.captureScreenshot(driver, "PIM_Page");
		
		logger.info("Step 4: Adding Employee");
		pimPage.addEmployee("test6", "six");
		
		
		logger.info("Step 5: Searching Employee");
		dashboardPage.goToPIM();
		pimPage.searchEmployee("test6");
		ScreenshotUtils.captureScreenshot(driver, "Employee_Search_Result");
		
		logger.info("========== PIM Test Completed ==========");
		
	}

}
