package com.endava;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.endava.pages.CreativeAndUXPage;
import com.endava.pages.HomePage;
import com.endava.util.WebDriverWrapper;

public class TestCreativeAndUXPage {

	private static final Logger logger = LoggerFactory.getLogger(TestCreativeAndUXPage.class);

	private HomePage homePage;
	private CreativeAndUXPage creativeAndUXPage;

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
	 * Go to endava.com. Scroll down to the page footer and from the "Services"
	 * section click on "Creative & UX". Validate URL has changed. Scroll down to
	 * the "Contact us" area. Populate Email Address field. Populate Country/Region
	 * Name field. Validate Email Address and Country/Region name are correct. Click
	 * on "Contact US" button. Validate that for all mandatory fields there is a
	 * warning message if it's not populated (e.g. "Please enter First Name").
	 */
	@Test
	public void testCreativeAndUXPage() {
		logger.info("Test testCreativeAndUXPage start");

		creativeAndUXPage = homePage.openCreativeAndUXPage();
		creativeAndUXPage.assertUrlEndsWith("Creative-And-UX");
		creativeAndUXPage.enterEmail("indira.gandhi@delhi.com");
		creativeAndUXPage.enterCountry("India");
		creativeAndUXPage.validateEmail("indira.gandhi@delhi.com");
		creativeAndUXPage.validateCountry("India");
		creativeAndUXPage.clickOnCotactUsButton();
		creativeAndUXPage.assertFirstNameWarningMessageIsShown();
		creativeAndUXPage.assertLastNameWarningMessageIsShown();
		creativeAndUXPage.assertCompanyMissingWarningMessageIsShown();
		creativeAndUXPage.assertTermsAndConditionsWarningMessageIsShown();

		logger.info("Test testCreativeAndUXPage end");
	}

	@AfterMethod
	public void tearDown() {
		homePage.quit();
	}
}
