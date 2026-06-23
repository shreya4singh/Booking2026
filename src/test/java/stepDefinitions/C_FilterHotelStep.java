package stepDefinitions;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import base.Base;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.SearchResultsPage;

public class C_FilterHotelStep extends Base{
	HomePage homePage;
	private static final Logger logger = LogManager.getLogger(A_SearchHotelStep.class);
	
	@When("user applies 5 star filter")
	public void user_applies_5_star_filter() throws Exception{
		try {
		//homePage = new HomePage(getDriver());
		//Thread.sleep(2000);
		logger.info("Applying 5 star filter");
//		homePage = new HomePage(getDriver());
//		//waitForElement(homePage.getFiveStarFilter());
//		//homePage.getFiveStarFilter().click();
//		waitForElement(homePage.getFiveStarFilter());
//		homePage.getFiveStarFilter().click();
		Thread.sleep(3000);
		getDriver().findElement(By.xpath("//*[contains(text(),'5 stars')]")).click();
		//Thread.sleep(5000);
		logger.info("5 Star Filter Applied");
		}
		catch(Exception e) {
			logger.error("Failed to apply 5 star filter", e);
			throw e;
		}
			
	}
	
	@Then("filtered hotel list should display")
	public void filtered_hotel_list_should_display() throws Exception{
		//boolean status = getDriver().findElement(By.xpath("//*[contains(text(),'5 stars')]")).isDisplayed();
		//if(status) {
		try {
			logger.info("Verifying filtered hotel list");
		    //Thread.sleep(2000);
			SearchResultsPage searchPage = new SearchResultsPage(getDriver());
			System.out.println("Hotel Count = "+ searchPage.getHotelList().size());
			System.out.println("5 star count =" + searchPage.getFiveStarHotels().size());
			//waitForElement(searchPage.getHotelList().get(0));
		    logger.info("Filtered hotel list displayed successfully");
		}
		catch(Exception e) {
			logger.error("Filtered hotel list validation failed");
			throw e;
		}
		//}
	}

}
