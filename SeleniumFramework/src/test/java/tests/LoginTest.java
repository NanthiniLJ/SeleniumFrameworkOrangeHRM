package tests;

import org.testng.Assert;




import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import base.BaseTest;
import dataproviders.DataProviders;
import pages.LoginPage;
import utils.ScreenshotUtils;

public class LoginTest extends BaseTest {

	
	
	@Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
	public void loginTest(String username, String password, String type) {
		
		ExtentTest test = extent.createTest("Login Test - " + type);
		
		LoginPage loginpage = new LoginPage(getDriver());
		
		test.info("Entering username: " + username);
        test.info("Entering password");
        
		loginpage.loginAs(username, password);

		if(type.equals("valid")) {
			test.info("Validating successful login");
			Assert.assertTrue(loginpage.isLoginSuccess());
			
			test.pass("Login successful with valid credentials");
		}else {
			test.info("Validating error message for invalid login");
			String errorMessage = loginpage.invalidLoginError();
			ScreenshotUtils.captureScreenshot(driver, type);
			System.out.println(errorMessage);
			Assert.assertEquals(errorMessage, "Invalid credentials");
			test.pass("Proper error message displayed for invalid login");
			}
		
	}
	
}
