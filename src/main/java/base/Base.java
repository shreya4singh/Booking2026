package base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	private static WebDriver driver;
	public static WebDriver getDriver(){
		return driver ;
		//return deiver.get();
	}
	public static void setDriver(WebDriver driver1 ) {
		driver= driver1;
		//deiver.setdriver1();
	}
	public String getUrl() throws Exception
	{
		Properties prop = new Properties();
		prop.load(new FileInputStream ("C:\\Users\\Shreya.4.Singh\\eclipse-workspace\\booking2026\\src\\main\\java\\pageObjects\\data.properties"));
	 return prop.getProperty("url");	
	}
	public String getBrowser() throws Exception
	{
		Properties prop = new Properties();
		prop.load(new FileInputStream ("C:\\Users\\Shreya.4.Singh\\eclipse-workspace\\booking2026\\src\\main\\java\\pageObjects\\data.properties"));
	 return prop.getProperty("browser");	
	}
	public void initializeBrowser() throws Exception {
		String browser = getBrowser();
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriver driver = new ChromeDriver();
			setDriver(driver);
		}
	}
	public void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
