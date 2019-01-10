package com.endava;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.endava.pages.DigitalPage;
import com.endava.pages.HomePage;
import com.endava.pages.MenuPage;
import com.endava.util.WebDriverWrapper;

public class TestDigitalPage {
	private HomePage homePage;
	private MenuPage menuPage;
	private DigitalPage digitalPage;

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
	 * Open "burger" menu option, click on "Digital", validate DIGITAL is selected
	 * in DIGITAL - AGILE - AUTOMATION menu options
	 */
	@Test
	public void testDigitalPageIsOpened() {
		menuPage = homePage.openMenu();
		digitalPage = menuPage.openDigitalPage();
		digitalPage.assertPageTitle("Digital");
		digitalPage.assertIsActive();
	}

	@AfterMethod
	public void tearDown() {
		homePage.quit();
	}
}
