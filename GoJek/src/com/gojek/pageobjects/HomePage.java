package com.gojek.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.gojek.base.TestBase;

public class HomePage extends TestBase{

	public WebDriver driver;
	

	@FindBy(id="FromTag")
	public By FromCity;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	//	PageFactory.initElements(driver, HomePage.class);
	}
	
	public Boolean searchFlights(String departureCity,String returnCity,String departDate,String returnDate) throws InterruptedException
	{
		WebElement radioButton = driver.findElement(By.id("RoundTrip"));
		radioButton.click();
		
		
		driver.findElement(By.id("FromTag")).click();
		driver.findElement(By.id("FromTag")).sendKeys(departureCity);
		Reporter.log(departureCity+ "is entered in departure city");
		
		
		driver.findElement(By.id("ToTag")).click();
		
		driver.findElement(By.id("ToTag")).sendKeys(returnCity);
	
		
		driver.findElement(By.id("DepartDate")).click();
		
		Reporter.log(returnCity +"is entered in return city");
		
		
		((JavascriptExecutor)driver).executeScript ("document.getElementById('DepartDate').removeAttribute('readonly',0);"); // Enables the from date box

		WebElement fromDateBox= driver.findElement(By.id("DepartDate"));
		fromDateBox.clear();
		fromDateBox.sendKeys(departDate);
		driver.findElement(By.id("DepartDate")).sendKeys(Keys.TAB);

		((JavascriptExecutor)driver).executeScript ("document.getElementById('ReturnDate').removeAttribute('readonly',0);"); // Enables the from date box

		WebElement toDateBox= driver.findElement(By.id("ReturnDate"));
		toDateBox.clear();
		toDateBox.sendKeys(returnDate);
		driver.findElement(By.id("ReturnDate")).sendKeys(Keys.TAB);

		
		Select numAdults= new Select(driver.findElement(By.id("Adults")));
		numAdults.selectByValue(config.fetchConfig("Adults"));
		
		driver.findElement(By.id("SearchBtn")).click();
		System.out.println(driver.getTitle().toString());
		
		
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

	}

}
