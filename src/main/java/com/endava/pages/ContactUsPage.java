package com.endava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ContactUsPage extends BasePage {

	public By contactButtons = By.id("contact-buttons");
	public By sharedButtons = By.className("share-field light");
	public By radioButton1 = By.id("services-choice");
	public By radioButton2 = By.id("join-team");

	protected ContactUsPage(WebDriver driver) {
		super(driver);
	}

	public void isPageOpen() {
		Assert.assertNotEquals(driver.getCurrentUrl(), ENDAVA_URL);
	}
}
