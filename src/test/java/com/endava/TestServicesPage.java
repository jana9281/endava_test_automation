package com.endava;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.endava.pages.HomePage;
import com.endava.pages.MenuPage;
import com.endava.pages.ServicesPage;
import com.endava.util.WebDriverWrapper;

public class TestServicesPage {

	private static final Logger logger = LoggerFactory.getLogger(TestServicesPage.class);

	private HomePage homePage;
	private MenuPage menuPage;
	private ServicesPage servicesPage;

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
	 * Open "burger" menu option Click on "Services" Validate STRATEGY menu option
	 * is shown
	 */
	@Test
	public void testStrategyMenuIsShown() {
		logger.info("Test testStrategyMenuIsShown start");

		menuPage = homePage.openMenu();
		servicesPage = menuPage.openServices();
		servicesPage.assertPageTitle("Services");
		servicesPage.assertStrategyIsDisplayed();

		logger.info("Test testStrategyMenuIsShown end");
	}

	@AfterMethod
	public void tearDown() {
		homePage.quit();
	}
}
