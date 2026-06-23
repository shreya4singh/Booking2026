package hooks;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

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
	}
	
	@After
	public void tearDown(Scenario scenario) {
		
			byte[] screenshot = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
			
			Allure.addAttachment("Screenshot", new ByteArrayInputStream(screenshot));
		
		getDriver().quit();
	}

}
