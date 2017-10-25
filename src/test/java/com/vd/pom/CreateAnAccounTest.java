package com.vd.pom;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vd.pom.TestSetup;
import com.vd.pom.BasePage;
import com.vd.pom.*;

public class CreateAnAccounTest extends TestSetup {
	private WebDriver driver;
	private LogInPage logInPage;
	private BasePage basePage;
	private CreateAccountPage createAccountPage;
		
		@BeforeClass
		public void setUp() {
			driver=getDriver();
		}
		
		@Test
		public void verifyCreateAnAccounPage() {
			System.out.println("Create An Account page test...");
			basePage = new BasePage(driver);
			logInPage = basePage.clickLogInBtn();
			createAccountPage = logInPage.clickonCreateAnAccount();
			Assert.assertTrue(createAccountPage.verifyPageTitle(), "Page title not matching");
			Assert.assertTrue(createAccountPage.verifyCreateAccountPageText(), "Page text not matching");
		}
		
		public void verifyLogInFunction() {
			
		}

}
