package com.endava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * @author Nadezda.Petrovic
 * 
 */

public class CloudPage extends BasePage {
	public By contactUs = By.id("form-submit");
	public By firstName = By.id("firstname");
	public By lastName = By.id("lastname");
	public By warningMessage1 = By.xpath("//*[@class=\"error\"]//p[text()='Please enter Email Address']");
	public By warningMessage2 = By.xpath("//*[@class=\"error\"]//p[text()='Please enter Company']");
	public By warningMessage3 = By.xpath("//*[@class=\"error\"]//p[text()='Please enter Country/Region']");

	public CloudPage(WebDriver driver) {
		super(driver);
	}

	public void isUrlChanged() {
		Assert.assertNotEquals(driver.getCurrentUrl(), ENDAVA_URL);
	}

}