package com.endava;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.endava.pages.HomePage;
import com.endava.pages.IndustriesPage;
import com.endava.pages.MenuPage;
import com.endava.util.WebDriverUtil;
import com.endava.util.WebDriverWrapper;

/**
 * @author nadezda.petrovic@endava.com
 *
 */
public class TestIndustriesPage {

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
		WebDriverUtil.waitForVisible(homePage.driver, 5, homePage.contactButtons);
		menuPage = homePage.openMenu();
		WebDriverUtil.waitForVisible(menuPage.driver, 5, menuPage.navigationList);
		industriesPage = menuPage.openIndustriesPage();
		WebDriverUtil.waitForVisible(industriesPage.driver, 5, industriesPage.finance);
		industriesPage.checkRead();
		Assert.assertEquals(industriesPage.getPageTitle(), "Industries");
	}

	@AfterMethod
	public void tearDown() {
		homePage.quit();
	}
}
