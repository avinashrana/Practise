package com.avinash.pom.Practise;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RightClickPart3 {
	
	public static WebDriver driver;
	SoftAssert softassert = new SoftAssert();
	//Actions action = new Actions(driver);
	
	@Test
	public void rightClick() throws InterruptedException{
		
		//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
//		WebElement ele = driver.findElement(By.xpath("(//input[@class='gLFyf gsfi'])[1]"));
//		
//		ele.sendKeys("cricbuzz");
//		driver.findElement(By.xpath("(//input[@aria-label='Google Search'])[1]")).click();;
//		Thread.sleep(3000);
		
//		driver.findElement(By.cssSelector("body")).sendKeys(Keys.COMMAND +"t");
//		
//		Thread.sleep(3000);
//		
//		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
//		driver.switchTo().window(tabs.get(0));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("window.open()");
		
//		List<String> handles = driver.getWindowHandles().to
//		driver.SwitchTo().Window(handles.Last());
//
//		driver.Navigate().GoToUrl(url);
		
		
		Thread.sleep(3000);
		System.out.println("Navigated to new tab");


}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
