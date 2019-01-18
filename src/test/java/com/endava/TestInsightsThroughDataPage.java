package com.endava;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.endava.pages.HomePage;
import com.endava.pages.InsightsThroughDataPage;
import com.endava.util.WebDriverWrapper;

public class TestInsightsThroughDataPage {

	private static final Logger logger = LoggerFactory.getLogger(TestInsightsThroughDataPage.class);

	private HomePage homePage;
	private InsightsThroughDataPage insightsThroughDataPage;

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

	/*
	 * 1. Go to endava.com 2. Scroll down to the page footer and from the "Services"
	 * section click on "Insights through Data" 3. Validate URL has changed 4.
	 * Scroll down to the "Contact us" area 5. Populate First Name Field 6. Populate
	 * Last Name Field 7. Delete Last Name 8. Validate that First Name is Correct 9.
	 * Click on "Contact US" button 9. Validate there is a warning message
	 * "Please enter Last Name" - mandatory field 10. Validate there is no warning
	 * message "Please enter Phone Number" - non mandatory field
	 */

	@Test
	public void testValidateNonMandatoryFields() {
		logger.info("Test testValidateNonMandatoryFields start");

		insightsThroughDataPage = homePage.openInsightsThroughDataPage();
		insightsThroughDataPage.assertPageTitle("Insights through Data");
		insightsThroughDataPage.enterFirstName("Ernest");
		insightsThroughDataPage.enterLastName("Hemingway");
		insightsThroughDataPage.clearLastName();
		insightsThroughDataPage.validateFirstName("Ernest");
		insightsThroughDataPage.clickOnCotactUsButton();
        insightsThroughDataPage.assertLastNameWarningMessageIsShown();
		insightsThroughDataPage.assertPhoneWarningMessageNotShown();

		logger.info("Test testValidateNonMandatoryFields end");
	}

	@AfterMethod
	public void tearDown() {
		homePage.quit();
	}
}
