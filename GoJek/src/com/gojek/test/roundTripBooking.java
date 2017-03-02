package com.gojek.test;

import java.util.List;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.gojek.base.TestBase;
import com.gojek.pageobjects.HomePage;
import com.gojek.pageobjects.flightSelection;
import com.gojek.pageobjects.passengerDetails;
import com.gojek.util.ExplicitWait;

public class roundTripBooking extends TestBase{
	
	private WebDriver driver;
	HomePage homepage;
	flightSelection flightSelection = new flightSelection();
	passengerDetails passengerDetails = new passengerDetails();
	ExplicitWait explicitWait=new ExplicitWait();
	
	@BeforeClass
	public void setUp() {
		driver=getDriver();
		homepage=PageFactory.initElements(driver, HomePage.class);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void bookFlight() throws InterruptedException {
		
		homepage.searchFlights(config.fetchConfig("departureCity"),config.fetchConfig("returnCity"),config.fetchConfig("departDate"),config.fetchConfig("returnDate"));
		flightSelection.isFlightSelectionPage(driver);
		Assert.assertTrue(flightSelection.selectFlight(driver));
		passengerDetails.deSelectInsuranceAndContinue(driver);
		passengerDetails.enterEmailAndContinue(driver, config.fetchConfig("email"));
		passengerDetails.enterPassengerDetails(driver, Integer.parseInt(config.fetchConfig("Adults")));
		passengerDetails.enterMobileNumberAndContinue(driver, config.fetchConfig("mobileNumber"));
		passengerDetails.isPaymentDetailsVisible(driver);
		}

}
