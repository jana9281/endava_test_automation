package com.endava;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.endava.pages.HomePage;
import com.endava.pages.MenuPage;
import com.endava.util.WebDriverUtil;
import com.endava.util.WebDriverWrapper;

public class TestHomePage {

	private HomePage homePage;
	private MenuPage menuPage;

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
	 * Test validates that home page is opened by checking if contact buttons are
	 * visible on the page
	 */
	@Test
	public void testHomePageIsOpened() {
		WebDriverUtil.waitForVisible(homePage.driver, 5, homePage.contactButtons);
		Assert.assertEquals(homePage.getPageTitle(), "Endava");
	}

	/*
	 * Test validates that menu page can be opened from home page
	 */
	@Test
	public void testOpenMenu() {
		WebDriverUtil.waitForVisible(homePage.driver, 5, homePage.contactButtons);
		menuPage = homePage.openMenu();
		WebDriverUtil.waitForVisible(menuPage.driver, 5, menuPage.navigationList);
		Assert.assertEquals(homePage.getPageTitle(), "Endava");
	}

	@AfterMethod
	public void tearDown() {
		homePage.quit();
	}

}
