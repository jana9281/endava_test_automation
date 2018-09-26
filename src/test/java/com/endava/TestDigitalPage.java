package com.endava;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.endava.pages.DigitalPage;
import com.endava.pages.HomePage;
import com.endava.pages.MenuPage;
import com.endava.util.WebDriverUtil;
import com.endava.util.WebDriverWrapper;

/**
 * @author Aleksandar.Zizovic
 *
 */
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
		WebDriverUtil.waitForVisible(homePage.driver, 5, homePage.contactButtons);
		menuPage = homePage.openMenu();
		WebDriverUtil.waitForVisible(menuPage.driver, 5, menuPage.navigationList);
		digitalPage = menuPage.openDigitalPage();
		digitalPage.isActive();
		Assert.assertEquals(digitalPage.getPageTitle(), "Digital");
	}

	@AfterMethod
	public void tearDown() {
		homePage.quit();
	}
}
