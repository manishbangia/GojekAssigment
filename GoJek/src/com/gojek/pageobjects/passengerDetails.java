package com.gojek.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.gojek.util.ExplicitWait;

public class passengerDetails {

	public WebDriver driver;
	ExplicitWait explicitWait = new ExplicitWait();
	
	public void deSelectInsuranceAndContinue(WebDriver driver)
	{
		
		if (driver.findElement(By.id("insurance_box")).isSelected())
			driver.findElement(By.id("insurance_box")).click();
		else
			Reporter.log("Insurance box was already deselected");
		driver.findElement(By.id("itineraryBtn")).click();
	}
	
	public void enterEmailAndContinue (WebDriver driver,String email)
	{
		explicitWait.wait(driver, "username");
		
		if(driver.findElement(By.id("username")).isDisplayed())
		{
			driver.findElement(By.id("username")).clear();
			driver.findElement(By.id("username")).sendKeys(email);
		}
		else
			Reporter.log("Email address field is not displayed");
		
		driver.findElement(By.id("LoginContinueBtn_1")).click();
		System.out.println("Login button clicked");
	}
	
	public void enterPassengerDetails(WebDriver driver, int numberOfPax)
	{
		explicitWait.wait(driver, "AdultTitle1");
		for(int i=1;i<=numberOfPax;i++)
		{
			Select numAdults= new Select(driver.findElement(By.id("AdultTitle"+i)));
			numAdults.selectByValue("Mr");
			
			driver.findElement(By.id("AdultFname"+i)).clear();
			driver.findElement(By.id("AdultFname"+i)).sendKeys("FirstName "+i+"Name");
			driver.findElement(By.id("AdultLname"+i)).clear();
			driver.findElement(By.id("AdultLname"+i)).sendKeys("LastName "+i+"Name");
		}
		
	}
	
	// Price changebutton priceChangeDownBtn
	
	public Boolean isEmailSectionVisible( WebDriver driver)
	{
		Boolean isEmail=false;
		
		
		
		return isEmail;
		
	}
	
	public void enterMobileNumberAndContinue (WebDriver driver,String mobileNumber)
	{
		if(driver.findElement(By.id("mobileNumber")).isDisplayed())
		{
			driver.findElement(By.id("mobileNumber")).clear();
			driver.findElement(By.id("mobileNumber")).sendKeys(mobileNumber);
		}
		else
			Reporter.log("Mobile number field is not displayed");
			
		driver.findElement(By.id("travellerBtn")).click();
	}
	
	public void isPaymentDetailsVisible(WebDriver driver)
	{
		explicitWait.wait(driver, "CCTab");
		Reporter.log("CCTab is displayed");
	}
}
