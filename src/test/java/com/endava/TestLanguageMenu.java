package com.endava;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.endava.pages.HomePage;
import com.endava.pages.MenuPage;
import com.endava.util.WebDriverUtil;
import com.endava.util.WebDriverWrapper;

public class TestLanguageMenu {
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
	 * Create 2 tests 1.First: Go To endava.com and from the language menu choose
	 * English. Validate that all the Burger Menu options are using English strings.
	 * Second: Go To endava.com and from the language menu choose Deutsch. Validate
	 * that all the Burger Menu options are using German strings. 2.Use
	 * dependsOnMethods test parameter to create dependencies between the tests from
	 * the same class. Second test should depends on first.
	 */

	@Test(priority = 2, dependsOnMethods = { "testOpenDeutsch" })
	public void testOpenEnglish() {
		WebDriverUtil.waitForVisible(homePage.driver, 5, homePage.contactButtons);
		homePage.openLanguageMenu();
		homePage.clickOnElement(homePage.languageMenuEn);
		menuPage = homePage.openMenu();
		WebDriverUtil.waitForVisible(menuPage.driver, 5, menuPage.navigationList);
		menuPage.englishIsShown();
	}

	@Test(priority = 1)
	public void testOpenDeutsch() {
		WebDriverUtil.waitForVisible(homePage.driver, 5, homePage.contactButtons);
		homePage.openLanguageMenu();
		homePage.clickOnElement(homePage.languageMenuDe);
		menuPage = homePage.openMenu();
		WebDriverUtil.waitForVisible(menuPage.driver, 5, menuPage.navigationList);
		menuPage.deutschIsShown();
		menuPage.isOnDeutsch();
	}

	@AfterMethod
	public void tearDown() {
		homePage.quit();
	}

}
