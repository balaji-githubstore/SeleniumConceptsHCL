package com.hcl.launchbrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LaunchBrowserTest {
	public static void main(String[] args) {

		// Run time polymorphism
		WebDriver driver = new ChromeDriver();
		driver.get("https://magento.com/");

//		By myAccLocator = By.linkText("My Account");
//		WebElement myAccEle = driver.findElement(myAccLocator);
		
		WebElement myAccEle = driver.findElement(By.linkText("My Account"));
		String href= myAccEle.getAttribute("href");
		System.out.println(href);
		
		myAccEle.click();

	}

}
