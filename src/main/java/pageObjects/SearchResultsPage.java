package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage {
	WebDriver driver;
	
	public SearchResultsPage(WebDriver driver){
		this.driver = driver;
	}
	
	By hotelList = By.xpath("//div[@data-testid='property-card']");
	By fiveStarHotels = By.xpath("//div[contains(text(),'5 stars')]");
	
	public List<WebElement> getHotelList(){
		return driver.findElements(hotelList);
	}

	public List<WebElement> getFiveStarHotels(){
		return driver.findElements(fiveStarHotels);
	}
}
