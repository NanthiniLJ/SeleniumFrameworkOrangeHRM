package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage {
	
	
	WebDriver driver;
	WebDriverWait wait;
	
	private By logoutMenu = By.xpath("//span[@class='oxd-userdropdown-tab']");
	private By logoutbtn =  By.xpath("//a[text()='Logout']");
	
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	public void logOut() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(logoutMenu)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(logoutbtn)).click();
		Thread.sleep(2000);
	}

}
