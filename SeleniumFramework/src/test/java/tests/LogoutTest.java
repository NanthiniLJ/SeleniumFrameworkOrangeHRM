package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import dataproviders.DataProviders;
import pages.LoginPage;
import pages.LogoutPage;
import utils.ScreenshotUtils;

public class LogoutTest extends BaseTest {
	
	@Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
	public void logoutTest(String username, String password, String type) throws InterruptedException {
		LoginPage loginpage = new LoginPage(getDriver());
		LogoutPage logoutPage = new LogoutPage(getDriver());
		
		loginpage.loginAs(username, password);
		
		logoutPage.logOut();
		ScreenshotUtils.captureScreenshot(driver, "backtologinpage");
		
	}
	

}
