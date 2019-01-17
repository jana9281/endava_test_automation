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

	private static final String NEWSLETTER_SUGGESTION = "Please make our day by signing up for our newsletter.";
	private static final String SUBSCRIPTION_MESSAGE = "In order to sign-up for the newsletter, " +
			"please read Terms & Conditions and Privacy Notice and check the box in order " +
			"to accept them. You can unsubscribe at any time.";
	private static final String TERMS_AND_CONDITIONS_MESSAGE = "In order to process your message we need your " +
			"confirmation that you have read and accepted our Terms & Conditions and Privacy Notice.";
	private static final String WARNING_MESSAGE_LAST_NAME = "Please enter Last Name";
	private static final String WARNING_MESSAGE_EMAIL_INCORRECT = "Email address is not correct";
	private static final String WARNING_MESSAGE_EMAIL_MISSING = "Please enter Email Address";
	private static final String WARNING_MESSAGE_COMPANY_MISSING = "Please enter Company";
	private static final String WARNING_MESSAGE_COUNTRY_MISSING = "Please enter Country/Region";

	private By firstNameField = By.id("firstname");
	private By lastNameField = By.id("lastname");
	private By emailAddressField = By.id("email");
	private By contactUsButton = By.id("form-submit");
	private By warningMessageLastName = By.xpath("//*[@id='lastname']/following-sibling::div/p");
	private By warningMessagePhoneNumber = By.xpath("//*[@id='phoneNumber']/following-sibling::div/p");
	private By warningMessageEmail = By.xpath("//*[@id='email']/following-sibling::div/p");
	private By warningMessageCompany = By.xpath("//*[@id='company']/following-sibling::div/p");
	private By warningMessageCountry = By.xpath("//*[@id='countryRegion']/following-sibling::div/p");
	private By warningMessageMessage = By.xpath("//*[@id='message']/following-sibling::div/p");
	private By termsAndConditionsLabel = By.xpath("//label[@for='terms_input']");
	private By termsAndConditionsWarningMessage = By.xpath("//*[@id='prompt_message2']/p");
	public By termsAndConditionsCheckBox = By.xpath("//*[@id='terms_input']");
	public By suggestion = By.id("suggestion");
	public By signMeUpForNewsletterCheckBox = By.xpath("//*[@id='newsletter_input']");
	private By signMeUpForNewsletterLabel = By.xpath("//label[@for='newsletter_input']");
	private By promptMessage = By.id("prompt_message2");

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

	public void validateFirstName(String firstName) {
		logger.info("Asserting first name field contains {}", firstName);
		Assert.assertEquals(WebDriverUtil.getElementAttributeValue(driver, firstNameField), firstName);
	}

	public void enterLastName(String lastName) {
		logger.info("Entering {} as last name", lastName);
		WebDriverUtil.populateField(driver, lastNameField, lastName);
	}

	public void validateLastName(String lastName) {
		logger.info("Asserting last name field contains {}", lastName);
		Assert.assertEquals(WebDriverUtil.getElementAttributeValue(driver, lastNameField), lastName);
	}

	public void clearLastName() {
		logger.info("Clearing last name field");
		WebDriverUtil.clearField(driver, lastNameField);
	}

	public void enterEmail(String email) {
		logger.info("Entering {} as email", email);
		WebDriverUtil.populateField(driver, emailAddressField, email);
	}

	public void validateEmail(String email) {
		logger.info("Asserting email field contains {}", email);
		Assert.assertEquals(WebDriverUtil.getElementAttributeValue(driver, emailAddressField), email);
	}

	public void assertEmailAddressIncorrectWarningMessageIsShown() {
		logger.info("Asserting warning message {} is shown", WARNING_MESSAGE_EMAIL_INCORRECT);
		Assert.assertTrue(WebDriverUtil.isElementPresent(driver, warningMessageEmail));
		Assert.assertEquals(WebDriverUtil.getElementText(driver, warningMessageEmail), WARNING_MESSAGE_EMAIL_INCORRECT);
	}

	public void assertEmailAddressMissingWarningMessageIsShown() {
		logger.info("Asserting warning message {} is shown", WARNING_MESSAGE_EMAIL_MISSING);
		Assert.assertTrue(WebDriverUtil.isElementPresent(driver, warningMessageEmail));
		Assert.assertEquals(WebDriverUtil.getElementText(driver, warningMessageEmail), WARNING_MESSAGE_EMAIL_MISSING);
	}

	public void assertCompanyMissingWarningMessageIsShown() {
		logger.info("Asserting warning message {} is shown", WARNING_MESSAGE_COMPANY_MISSING);
		Assert.assertTrue(WebDriverUtil.isElementPresent(driver, warningMessageCompany));
		Assert.assertEquals(WebDriverUtil.getElementText(driver, warningMessageCompany), WARNING_MESSAGE_COMPANY_MISSING);
	}

	public void assertCountryMissingWarningMessageIsShown() {
		logger.info("Asserting warning message {} is shown", WARNING_MESSAGE_COUNTRY_MISSING);
		Assert.assertTrue(WebDriverUtil.isElementPresent(driver, warningMessageCountry));
		Assert.assertEquals(WebDriverUtil.getElementText(driver, warningMessageCountry), WARNING_MESSAGE_COUNTRY_MISSING);
	}

	public void clickOnCotactUsButton() {
		logger.info("Clicking on Contact Us button");
		WebDriverUtil.clickOnElement(driver, contactUsButton);
	}

	public void assertLastNameWarningMessageIsShown() {
		logger.info("Asserting warning message {} is shown", WARNING_MESSAGE_LAST_NAME);
		Assert.assertTrue(WebDriverUtil.isElementPresent(driver, warningMessageLastName));
		Assert.assertEquals(WebDriverUtil.getElementText(driver, warningMessageLastName), WARNING_MESSAGE_LAST_NAME);
	}

	public void assertPhoneWarningMessageNotShown() {
		logger.info("Asserting warning message for phone number is not shown");
		Assert.assertFalse(WebDriverUtil.isElementPresent(driver, warningMessagePhoneNumber));
	}

	public void assertMessageWarningMessageNotShown() {
		logger.info("Asserting warning message for message is not shown");
		// If warning message is an empty string, treat this as it is not shown
		Assert.assertFalse(WebDriverUtil.isElementPresent(driver, warningMessageMessage) && !WebDriverUtil.getElementText(driver, warningMessageMessage).equals(""));
	}

	public void assertTermsAndConditionsWarningMessageIsShown() {
		logger.info("Asserting warning message {} is shown", TERMS_AND_CONDITIONS_MESSAGE);
		Assert.assertTrue(WebDriverUtil.isElementPresent(driver, termsAndConditionsWarningMessage));
		Assert.assertEquals(WebDriverUtil.getElementText(driver, termsAndConditionsWarningMessage), TERMS_AND_CONDITIONS_MESSAGE);
	}
}
