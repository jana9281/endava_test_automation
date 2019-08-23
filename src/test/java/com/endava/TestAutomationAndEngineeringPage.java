package com.endava;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.endava.pages.HomePage;
import com.endava.pages.AutomationAndEngineeringPage;
import com.endava.util.WebDriverWrapper;

public class  TestAutomationAndEngineeringPage {

	private static final Logger logger = LoggerFactory.getLogger(TestAutomationAndEngineeringPage.class);

	private HomePage homePage;
	private AutomationAndEngineeringPage automationAndEngineeringPage;

	@BeforeTest
	@Parameters({ "browser" })
	public void setUp(String browser) {
		WebDriverWrapper.setUpDriver(browser);
	}

	@BeforeMethod
	@Parameters({ "browser" })
	public void openBrowser(String browser) {
		homePage = new HomePage(WebDriverWrapper.createDriver(browser));
		homePage.open();
	}

	/**
	 * 1. Go to endava.com ,
	 * 2.Scroll down to the page footer and from the "Services",
	 * section click on "Test Automation & Engineering" ,
	 * 3.Validate URL has changed,
	 * 4.Scroll down to the "Contact us" area ,
	 * 5. Populate first name, last name, email, county,
	 * 6. Validate first name, last name, email country,
	 * 7.Tick "Sign me up for the Endava, newsletter" check box,
	 * 8.Tick "I agree to the Terms and Conditions and Privacy Notice" check box,
	 * 9.Validate that "I agree to the Terms and Conditions and Privacy Notice" is checked,
	 * 10. Submit
	 */
	@Test
	public void testNewsletterCheckBoxValidation() {
		logger.info("Test testNewsletterCheckBoxValidation start");

		automationAndEngineeringPage = homePage.openAutomationAndEngineeringPage();
		automationAndEngineeringPage.assertUrlEndsWith("Test-Automation-And-Engineering");
		automationAndEngineeringPage.clickOnTypeOfMessage();
		automationAndEngineeringPage.enterFirstName("Indira");
		automationAndEngineeringPage.enterLastName("Gandhi");
		automationAndEngineeringPage.enterEmail("indira.gandhi@delhi.com");
		automationAndEngineeringPage.enterCountry("India");
		automationAndEngineeringPage.validateFirstName("Indira");
		automationAndEngineeringPage.validateLastName("Gandhi");
		automationAndEngineeringPage.validateEmail("indira.gandhi@delhi.com");
		automationAndEngineeringPage.validateCountry("India");
		automationAndEngineeringPage.clickOnCotactUsButton();
		automationAndEngineeringPage.assertTermsAndConditionsWarningMessageIsShown();
		automationAndEngineeringPage.clickOnTermsAndConditionsCheckbox();
		automationAndEngineeringPage.clickOnSignMeUpForNewsletterLabel();
		automationAndEngineeringPage.clickOnCotactUsButton();

		logger.info("Test testNewsletterCheckBoxValidation end");
	}

	@AfterMethod
	public void tearDown() {
		homePage.quit();
	}
}
