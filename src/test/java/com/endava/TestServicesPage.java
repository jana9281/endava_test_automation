package com.endava;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.endava.pages.HomePage;
import com.endava.pages.MenuPage;
import com.endava.pages.ServicesPage;
import com.endava.util.WebDriverUtil;
import com.endava.util.WebDriverWrapper;

/**
 * @author Denis.Selimovski
 *
 */
public class TestServicesPage {

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
		WebDriverUtil.waitForVisible(homePage.driver, 5, homePage.contactButtons);
		menuPage = homePage.openMenu();
		WebDriverUtil.waitForVisible(menuPage.driver, 5, menuPage.navigationList);
		servicesPage = menuPage.openServices();
		WebDriverUtil.isElementShown(servicesPage.driver, servicesPage.strategyMenuOption);
		Assert.assertEquals(servicesPage.getPageTitle(), "Services");
	}

	@AfterMethod
	public void tearDown() {
		homePage.quit();
	}

}
