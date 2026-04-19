package pages;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

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
	
	
	
	public PIMPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		this.js = ((JavascriptExecutor) driver);
	}
	
	public void addEmployee(String firstname, String lastname) {
		//wait.until(ExpectedConditions.visibilityOfElementLocated(pimPage)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(addBtn)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(fName)).sendKeys(firstname);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lName)).sendKeys(lastname);
		
		driver.findElement(saveButton).click();;
		//save.get(1).click();
		System.out.println("added Employee");
	}
	
	public void searchEmployee(String name) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(employeeName)).sendKeys(name);
		driver.findElement(searchBtn).click();
		
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(3000);
		
		
	}
	

}
