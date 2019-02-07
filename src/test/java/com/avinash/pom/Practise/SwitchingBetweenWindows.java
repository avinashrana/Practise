package com.avinash.pom.Practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SwitchingBetweenWindows {
	
	public static WebDriver driver;
	SoftAssert softassert = new SoftAssert();
	//Actions action = new Actions(driver);
	
	@Test
	public void switchWindows() throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//input[@class='gLFyf gsfi'])[1]")).sendKeys("cricbuzz");
		driver.findElement(By.xpath("(//input[@aria-label='Google Search'])[1]")).click();;
		Thread.sleep(3000);

}
	
}

/*String parentWindow = driver.getWindowHandle();
Set<String> handles =  driver.getWindowHandles();
   for(String windowHandle  : handles)
       {
       if(!windowHandle.equals(parentWindow))
          {
          driver.switchTo().window(windowHandle);
         <!--Perform your operation here for new window-->
         driver.close(); //closing child window
         driver.switchTo().window(parentWindow); //cntrl to parent window
          }
       } */

/*
 // Store the current window handle
String winHandleBefore = driver.getWindowHandle();

// Perform the click operation that opens new window

// Switch to new window opened
for(String winHandle : driver.getWindowHandles()){
    driver.switchTo().window(winHandle);
}

// Perform the actions on new window

// Close the new window, if that window no more required
driver.close();

// Switch back to original browser (first window)
driver.switchTo().window(winHandleBefore);

// Continue with original browser (first window)
 */

/*
 It is not necessary to create a new instance of the driver object. You can use JavaScript to open a new window which is a lot faster.

To open the window:

IJavaScriptExecutor jscript = driver as IJavaScriptExecutor;
jscript.ExecuteScript("window.open()");
Then to switch windows, use the window handles:

List<string> handles = driver.WindowHandles.ToList<string>();
driver.SwitchTo().Window(handles.Last());

driver.Navigate().GoToUrl(url);
 */
