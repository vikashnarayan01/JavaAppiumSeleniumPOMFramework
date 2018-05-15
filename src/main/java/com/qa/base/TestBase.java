package com.qa.base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.util.TestUtil;
import com.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static AppiumDriver<MobileElement> mobdriver;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/qa/config/config.properties");
			// user.dir means current directories("d:/javaSelenium/JavaAppiumFramework" + "your current path")
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void mobileEnvSetup() throws MalformedURLException {
		
	    DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("platformName", prop.getProperty("platformName"));
	    caps.setCapability("platformVersion", prop.getProperty("platformVersion"));
	    caps.setCapability("deviceName", prop.getProperty("deviceName"));
	    caps.setCapability("udid", prop.getProperty("udid"));
	    //caps.setCapability("app", prop.getProperty("appPath"));
	    //caps.setCapability("automationName", prop.getProperty("automationName"));
	    caps.setCapability("appPackage", prop.getProperty("appPackage"));
	    caps.setCapability("appActivity", prop.getProperty("appActivity"));
	    //caps.setCapability("devicePort", prop.getProperty("devicePort"));

	    URL remoteUrl = new URL("http://localhost:4723/wd/hub");
	    mobdriver = new AppiumDriver<MobileElement>(remoteUrl, caps);
	  }
	
	
	public static void webEnvSetup(){
		String browserNameChrome = prop.getProperty("browser");
		String browserNameFirefox = prop.getProperty("firefox");
		
		if(browserNameChrome.equals("chrome")){
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/drivers/chromedriver.exe"); 
			driver = new ChromeDriver(); 
		}
		else if(browserNameFirefox.equals("FF")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}

}
