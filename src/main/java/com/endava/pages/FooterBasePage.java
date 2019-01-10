package com.endava.pages;

import com.endava.util.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class FooterBasePage extends BasePage {

	public static String NEWSLETTER_SUGGESTION = "Please make our day by signing up for our newsletter.";
	public static String SUBSCRIPTION_MESSAGE = "In order to sign-up for the newsletter, " +
			"please read Terms & Conditions and Privacy Notice and check the box in order " +
			"to accept them. You can unsubscribe at any time.";

	public By termsAndConditionsLabel = By.xpath("//label[@for='terms_input']");
	public By termsAndConditionsCheckBox = By.xpath("//*[@id='terms_input']");
	public By suggestion = By.id("suggestion");
	public By signMeUpForNewsletterCheckBox = By.xpath("//*[@id='newsletter_input']");
	public By signMeUpForNewsletterLabel = By.xpath("//label[@for='newsletter_input']");
	public By promptMessage = By.id("prompt_message2");

	public FooterBasePage(WebDriver driver) {
		super(driver);
	}

	public void clickOnSignMeUpForNewsletterLabel() {
		WebDriverUtil.clickOnElement(driver, signMeUpForNewsletterLabel);
	}

	public void assertSubscriptionMessage() {
		Assert.assertEquals(WebDriverUtil.findElement(driver, promptMessage).getText(), SUBSCRIPTION_MESSAGE);
	}

	public void clickOnTermsAndConditionsCheckbox() {
		// Click on checkbox does not work, need to use label with offset to avoid the link in the test
		Actions builder = new Actions(driver);
		builder.moveToElement(WebDriverUtil.findElement(driver, termsAndConditionsLabel), 50, 0).click().build().perform();
	}

	public void assertNewsletterSuggestionLabel() {
		Assert.assertEquals(WebDriverUtil.findElement(driver, suggestion).getText(), NEWSLETTER_SUGGESTION);
	}
}
