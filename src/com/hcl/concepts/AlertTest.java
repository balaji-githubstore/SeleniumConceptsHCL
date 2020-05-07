package com.hcl.concepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://www.echoecho.com/javascript4.htm"); 
		
		driver.findElement(By.name("B2")).click();
		
		Alert alert= driver.switchTo().alert();
			
		String alertText = alert.getText();
		System.out.println(alertText);
		
		alert.accept();
		
	}

}
