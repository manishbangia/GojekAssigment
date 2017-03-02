package com.gojek.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public void wait (WebDriver driver,String element)
	{
		WebDriverWait wait= new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(element))));
	}
	
	public void waitByXpath(WebDriver driver,String xpath)
	{
		try {
			Thread.sleep(5000);
		
		WebDriverWait wait= new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));
		}
		 catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}


