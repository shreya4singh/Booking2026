package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resource/features"},
glue = {"stepDefinitions", "hooks"},
tags = "@searchhotel or @selectdates or @filterhotel",
plugin = { "pretty",
		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
})

public class TestRunner extends AbstractTestNGCucumberTests {
    
}
