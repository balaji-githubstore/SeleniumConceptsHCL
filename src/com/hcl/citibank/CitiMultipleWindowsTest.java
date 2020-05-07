package com.hcl.citibank;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CitiMultipleWindowsTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.online.citibank.co.in/products-services/online-services/internet-banking.htm"); 
		
		driver.findElement(By.linkText("APPLY FOR CREDIT CARDS")).click();
		
		Thread.sleep(5000);
		
		String parent = driver.getWindowHandle();
		System.out.println(parent);
		
		System.out.println("--------------------------------");
		
		Set<String> windows=  driver.getWindowHandles();
		
		for(String win : windows)
		{
			System.out.println(win);
			driver.switchTo().window(win); //switch to that session id
			String title = driver.getTitle();
			System.out.println(title);
			if(title.equals("Credit Card Application Online, Apply Now - Citi India"))
			{
				//stop iteration
				break;
			}
		}
		
		
		
		//click on travel
		
		driver.close();
		
		//get the title

	}

}
