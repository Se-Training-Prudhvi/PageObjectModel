package com.vd.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
	protected WebDriver driver;
	
	private By LogInButton = By.className("login");

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public LogInPage clickLogInBtn() {
		System.out.println("clicking on Log in button");
		WebElement LogInBtnElement = driver.findElement(LogInButton);
		if (LogInBtnElement.isDisplayed() || LogInBtnElement.isEnabled())
			LogInBtnElement.click();
		else
			System.out.println("Element not found");
		return new LogInPage(driver);
	}

	public String getPageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public boolean verifyBasePageTitle() {
		String expectedPageTitle = "My Store";
		return getPageTitle().contains(expectedPageTitle);
	}
}
