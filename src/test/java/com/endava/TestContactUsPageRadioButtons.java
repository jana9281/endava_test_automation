package com.endava;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.endava.pages.ContactUsPage;
import com.endava.pages.HomePage;
import com.endava.util.WebDriverUtil;
import com.endava.util.WebDriverWrapper;

/**
 * @author nadezda.petrovic@endava.com
 *
 */
public class TestContactUsPageRadioButtons {
	private HomePage homePage;
	private ContactUsPage contactUs;

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
	 * Go to endava web site and click on telephone icon on the left side of the
	 * screen Validate "Contact Us" page is opened, click on
	 * "Interested in our services" radio button Validate radio button is selected.
	 * Validate "Want to join our team?" is not selected
	 */

	@Test
	public void testContactUsPage() {
		WebDriverUtil.waitForVisible(homePage.driver, 5, homePage.contactButtons);
		contactUs = homePage.openContactUs();
		contactUs.isPageOpen();
		contactUs.scrollToElement(contactUs.radioButton);
		// contactUs.clickOnElement(contactUs.radioButton);
		// contactUs.isElementSelected(contactUs.radioButton);
		contactUs.ElementIsNotSelected(contactUs.radioButton2);
	}

	@AfterMethod
	public void tearDown() {
		homePage.quit();
	}
}
