package com.vd.pom;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vd.pom.TestSetup;
import com.vd.pom.BasePage;

public class BasePageTest extends TestSetup {

	private WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}

	@Test
	public void verifyHomePage() {
		System.out.println("Base page test...");
		BasePage basePage = new BasePage(driver);
		Assert.assertTrue(basePage.verifyBasePageTitle(), "Home page title doesn't match");
	}

}