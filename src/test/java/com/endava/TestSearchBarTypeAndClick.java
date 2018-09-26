package com.endava;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.endava.pages.HomePage;
import com.endava.pages.MenuPage;
import com.endava.pages.SearchPage;
import com.endava.util.WebDriverUtil;
import com.endava.util.WebDriverWrapper;

/**
 * @author Denis.Selimovski
 *
 */
public class TestSearchBarTypeAndClick {

	private HomePage homePage;
	private MenuPage menuPage;
	private SearchPage searchPage;

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
	 * 1) Go to endive web site 2) Open Burger menu 3) Scroll to the search bar and
	 * type your name 4) Click on the search icon (magnifying glass) 5) Validate
	 * that there are no results for your search criteria.
	 */
	@Test
	public void testSearchBarTypeAndClick() {
		WebDriverUtil.waitForVisible(homePage.driver, 5, homePage.contactButtons);
		menuPage = homePage.openMenu();
		WebDriverUtil.waitForVisible(menuPage.driver, 5, menuPage.navigationList);
		menuPage.scrollDownToElement(menuPage.searchBar);
		menuPage.populateField(menuPage.searchBar, "Selimovski");
		searchPage = menuPage.openSearchPage();
		searchPage.noResultsValidation();
		Assert.assertEquals(searchPage.getPageTitle(), "Search Results");
	}

	@AfterMethod
	public void tearDown() {
		homePage.quit();
	}

}
