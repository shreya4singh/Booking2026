package stepDefinitions;

import org.openqa.selenium.By;

import base.Base;
import io.cucumber.java.en.When;
import pageObjects.HomePage;

public class B_SelectDateStep extends Base {
	HomePage homePage;
	
	@When("user selects dates")
	public void user_selects_dates() throws Exception {
		homePage = new HomePage(getDriver());
		homePage.getDateField().click();
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("//span[@data-date='2026-07-10']")).click();
		getDriver().findElement(By.xpath("//span[@data-date='2026-07-15']")).click();
		System.out.println("Dates selected");
		Thread.sleep(2000);
	}
}


