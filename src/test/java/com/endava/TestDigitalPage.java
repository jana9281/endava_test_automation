package com.endava;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.endava.pages.DigitalPage;
import com.endava.pages.HomePage;
import com.endava.pages.MenuPage;
import com.endava.util.DriverWrapper;

/**
 * Open "burger" menu option Click on "Digital" Validate DIGITAL is selected in
 * DIGITAL - AGILE - AUTOMATION menu options
 * 
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
		DriverWrapper.setUpDriver(browser);
//		homePage = new HomePage(DriverWrapper.createDriver(browser));
//		homePage.open();
	}

	@BeforeMethod
	@Parameters({ "browser" })
	public void openBrowser(String browser) {
		homePage = new HomePage(DriverWrapper.createDriver(browser));
		homePage.open();
	}

	@Test
	@Parameters({ "browser" })
	public void testDigitalPageIsOpened(String browser) {
//		if (browser.equalsIgnoreCase("chrome"))
//			homePage = new HomePage(new ChromeDriver());
//		else if (browser.equalsIgnoreCase("firefox"))
//			homePage = new HomePage(new FirefoxDriver());
//		else if (browser.equalsIgnoreCase("ie"))
//			homePage = new HomePage(new InternetExplorerDriver());
		// homePage.open();
		DriverWrapper.waitUntilElementLocated(homePage.driver, 5, homePage.contactButtons);
//		new WebDriverWait(homePage.driver, 5)
//				.until(ExpectedConditions.visibilityOfElementLocated(homePage.contactButtons));
		menuPage = homePage.openMenu();
		DriverWrapper.waitUntilElementLocated(menuPage.driver, 5, menuPage.navigationList);
//		new WebDriverWait(menuPage.driver, 5)
//				.until(ExpectedConditions.visibilityOfElementLocated(menuPage.navigationList));
		digitalPage = menuPage.openDigitalPage();

		digitalPage.isActive();
	}

	@AfterMethod
	public void tearDown() {
		homePage.quit();
	}
}
