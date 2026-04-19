package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import dataproviders.DataProviders;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ScreenshotUtils;

public class DashboardTest extends BaseTest {
	

	@Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
	
	public void dashboardTest(String username, String password) {
		LoginPage loginpage = new LoginPage(driver);
		DashboardPage dashboardPage = new DashboardPage(getDriver());
		
		loginpage.loginAs(username, password);
		Assert.assertTrue(dashboardPage.isDashboardVisible());
		ScreenshotUtils.captureScreenshot(driver, "Dashboard_Visible");
		
	}
	
	

}
