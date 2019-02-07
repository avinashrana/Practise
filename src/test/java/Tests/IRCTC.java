package Tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;
//import com.thoughtworks.selenium.Wait;

public class IRCTC {

 public static void main(String[] args) throws InterruptedException {
  
  WebDriver driver=new FirefoxDriver();
  
  driver.navigate().to("https://www.irctc.co.in");  // IRCTC Website URL
  
  Thread.sleep(3000);
  
  driver.findElement(By.cssSelector("#usernameId")).sendKeys("");  //Enter USER NAME
  
  driver.findElement(By.cssSelector("#loginFormId > div.grid_16.alpha.g_box > div.grid_16.alpha > table:nth-child(1) > tbody > tr:nth-child(2) > td:nth-child(2) > input")).sendKeys(""); //Enter Password
  
  Thread.sleep(10000);  //Used to Enter CAPTCHA Value manually (Can't be auto filled).
 
  driver.findElement(By.name("submit")).click();  //Clicks on SUBMIT Button Automatically.
  
  Thread.sleep(1000);
  
  WebElement webElements= driver.findElement(By.id("jpform:fromStation"));
  
  webElements.sendKeys(""); //Enter "From" Station Code. (Example "NDLS" for "New Delhi").
  
  webElements.sendKeys(Keys.TAB);
  
  Thread.sleep(1000);
   
  WebElement webElements1= driver.findElement(By.id("jpform:toStation"));
  
  webElements1.sendKeys(""); //Enter "to" Station Code. (Example "CNB" for "Kanpur").
  
  webElements1.sendKeys(Keys.TAB);
  
  Thread.sleep(1000);
   
  driver.findElement(By.id("jpform:journeyDateInputDate")).sendKeys("");  //Enter Date Of Journey
  
  Thread.sleep(3000);
  
  driver.findElement(By.id("jpform:jpsubmit")).click(); //Clicks on SUBMIT Button Automatically.
  
  Thread.sleep(3000);
  
  driver.findElement(By.id("cllink-12034-CC-1")).click();  //Clicks on Class Automatically to show seat availability.
  
  Thread.sleep(3000);
  
  WebDriverWait wait = new WebDriverWait(driver, 10);
  
  WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#c1 > div:nth-child(1) > div:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(5) > a:nth-child(2)"))); //Waiting for "Book Now" link to be generate.
  
  driver.findElement(By.cssSelector("#c1 > div:nth-child(1) > div:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(5) > a:nth-child(2)")).click();  //Clicks on "Book Now" link.
  
  Thread.sleep(3000);
  
  driver.findElement(By.className("psgn-name")).sendKeys(""); //Enter Passenger Name.
  
  Thread.sleep(3000);
  
  driver.findElement(By.cssSelector("#addPassengerForm\\:psdetail\\:0\\:psgnAge")).click(); 
  
  Thread.sleep(3000);
  
  driver.findElement(By.cssSelector("#addPassengerForm\\:psdetail\\:0\\:psgnAge")).sendKeys(""); //Enter Passenger Age.
  
  Thread.sleep(3000);
  
  WebElement webelements5=driver.findElement(By.cssSelector("#addPassengerForm\\:psdetail\\:0\\:psgnGender"));
  
  Thread.sleep(3000);
  
  webelements5.sendKeys(""); //Enter Passenger Gender.
  
  Thread.sleep(3000);
  
  webelements5.sendKeys(Keys.TAB);
  
  Thread.sleep(3000);
  
  WebElement webelements4=driver.findElement(By.cssSelector("#addPassengerForm\\:psdetail\\:0\\:berthChoice"));
  
  Thread.sleep(3000);
  
  webelements4.sendKeys(""); //Enter Seat of your choice.
  
  Thread.sleep(3000);
  
  webelements4.sendKeys(Keys.TAB);
  
  Thread.sleep(3000);
  
  WebElement webelements3=driver.findElement(By.cssSelector("#addPassengerForm\\:psdetail\\:0\\:foodChoice"));
  
  Thread.sleep(3000);
  
  webelements3.sendKeys(""); //Enter Meal Type
  
  Thread.sleep(3000);
  
  webelements3.sendKeys(Keys.TAB);
  
  Thread.sleep(30000);  //Enter CAPTCHA Value Manually.
  
  driver.findElement(By.id("addPassengerForm:mobileNo")).sendKeys("");  //Enter Passenger Mobile No.
  
  Thread.sleep(3000);
  
  driver.findElement(By.id("validate")).click(); //Clicks on "Make Payment" button.
  
  Thread.sleep(3000);
  
  driver.findElement(By.id("CASH_CARD")).click(); //Select Payment Option.
  
  Thread.sleep(3000);
  
  driver.findElement(By.cssSelector("td.CASH_CARD > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2) > input:nth-child(1)")).click(); //Select Payment Gateway.
  
  Thread.sleep(3000);
  
  driver.findElement(By.cssSelector(".prefdBankOpt > input:nth-child(2)")).click(); //Clicks on "Add as preferred bank" Option.
  
  Thread.sleep(3000);
  
  driver.findElement(By.id("validate")).click(); //Clicks on payment button.
  }

 
 }
  
