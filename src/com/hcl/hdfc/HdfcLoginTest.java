package com.hcl.hdfc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HdfcLoginTest {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://netbanking.hdfcbank.com/netbanking/"); 
		
		//driver.switchTo().frame(0);
		//or 
		//Thread.sleep(5000);
		
		driver.switchTo().frame("login_page");
		
		//driver.switchTo().frame(driver.findElement(By.xpath("//frame[contains(@src,'RSLogin')]")));
		
		//send username
		driver.findElement(By.name("fldLoginUserId")).sendKeys("Test123");
		
		//click on continue
		driver.findElement(By.xpath("//img[@alt='continue']")).click();
		
		//come to main html
		driver.switchTo().defaultContent();
		
	}

}
