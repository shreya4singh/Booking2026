package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import base.Base;
import io.cucumber.java.en.When;
import pageObjects.HomePage;

public class B_SelectDateStep extends Base {
	HomePage homePage;
	private static final Logger logger = LogManager.getLogger(B_SelectDateStep.class);
	
	@When("user selects dates")
	public void user_selects_dates() throws Exception {
		try {
			
			logger.info("Date selection started");
		homePage = new HomePage(getDriver());
		waitForElement(homePage.getDateField());
		homePage.getDateField().click();
		//Thread.sleep(2000);
		getDriver().findElement(By.xpath("//span[@data-date='2026-07-10']")).click();
		getDriver().findElement(By.xpath("//span[@data-date='2026-07-15']")).click();
		logger.info("Dates selected successfully");
		Thread.sleep(2000);
		}
		catch(Exception e) {
			logger.error("Date selection failed", e);
			throw e;
		}
	}
}


