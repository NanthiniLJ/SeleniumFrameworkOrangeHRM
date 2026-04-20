package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

	WebDriver driver;
	WebDriverWait wait;
	
	By dashboardText = By.xpath("//h6[text()='Dashboard']");
	By pimMenu = By.xpath("//span[text()='PIM']");
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	public boolean isDashboardVisible() {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(
				By.cssSelector(".oxd-form-loader")
			));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardText)).isDisplayed();
		
	}
	
	public void goToPIM() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(pimMenu)).click();
		//driver.findElement(pimMenu).click();
		Thread.sleep(3000);
	}
	
	
}
