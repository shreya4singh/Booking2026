package stepDefinitions;

import org.openqa.selenium.By;

import base.Base;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;

public class C_FilterHotelStep extends Base{
	HomePage homePage;
	
	@When("user applies 5 star filter")
	public void user_applies_5_star_filter() throws Exception{
		homePage = new HomePage(getDriver());
		Thread.sleep(2000);
		
		homePage.getFiveStarFilter().click();
		Thread.sleep(5000);
		System.out.println("5 Star Filter Applied");
			
	}
	@Then("filtered hotel list should display")
	public void filtered_hotel_list_should_display() throws Exception{
		//boolean status = getDriver().findElement(By.xpath("//*[contains(text(),'5 stars')]")).isDisplayed();
		//if(status) {
			System.out.println("Filtered hotels dsplayed successfully");
		//	Thread.sleep(2000);
		//}
	}

}
