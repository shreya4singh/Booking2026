package stepDefinitions;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import base.Base;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.SearchResultsPage;

public class A_SearchHotelStep extends Base {
	HomePage homePage;
	private static final Logger logger = LogManager.getLogger(A_SearchHotelStep.class);
	
	@Given("user is on booking website")
	public void user_is_on_booking_website() throws Exception {
		try {
			logger.info("Launching booking website"); 
		
		getDriver().get(this.getUrl());
		getDriver().manage().window().maximize();
		Thread.sleep(2000);
		
//		try {
//			getDriver().findElement(By.xpath("//button[contains(@aria-label,'Dismiss')]")).click();
//		}
//		catch(Exception ex) {
//			System.out.println("Popup not found");
//		}
		homePage = new HomePage(getDriver());
		logger.info("Website launched successfully");
		}
		catch(Exception e) {
			logger.error("Website launch failed", e);
			throw e;
		}
	}
	
	@When("user enters city")
	public void user_enters_city() throws Exception {
		//Thread.sleep(2000);
		//homePage.getDestination().click();
		try {
			logger.info("Entering city");
			//Thread.sleep(2000);
		waitForElement(homePage.getDestination());
		homePage.getDestination().clear();
		homePage.getDestination().sendKeys("Mumbai");
		//homePage.getSearchButton().click();
		Thread.sleep(2000);
		System.out.println("Mumbai entered");
		}
		catch(Exception e) {
		//Thread.sleep(2000);
			logger.error("Failed to enter city", e);
			throw e;
		}
	}
	
	
	@When("user clicks search")
	public void user_clicks_search() throws Exception{
		try {
			logger.info("Clicking search button");
			waitForElement(homePage.getSearchButton());
		
		//Thread.sleep(3000);
		homePage.getSearchButton().click();
		logger.info("Search button clicked successfully");
		}
		catch(Exception e) {
			logger.error("Failed to click search button", e);
			throw e;
		}
	}
	
	@Then("hotel list should display")
	public void hotel_list_should_display() {
		try {
			logger.info("Verifying hotel list");	
			SearchResultsPage searchPage = new SearchResultsPage(getDriver());
			Assert.assertTrue(searchPage.getHotelList().size() > 0);
			logger.info("Hotel list displayed successfully");
		}
		catch(Exception e) {
			logger.error("Hotel list verification failed", e);
			throw e;
		}
		//String title = getDriver().getTitle();
		
		//Assert.assertTrue(title.contains("Booking"));
	}

}
