package com.endava;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.endava.pages.AutomationAndEngineeringPage;
import com.endava.pages.HomePage;
import com.endava.util.WebDriverUtil;
import com.endava.util.WebDriverWrapper;

/**
 * @author Radovan.Olujic
 *
 */
public class TestAutomationAndEngineeringPage {
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
	 * "How about signing up for our newsletter?" message appears on a screen under
	 * the Terms of use
	 */
	@Test
	public void testNewsletterCheckBoxValidation() {
		WebDriverUtil.waitForVisible(homePage.driver, 5, homePage.contactButtons);
		homePage.scrollDownAtTheBottomOfThePage();
		automationAndEngineeringPage = homePage.openAutomationAndEngineeringPage();
		automationAndEngineeringPage.isUrlChanged();
		automationAndEngineeringPage.scrollToElement(automationAndEngineeringPage.contactUsTitle);
		automationAndEngineeringPage.clickOnElement(automationAndEngineeringPage.signMeUpforNewsletterLabel);
		automationAndEngineeringPage.isElementSelected(automationAndEngineeringPage.signMeUpforNewsletterCheckBox);
		automationAndEngineeringPage.isElementShown(automationAndEngineeringPage.promptMessage);
		Assert.assertEquals(automationAndEngineeringPage.getPageTitle(), "Test Automation & Engineering");
	}

	@AfterMethod
	public void tearDown() {
		homePage.quit();
	}
}
