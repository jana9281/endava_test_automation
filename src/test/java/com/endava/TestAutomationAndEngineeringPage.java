package com.endava;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.endava.pages.AutomationAndEngineeringPage;
import com.endava.pages.HomePage;
import com.endava.util.WebDriverWrapper;

public class TestAutomationAndEngineeringPage {

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
	 * 1. Go to endava.com 2.Scroll down to the page footer and from the "Services"
	 * section click on "Test Automation & Engineering" 3.Validate URL has changed
	 * 4.Scroll down to the "Contact us" area 5.Tick "Sign me up for the Endava
	 * newsletter" check box 6.Validate that check box is ticked 7.Validate that
	 * "In order to sign-up for the newsletter, please read Terms & Conditions and
	 * Privacy Notice and check the box in order to accept them. You can unsubscribe
	 * at any time." message appears on a screen under the Terms of use
	 */
	@Test
	public void testNewsletterCheckBoxValidation() {
		logger.info("Test testNewsletterCheckBoxValidation start");

		automationAndEngineeringPage = homePage.openAutomationAndEngineeringPage();
		automationAndEngineeringPage.assertUrlEndsWith("Test-Automation-And-Engineering");
		automationAndEngineeringPage.clickOnSignMeUpForNewsletterLabel();
		automationAndEngineeringPage.assertElementIsSelected(automationAndEngineeringPage.signMeUpForNewsletterCheckBox);
		automationAndEngineeringPage.assertSubscriptionMessage();

		logger.info("Test testNewsletterCheckBoxValidation end");
	}

	@AfterMethod
	public void tearDown() {
		homePage.quit();
	}
}
