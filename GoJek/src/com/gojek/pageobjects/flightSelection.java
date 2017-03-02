package com.gojek.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gojek.util.ExplicitWait;

public class flightSelection {

	public WebDriver driver;
	ExplicitWait explicitWait = new ExplicitWait();
	public Boolean isFlightSelectionPage (WebDriver driver)
	{	
		explicitWait.waitByXpath(driver,"//*[@name='leg0']");
		return driver.findElement(By.id("ui-datepicker-div")).isDisplayed();
	}
	
	public Boolean selectFlight(WebDriver driver)
	{
		List<WebElement> flightsError = driver.findElements(By.linkText("Try searching again"));
		if(flightsError.size()>0)
		{
			System.out.println("Sorry, there aren't any flights available for your search");
			return false;
		}
		else
			{
		
		List<WebElement> bookButton = driver.findElements(By.xpath(".//*[@id='flightForm']/section[2]/div[3]/div[3]/button"));
		System.out.println(bookButton.size());
		bookButton.get(1).click();
		return true;
			
			}
	}
}

