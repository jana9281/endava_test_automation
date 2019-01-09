package com.endava;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.endava.pages.CloudPage;
import com.endava.pages.HomePage;
import com.endava.util.WebDriverWrapper;

/**
 * 1) Go to endava.com 2) Scroll down to the page footer and from the "Services"
 * section click on "Cloud" 3) Validate URL has changed 4) Scroll down to the
 * "Contact us" area 5) Tick "I agree to the Terms and Conditions and Privacy
 * Notice" check box 6) Validate that check box is ticked 7) Validate that
 * "Please make our day by signing up for our newsletter." message appears on a
 * screen above the Terms of use
 */
public class TestCloudPage {

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

	@Test
	public void testTermsAndPrivacyCheckBoxValidation() {
		cloudPage = homePage.openCloudPage();
		cloudPage.assertUrlEndsWith("Cloud");
		cloudPage.clickOnTermsAndConditionsCheckbox();
		cloudPage.assertElementIsSelected(cloudPage.termsAndConditionsCheckBox);
		cloudPage.assertElementIsDisplayed(cloudPage.suggestion);
		cloudPage.assertNewsletterSuggestionLabel();
	}

	@AfterMethod
	public void tearDown() {
		homePage.quit();
	}

}
