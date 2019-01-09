package com.endava;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.endava.pages.HomePage;
import com.endava.pages.MenuPage;
import com.endava.pages.SuccessStoriesPage;
import com.endava.util.WebDriverUtil;
import com.endava.util.WebDriverWrapper;

public class TestSuccessStoriesPage {
	private HomePage homePage;
	private MenuPage menuPage;
	private SuccessStoriesPage succesStoriesPage;

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
	 * Open "burger" menu option Click on "Success stories" Validate there is
	 * "Success Story | Retail and Consumer Goods"
	 */
	@Test
	public void testSuccessStoriesPage() {
		WebDriverUtil.waitForVisible(homePage.driver, 5, homePage.contactButtons);
		menuPage = homePage.openMenu();
		WebDriverUtil.waitForVisible(menuPage.driver, 5, menuPage.navigationList);
		succesStoriesPage = menuPage.openSuccessStories();
		succesStoriesPage.validateSSRCGTitle();
		Assert.assertEquals(succesStoriesPage.getPageTitle(), "Success Stories");
	}

	@AfterMethod
	public void tearDown() {
		homePage.quit();
	}
}
