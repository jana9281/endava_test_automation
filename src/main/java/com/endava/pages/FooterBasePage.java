package com.endava.pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.endava.util.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class FooterBasePage extends BasePage {

	private static final Logger logger = LoggerFactory.getLogger(FooterBasePage.class);

	public static String NEWSLETTER_SUGGESTION = "Please make our day by signing up for our newsletter.";
	public static String SUBSCRIPTION_MESSAGE = "In order to sign-up for the newsletter, " +
			"please read Terms & Conditions and Privacy Notice and check the box in order " +
			"to accept them. You can unsubscribe at any time.";
	public static String WARNING_MESSAGE_LAST_NAME = "Please enter Last Name";

	public By firstNameField = By.id("firstname");
	public By lastNameField = By.id("lastname");
	public By contactUsButton = By.id("form-submit");
	public By warningMessageLastName = By.xpath("//*[@id='lastname']/following-sibling::div/p");
	public By warningMessagePhoneNumber = By.xpath("//*[@id='phoneNumber']/following-sibling::div/p");
	public By contactUsTitle = By.xpath("//h2[text()='Contact us']");
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
		logger.info("Clicking on Sign me Up For Newsletter label to check the checkbox");
		WebDriverUtil.clickOnElement(driver, signMeUpForNewsletterLabel);
	}

	public void assertSubscriptionMessage() {
		logger.info("Asserting Subscription message label is {}", SUBSCRIPTION_MESSAGE);
		Assert.assertEquals(WebDriverUtil.getElementText(driver, promptMessage), SUBSCRIPTION_MESSAGE);
	}

	public void clickOnTermsAndConditionsCheckbox() {
		logger.info("Clicking on Terms and Conditions checkbox");
		// Click on checkbox does not work, need to use label with offset to avoid the link in the test
		Actions builder = new Actions(driver);
		builder.moveToElement(WebDriverUtil.findElement(driver, termsAndConditionsLabel), 50, 0).click().build().perform();
	}

	public void assertNewsletterSuggestionLabel() {
		logger.info("Asserting Newsletter suggesion label is {}", NEWSLETTER_SUGGESTION);
		Assert.assertEquals(WebDriverUtil.getElementText(driver, suggestion), NEWSLETTER_SUGGESTION);
	}

    public void enterFirstName(String firstName) {
		logger.info("Entering {} as first name", firstName);
		WebDriverUtil.populateField(driver, firstNameField, firstName);
    }

	public void enterLastName(String lastName) {
		logger.info("Entering {} as last name", lastName);
		WebDriverUtil.populateField(driver, lastNameField, lastName);
	}

	public void clearLastName() {
		logger.info("Clearing last name field");
		WebDriverUtil.clearField(driver, lastNameField);
	}

	public void validateFirstName(String firstName) {
		logger.info("Asserting first name field contains {}", firstName);
		Assert.assertEquals(WebDriverUtil.getElementAttributeValue(driver, firstNameField), firstName);
	}

	public void clickOnCotactUsButton() {
		logger.info("Clicking on Contact Us button");
		WebDriverUtil.clickOnElement(driver, contactUsButton);
	}

	public void assertLastNameWarningMassageIsShown() {
		logger.info("Asserting warning message {} is shown", WARNING_MESSAGE_LAST_NAME);
		Assert.assertTrue(WebDriverUtil.isElementPresent(driver, warningMessageLastName));
		Assert.assertEquals(WebDriverUtil.findElement(driver, warningMessageLastName).getText(), WARNING_MESSAGE_LAST_NAME);
	}

	public void assertPhoneWarningMassageNotShown() {
		logger.info("Asserting warning message for phone number is not shown");
		Assert.assertFalse(WebDriverUtil.isElementPresent(driver, warningMessagePhoneNumber));
	}
}
