package com.hcl.openemr;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class OpenEmrTest {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://demo.openemr.io/b/openemr/index.php"); 
		
		driver.findElement(By.id("authUser")).sendKeys("admin");
		
		driver.findElement(By.name("clearPass")).sendKeys("pass");
			
		WebElement languageEle= driver.findElement(By.name("languageChoice"));
		Select selectLanguage=new Select(languageEle);		
		selectLanguage.selectByVisibleText("English (Indian)");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//driver.findElement(By.className("btn")).click();
		
		
		WebElement billyEle=driver.findElement(By.xpath("//span[text()='Billy']"));
		Actions actions=new Actions(driver);
		actions.moveToElement(billyEle).build().perform();
		
//		Actions actions=new Actions(driver);
//		actions.moveToElement(driver.findElement(By.xpath("//span[text()='Billy']"))).build().perform();
		
		
		//click on logout
		driver.findElement(By.xpath("//li[text()='Logout']")).click();
	}
}
