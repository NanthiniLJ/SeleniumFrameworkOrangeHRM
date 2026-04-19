package tests;

import org.testng.Assert;

//import static org.testng.Assert.assertEquals;


import org.testng.annotations.Test;

import base.BaseTest;
import dataproviders.DataProviders;
import pages.LoginPage;
import utils.ScreenshotUtils;

public class LoginTest extends BaseTest {

	
	
	@Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
	public void loginTest(String username, String password, String type) {
		
		LoginPage loginpage = new LoginPage(getDriver());
		loginpage.loginAs(username, password);

		if(type.equals("valid")) {
			Assert.assertTrue(loginpage.isLoginSuccess());
			System.out.println("valid login");
		}else {
			String errorMessage = loginpage.invalidLoginError();
			ScreenshotUtils.captureScreenshot(driver, type);
			System.out.println(errorMessage);
			Assert.assertEquals(errorMessage, "Invalid credentials", "Expected invalid credential error message");
			System.out.println("invalid login");
			}
		
	}
	
}
