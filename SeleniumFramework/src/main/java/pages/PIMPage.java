package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PIMPage {
	
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	private By addBtn = By.xpath("//button[text()=' Add ']");
	private By fName = By.name("firstName");
	private By lName = By.name("lastName");
	private By saveButton = By.xpath("//button[@type='submit']");
	private By employeeName = By.xpath("//input[@placeholder='Type for hints...']");
	private By searchBtn = By.xpath("//button[@type='submit']");
	private By employeeRows = By.xpath("//div[@role='row']");
	
	
	
	public PIMPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		this.js = ((JavascriptExecutor) driver);
	}
	
	public void addEmployee(String firstname, String lastname) throws InterruptedException {
		//wait.until(ExpectedConditions.visibilityOfElementLocated(pimPage)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(addBtn)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(fName)).sendKeys(firstname);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lName)).sendKeys(lastname);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(
			    By.cssSelector("div[class*='oxd-form-loader']")
			));
		wait.until(ExpectedConditions.visibilityOfElementLocated(saveButton)).click();
		//driver.findElement(saveButton).click();
		Thread.sleep(10000);
		//save.get(1).click();
		System.out.println("added Employee");
	}
	
	public void searchEmployee(String name) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(employeeName)).sendKeys(name);
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchBtn)).click();		
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(3000);	
	}
	
	public boolean isEmployeeFound(String employeeName) {
		List<WebElement> rows = driver.findElements(employeeRows);

	    for (WebElement row : rows) {
	        if (row.getText().contains(employeeName)) {
	            return true;
	        }
	    }
	    return false;
	}
	

}
