package com.endava;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.endava.pages.CloudPage;
import com.endava.pages.HomePage;
import com.endava.util.WebDriverUtil;
import com.endava.util.WebDriverWrapper;

/**
 * @author nadezda.petrovic@endava.com
 *
 */
public class TestTextFieldFirstLastName {
	private HomePage homePage;
	private CloudPage cloudPage;

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
	 * Test validates that cloud page is opened by validate URL has changed, in
	 * "contact us" area populates first and last name field and validates if both
	 * are correct. validates after click on "contact us" button for all mandatory
	 * fields there is a warning message
	 */

	@Test
	public void testTextFieldFirstLastName() {
		WebDriverUtil.waitForVisible(homePage.driver, 5, homePage.contactButtons);
		homePage.scrollDownAtTheBottomOfThePage();
		cloudPage = homePage.openCloudPage();
		WebDriverUtil.waitForVisible(cloudPage.driver, 5, homePage.cloud);
		cloudPage.isUrlChanged();
		cloudPage.scrollDownToElement(cloudPage.contactUs);
		cloudPage.populateElement(cloudPage.firstName, "Petar");
		cloudPage.populateElement(cloudPage.lastName, "Petrovic");
		cloudPage.isPopulatedElementCorrect(cloudPage.firstName);
		cloudPage.isPopulatedElementCorrect(cloudPage.lastName);
		cloudPage.clickOnElement(cloudPage.contactUs);
		cloudPage.isElementShown(cloudPage.warningMessage1);
		cloudPage.isElementShown(cloudPage.warningMessage2);
		cloudPage.isElementShown(cloudPage.warningMessage3);
	}

	@AfterMethod
	public void tearDown() {
		homePage.quit();
	}

}