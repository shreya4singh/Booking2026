package hooks;

import java.io.ByteArrayInputStream;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

public class ScenarioHook extends Base {
	
	@Before
	public void setup() throws Exception{
		initializeBrowser();
		getDriver().get(getUrl());
		getDriver().manage().window().maximize();
		
		try {
//			Thread.sleep(3000);
//			getDriver().findElement(By.xpath("//button[@aria-label='Dismiss sign-in info']")).click();
//			System.out.println("Popup closed");
			WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(10));
			WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@aria-label,'Dismiss')]")));
			closeBtn.click();
			System.out.println("Popup closed");
		}
		catch(Exception e){
			System.out.println("Popup Not Displayed");
		}
	}
	
	@After
	public void tearDown(Scenario scenario) {
		
			byte[] screenshot = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
			
			Allure.addAttachment("Screenshot", new ByteArrayInputStream(screenshot));
		
		getDriver().quit();
	}

}
