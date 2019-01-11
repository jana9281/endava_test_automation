package com.endava;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.endava.pages.HomePage;
import com.endava.pages.IndustriesPage;
import com.endava.pages.MenuPage;
import com.endava.util.WebDriverWrapper;

public class TestIndustriesPage {

	private static final Logger logger = LoggerFactory.getLogger(TestIndustriesPage.class);

	private HomePage homePage;
	private MenuPage menuPage;
	private IndustriesPage industriesPage;

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
	 * Open "burger" menu option and click on "Industries", Validate FINANCE section
	 * is shown with "Read More" link
	 */
	@Test
	public void testOpenIndustriesPage() {
		logger.info("Test testOpenIndustriesPage start");

		menuPage = homePage.openMenu();
		industriesPage = menuPage.openIndustriesPage();
		industriesPage.assertPageTitle("Industries");
		industriesPage.assertFinanceIsDisplayed();

		logger.info("Test testOpenIndustriesPage end");
	}

	@AfterMethod
	public void tearDown() {
		homePage.quit();
	}
}
