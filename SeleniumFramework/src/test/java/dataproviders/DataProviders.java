package dataproviders;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name = "loginData")
	public Object[][] getLoginData() {
		return new Object[][] {
			{"Admin", "admin123", "valid"}
				
		};
		
	}
	

}
