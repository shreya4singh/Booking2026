package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	

	By destination = By.xpath("//input[@ name='ss']");
	By searchButton = By.xpath("//button[@type='submit']");
	By dateField = By.xpath("//button[contains(@data-testid,'searchbox-dates-container')]");
	By fiveStarFilter = By.xpath("//*[contains(text(),'5 stars')]");
	
	public WebElement getDestination() {
		System.out.println("Finding destination field");
		
		return driver.findElement(destination);
	}
	
	public WebElement getSearchButton() {
		return driver.findElement(searchButton);
	}
    public WebElement getDateField() {
    	return driver.findElement(dateField);
    }
    public WebElement getFiveStarFilter() {
    	return driver.findElement(fiveStarFilter);
    }
    
    

}
