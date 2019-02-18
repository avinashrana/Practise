package com.avinash.pom.Practise;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RightClick {
	
	public static WebDriver driver;
	SoftAssert softassert = new SoftAssert();
	//Actions action = new Actions(driver);
	
	@Test
	public void rightClick() throws InterruptedException{
		
		ChromeOptions options = new ChromeOptions();
		
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
		driver = new ChromeDriver();
//		FirefoxOptions options = new FirefoxOptions();
//		options.setLogLevel(FirefoxDriverLogLevel.TRACE);
		driver = new FirefoxDriver(options);
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.get("http://automate-apps.com/");
//        driver.manage().window().maximize();
//        Thread.sleep(3000);
//        System.out.println(driver.getTitle());
//        Actions action = new Actions(driver);
//        WebElement element = driver.findElement(By.partialLinkText("Selenium Questions"));
//        action.contextClick(element).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
//        Thread.sleep(3000);
//        Set<String> winid = driver.getWindowHandles();
//        Iterator<String> iter = winid.iterator();
//        iter.next();
//        String tab = iter.next();
//        driver.switchTo().window(tab);
//        System.out.println(driver.getTitle());
//        Thread.sleep(3000);
		
		
		
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		WebElement ele = driver.findElement(By.xpath("(//input[@class='gLFyf gsfi'])[1]"));
		highlightElement(ele);
		ele.sendKeys("cricbuzz");
		driver.findElement(By.xpath("(//input[@aria-label='Google Search'])[1]")).click();;
		Thread.sleep(3000);
		System.out.println("Before right click");
		//Actions action = new Actions(driver);
		//driver.findElement(By.xpath("(//*[@class='LC20lb'])[1]"))
		
		Actions builder = new Actions(driver);
//		Action seriesOfActions = builder
//			.moveToElement(txtUsername)
//			.click()
//			.keyDown(txtUsername, Keys.SHIFT)
//			.sendKeys(txtUsername, "hello")
//			.keyUp(txtUsername, Keys.SHIFT)
//			.doubleClick(txtUsername)
//			.contextClick()
//			.build();
			
//		seriesOfActions.perform() ;
		
		WebElement element = driver.findElement(By.xpath("(//*[@class='LC20lb'])[1]"));
		//This is for 2nd option after right click which is open in new window
		//Action seriesOfActions = builder.contextClick(element).pause(2000).release().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
		
		Action seriesOfActions = builder.contextClick(element).pause(2000).release().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();

		
		seriesOfActions.perform();
		
		//This is for 3rd option after right click which is open in new incognito window
//		action.contextClick(driver.findElement(By.xpath("(//*[@class='LC20lb'])[1]"))).
//		sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
		Thread.sleep(5000);
		System.out.println("After right click");
		
		
		}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void highlightElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: blue; border: 2px solid red;');", element);
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
	}
	// My name is Avinash Rana and i am typing this statement because i want to trigger a job in jenkins

}
