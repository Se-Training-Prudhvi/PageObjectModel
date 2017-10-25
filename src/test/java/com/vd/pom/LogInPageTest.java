package com.vd.pom;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vd.pom.TestSetup;
import com.vd.pom.BasePage;
import com.vd.pom.LogInPage;

public class LogInPageTest extends TestSetup{
private WebDriver driver;
private LogInPage logInPage;
private BasePage basePage;
	
	@BeforeClass
	public void setUp() {
		driver=getDriver();
	}
		
	@Test
	public void verifyLoginInFunction() throws InterruptedException {
		System.out.println("Log In functionality details...");
		basePage = new BasePage(driver);
		logInPage = basePage.clickLogInBtn();
		Assert.assertTrue(logInPage.LogInPageTitle(), "Log In page title doesn't match");
		Assert.assertTrue(logInPage.verifyLogInPageText(), "Page text not matching");
		Thread.sleep(4000);
		Assert.assertTrue(logInPage.verifyLogIn(), "Page text not matching");
		Thread.sleep(4000);
	}

}
