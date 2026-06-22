package hooks;

import base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ScenarioHook extends Base {
	
	@Before
	public void setup() throws Exception{
		initializeBrowser();
		getDriver().get(getUrl());
		getDriver().manage().window().maximize();
	}
	
	@After
	public void tearDown() {
		if(getDriver() != null) {
			getDriver().quit();
		}
	}

}
