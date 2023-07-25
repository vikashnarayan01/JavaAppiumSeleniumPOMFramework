package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends TestBase {

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Login']")
	private WebElement login;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Email']")
	private WebElement emailId;

	@AndroidFindBy(xpath = "//android.widget.EditText[2]")
	private WebElement password;

	@AndroidFindBy(className = "android.widget.ImageView")
	private WebElement image;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SIGN IN']")
	private WebElement signIn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='']")
	private WebElement hamburger;

	@FindBy(xpath = "//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;

	// Initializing the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}

	public HomePage login(String username, String pwd) throws InterruptedException {
		Thread.sleep(3000);
		login.click();
		emailId.sendKeys(username);
		password.sendKeys(pwd);
		// loginBtn.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", signIn);

		return new HomePage();
	}

}
