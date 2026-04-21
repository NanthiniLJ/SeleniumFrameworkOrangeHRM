package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import base.BaseTest;
import dataproviders.DataProviders;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ScreenshotUtils;

public class DashboardTest extends BaseTest {
	

	@Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
	
	public void dashboardTest(String username, String password, String type) {
		
		ExtentTest test = extent.createTest("Dashboard Test - " + type);
		
		LoginPage loginpage = new LoginPage(getDriver());
		DashboardPage dashboardPage = new DashboardPage(getDriver());
		
		test.info("Logging in with username: " + username);
		loginpage.loginAs(username, password);
		
		if(type.equalsIgnoreCase("valid")) {	
			test.info("Validating dashboard visibility");
			Assert.assertTrue(dashboardPage.isDashboardVisible());
			ScreenshotUtils.captureScreenshot(driver, "Dashboard_Visible");
			test.pass("Dashboard displayed successfully");
		}
		else {
			 test.info("Invalid login - dashboard should not be visible");
	         Assert.assertFalse(dashboardPage.isDashboardVisible());
	         test.pass("Dashboard not visible for invalid login (Expected)");
		}
		
	}
	
	

}
