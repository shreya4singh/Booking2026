package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import base.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;

public class A_SearchHotelStep extends Base {
	HomePage homePage;
	
	@Given("user is on booking website")
	public void user_is_on_booking_website() throws Exception {
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
	}
	
	@When("user enters city")
	public void user_enters_city() throws Exception {
		Thread.sleep(2000);
		//homePage.getDestination().click();
		homePage.getDestination().clear();
		homePage.getDestination().sendKeys("Mumbai");
		//homePage.getSearchButton().click();
		Thread.sleep(2000);
		System.out.println("Mumbai entered");
		Thread.sleep(2000);
	}
	
	
	@When("user clicks search")
	public void user_clicks_search() throws Exception{
		Thread.sleep(3000);
		homePage.getSearchButton().click();
	}
	
	@Then("hotel list should display")
	public void hotel_list_should_display() {
		String title = getDriver().getTitle();
		
		Assert.assertTrue(title.contains("Booking"));
	}

}
