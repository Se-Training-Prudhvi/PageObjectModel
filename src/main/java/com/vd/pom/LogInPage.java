package com.vd.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {

private WebDriver driver;

private By headerPageText = By.cssSelector(".page-heading");
private By createAccountLink = By.id("link-signup");
private By emailTextBox = By.id("email");
private By passwordTextBox = By.id("passwd");
private By loginBtn = By.id("SubmitLogin");
private By accountTxt = By.cssSelector(".account");
	
	public LogInPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getLogInPageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}
	
	public boolean LogInPageTitle() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String expectedTitle = "Login - My Store";
		return getLogInPageTitle().contains(expectedTitle);
	}
	
	public boolean verifyLogInPageText() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement element = driver.findElement(headerPageText);
		String pageText = element.getText();
		System.out.println(pageText);
		String expectedPageText = "AUTHENTICATION";
		return pageText.contains(expectedPageText);
	}
		
	public CreateAccountPage clickonCreateAnAccount() {
			WebElement element=driver.findElement(createAccountLink);
			if(element.isDisplayed()||element.isEnabled())
				element.click();
			return new CreateAccountPage(driver);
	}
		
		
		public void enterUserName(String userName) {
			WebElement emailTxtBox = driver.findElement(emailTextBox);
			if(emailTxtBox.isDisplayed())
				emailTxtBox.sendKeys(userName);
		}
		
		public void enterPassword(String password) {
			WebElement passwordTxtBox = driver.findElement(passwordTextBox);
			if(passwordTxtBox.isDisplayed())
				passwordTxtBox.sendKeys(password);
		}
		
		public void clickOnSignIn() {
			WebElement signInBtn = driver.findElement(loginBtn);
			if(signInBtn.isDisplayed())
				signInBtn.click();
		}
		
		public String getMessage() {
			String strErrorMsg = null;
			WebElement errorMsg = driver.findElement(accountTxt);
			if(errorMsg.isDisplayed()&&errorMsg.isEnabled())
				strErrorMsg = errorMsg.getText();
			return strErrorMsg;
		}

		public boolean verifyLogIn() {

			enterUserName("prudhvi.kothapalli@gmail.com");
			enterPassword("Selenium");
			clickOnSignIn();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			return getMessage().contains("prudhvi kothapalli");
		}
}
