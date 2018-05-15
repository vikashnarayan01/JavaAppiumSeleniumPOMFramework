/*
 * @author Naveen Khunteta
 * 
 */

package com.qa.testcases;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;

public class AppiumTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	
	public AppiumTest(){
			super();
			
	}
	
	
	@BeforeTest
	public void setUp() throws MalformedURLException {
		
		mobileEnvSetup();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel(){
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing on the page");
	}
	
	@Test(priority=2)
	public void selectSingleContactsTest(){
		contactsPage.selectContactsByName("test2 test2");
	}
	
	@Test(priority=3)
	public void selectMultipleContactsTest(){
		contactsPage.selectContactsByName("test2 test2");
		contactsPage.selectContactsByName("ui uiii");

	}
	
	@DataProvider
	public Object[][] getLoginData(){
		Object data[][] = TestUtil.getTestData("login");
		return data;
	}
	
	
	@Test(dataProvider = "getLoginData")
	public void loginTestData(String username, String password){
		driver.findElement(By.xpath("//input[@name='username' and @type = 'text']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password' and @type = 'password']")).sendKeys(password);
		
		//login button
		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", loginBtn);
		
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
	
}
