package com.avinash.pom.Practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class YouTubeLoop {
	
	public static WebDriver driver;
	SoftAssert softassert = new SoftAssert();
	//Actions action = new Actions(driver);
	
	@Test
	public void rightClick() throws InterruptedException{
		
		//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/geckodriver");
		
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//driver.get("https://www.youtube.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
//		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//		capabilities.setCapability(ChromeDriver., value);
		
		
		driver.get("chrome://settings/clearBrowserData");
		Thread.sleep(3000);
		//driver.findElement(By.cssSelector("* /deep/ #clearBrowsingDataConfirm")).click();
		WebElement ele = driver.findElement(By.cssSelector("*/deep/#clearBrowsingDataConfirm"));
		ele.click();
		System.out.println("History cleared perfectly");
		driver.findElement(By.id("clearBrowsingDataConfirm")).click();
		System.out.println("History cleared");
		driver.findElement(By.id("advancedTabTitle")).click();
		WebElement drpdwn = driver.findElement(By.id("dropdownMenu"));
		drpdwn.click();
		Select select = new Select(drpdwn);
		select.selectByValue("4");
		driver.get("https://www.youtube.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@id='search'])[1]")).sendKeys("random dance in gym when U.P ka londa");
		
//		int x=1;
//		while(x<4)
		for(int i=1; i<4; i++)
		{
			System.out.println("Running");
			driver.findElement(By.xpath("(//button[@id='search-icon-legacy'])[1]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//a[@title='Random dance in gym'])")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("(//div[@id='logo-icon-container'])[1]")).click();
			Thread.sleep(2000);
			//driver.findElement(By.xpath("(//input[@id='search'])[1]")).clear().sendKeys("random dance in gym when U.P ka londa");
			System.out.println("Stopping");
		}



}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
