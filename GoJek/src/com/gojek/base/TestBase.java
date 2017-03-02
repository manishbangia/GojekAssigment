package com.gojek.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.gojek.config.ReadConfig;

public class TestBase {

	private static WebDriver driver;
	public static ReadConfig config;
	static String driverPath ="/Users/manishbangia/bin/chromedriver";

	public WebDriver getDriver() {
		return driver;
	}

	private void setDriver(String browserType, String appURL) {
		switch (browserType) {
		case "chrome":
			driver = initChromeDriver(appURL);
			break;
		case "firefox":
			driver = initFirefoxDriver(appURL);
			break;
		default:
			System.out.println("browser : " + browserType
					+ " is invalid, Launching Firefox as browser of choice..");
			driver = initFirefoxDriver(appURL);
		}
	}

	private static WebDriver initChromeDriver(String appURL) {
		System.out.println("Launching google chrome with new profile..");
		System.out.println(driverPath);
		System.setProperty("webdriver.chrome.driver", driverPath);
		 DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("incognito");
	        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	    driver = new ChromeDriver(capabilities);
	
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		
		System.out.println("chrome initialized");
		return driver;
	}

	private static WebDriver initFirefoxDriver(String appURL) {
		System.out.println("Launching Firefox browser..");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	
	@BeforeTest
	public void initializeTestBaseSetup() {
		try {
			config=ReadConfig.getInstance();
			setDriver("chrome","http://www.cleartrip.com");

		} catch (Exception e) {
			System.out.println("Error....." + e.getStackTrace());
		}
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}