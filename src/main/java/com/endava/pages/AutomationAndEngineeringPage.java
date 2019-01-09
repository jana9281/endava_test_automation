package com.endava.pages;

import com.endava.util.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AutomationAndEngineeringPage extends BasePage {

	public static String SUBSCRIPTION_MESSAGE = "In order to sign-up for the newsletter, " +
			"please read Terms & Conditions and Privacy Notice and check the box in order " +
			"to accept them. You can unsubscribe at any time.";

	public By signMeUpForNewsletterCheckBox = By.xpath("//*[@id='newsletter_input']");
	public By signMeUpForNewsletterLabel = By.xpath("//label[@for='newsletter_input']");
	public By promptMessage = By.id("prompt_message2");
	public By contactUsTitle = By.xpath("//h2[text()='Contact us']");

	protected AutomationAndEngineeringPage(WebDriver driver) {
		super(driver);
	}

	public void clickOnSignMeUpForNewsletterLabel() {
		WebDriverUtil.clickOnElement(driver, signMeUpForNewsletterLabel);
	}

	public void assertSubscriptionMessage() {
		Assert.assertEquals(WebDriverUtil.findElement(driver, promptMessage).getText(), SUBSCRIPTION_MESSAGE);
	}
}
