package com.hcl.openemr;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CreatePatientTest {

	public static void main(String[] args) throws InterruptedException {
		
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
		
		
		WebElement patEle=driver.findElement(By.xpath("//div[text()='Patient/Client']"));
		Actions actions=new Actions(driver);
		actions.moveToElement(patEle).build().perform();
		
		driver.findElement(By.xpath("//*[text()='New/Search']")).click();
		
		Thread.sleep(3000);
		
		driver.switchTo().frame("pat");
		//explicit wait for id -->form_fname
		driver.findElement(By.id("form_fname")).sendKeys("peter");
		driver.findElement(By.id("form_lname")).sendKeys("paul");
		driver.findElement(By.id("form_DOB")).sendKeys("2020-05-06");
		
		Select selectGender=new Select(driver.findElement(By.id("form_sex")));
		selectGender.selectByVisibleText("Male");
		
		driver.findElement(By.id("create")).click();
		
		driver.switchTo().defaultContent(); //come out of frame
		
		driver.switchTo().frame("modalframe");
		
		driver.findElement(By.xpath("//input[@value='Confirm Create New Patient']")).click();
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(5000);
		//alert box
		Alert alert= driver.switchTo().alert();
		
		String alertText = alert.getText();
		System.out.println(alertText);
		
		alert.accept();
		
		//close the happy birthday
		driver.findElement(By.xpath("//div[@class='closeDlgIframe']")).click();
		
		
	}
}
