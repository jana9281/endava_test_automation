package com.endava;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.endava.pages.HomePage;
import com.endava.pages.SoftwareEngineeringPage;
import com.endava.util.WebDriverWrapper;

public class TestSoftwareEngineeringPage {

	private static final Logger logger = LoggerFactory.getLogger(TestSoftwareEngineeringPage.class);

	private HomePage homePage;
	private SoftwareEngineeringPage softwareEngineeringPage;

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
	 * 1) Go to endava.com 2) Scroll down to the page footer and from the "Services"
	 * section click on "Software Engineering" 3) Validate URL has changed 4) Scroll
	 * down to the "Contact us" area 5) Populate incorrect Email Address (e.g.
	 * "invalidemail") 6) Validate that Email Address field is populated with the
	 * incorrect email address 7) Click on "Contact US" button 8) Validate there is
	 * a warning message "Email address is not correct" under the Email Address text
	 * field
	 */
	@Test
	public void testEnterIncorrectEmail() {
		logger.info("Test testEnterIncorrectEmail start");

		softwareEngineeringPage = homePage.openSoftwareEngineeringPage();
		softwareEngineeringPage.assertUrlEndsWith("Software-Engineering");
		softwareEngineeringPage.enterEmail("invalidemail");
		softwareEngineeringPage.validateEmail("invalidemail");
		softwareEngineeringPage.clickOnCotactUsButton();
		softwareEngineeringPage.assertEmailAddressIncorrectWarningMessageIsShown();

		logger.info("Test testEnterIncorrectEmail end");
	}

	@AfterMethod
	public void tearDown() {
		homePage.quit();
	}
}
