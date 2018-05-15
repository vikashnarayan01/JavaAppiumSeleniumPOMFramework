package furtados.mobile.test;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;

public class FurtadosLoginTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;

	public FurtadosLoginTest() {
		super();
	}

	//test cases should be separated -- independent with each other
	//before each test case -- launch the app and login
	//@test -- execute test case
	//after each test case -- close the app
	
	@BeforeMethod
	public void setUp() throws MalformedURLException, InterruptedException {
		mobileEnvSetup();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
//	@Test(priority=1)
//	public void verifyHomePageTitleTest(){
//		
//		String homePageTitle = homePage.verifyHomePageTitle();
//		Assert.assertEquals(homePageTitle, "CRMPRO","Home page title not matched");
//	}
	
	@Test(priority=2)
	public void loginTest(){
		
	System.out.println("PASS");
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
	
}