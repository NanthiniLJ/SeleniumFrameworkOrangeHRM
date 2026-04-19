package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

	WebDriver driver;
	WebDriverWait wait;
	
	By dashboardText = By.cssSelector("h6");
	By pimMenu = By.xpath("//span[text()='PIM']");
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	public boolean isDashboardVisible() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardText)).isDisplayed();
		
	}
	
	public void goToPIM() throws InterruptedException {
		driver.findElement(pimMenu).click();
		Thread.sleep(3000);
	}
	
	
}
