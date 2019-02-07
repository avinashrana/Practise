package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommonUtils.OptionsManager;

import java.net.MalformedURLException;
import java.net.URL;

public class TLDriverFactory {

	private static OptionsManager optionsManager = new OptionsManager();
	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public static synchronized void setDriver(String browser) {
		if (browser.equals("firefox")) {
			// In mac, we dont have to provide driver path. We just need to place our drivers in the following path "/usr/local/bin"
			// This is my code for geckoDriver
			// System.setProperty("webdriver.gecko.driver",
			// System.getProperty("user.dir")+"/geckodriver");

			// For Local Usage
			tlDriver = ThreadLocal.withInitial(() -> new FirefoxDriver(optionsManager.getFirefoxOptions()));

			// For Grid Usage
			try {
				tlDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/grid/console"),
						optionsManager.getFirefoxOptions()));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		} else if (browser.equals("chrome")) {
			// In mac, we dont have to provide driver path. We just need to place our drivers in the following path "/usr/local/bin"
			// This is my code for chromeDriver
			// System.setProperty("webdriver.chrome.driver",
			// System.getProperty("user.dir")+"/chromedriver");

			// For Local Usage
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));

			// For Grid Usage
			try {
				tlDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/grid/console"),
						optionsManager.getChromeOptions()));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
	}

	public static synchronized WebDriverWait getWait(WebDriver driver) {
		return new WebDriverWait(driver, 20);
	}

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

}
