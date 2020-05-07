package com.hcl.magento;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://magento.com/"); //wait until page load happen
		
		WebElement myAccEle= driver.findElement(By.linkText("My Account")); //0.5 or 500ms to decide 
		myAccEle.click();
		
		WebElement emailEle= driver.findElement(By.id("email"));
		emailEle.sendKeys("balaji0017@gmail.com");
		
		//welcome@123
		WebElement passEle= driver.findElement(By.id("pass"));
		passEle.sendKeys("welcome@123");
		//click on login
		
		WebElement loginEle= driver.findElement(By.id("send2"));
		loginEle.click();
		
		//make sure mainpage is loaded
		WebDriverWait wait=new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Out")));
		
		
	//	String expectedId ="MAG004563920";
		
		String pageSource = driver.getPageSource();
		
		if(pageSource.contains("MAG004563920"))
		{
			System.out.println("Passed");
		}
		else
		{
			System.out.println("Failure");
		}	
		
		String expectedTitle="My Account";
		
		String actualTitle= driver.getTitle();
		System.out.println(actualTitle);
		
		if(actualTitle.equals(expectedTitle))
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("failure");
		}
		
		//click on logout
		WebElement logOutEle= driver.findElement(By.partialLinkText("Out"));
		logOutEle.click();
	}

}
