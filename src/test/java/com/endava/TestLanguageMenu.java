package com.endava;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

public class TestLanguageMenu {

	public HomePage homePage;
	public MenuPage menuPage;

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

	@Test(priority = 1)
	public void TestEnglishManuPage() {
		WebDriverUtil.waitForVisible(homePage.driver, 5, homePage.languageMenu);
		homePage = homePage.openHomePage(homePage.englishLanguageButton);
		menuPage = homePage.openMenu();
		WebDriverUtil.waitForVisible(menuPage.driver, 5, menuPage.navigationList);
		menuPage.isEnglishMenu();
		Assert.assertEquals(menuPage.getPageTitle(), "Endava");
	}

	@Test(priority = 2)
	public void TestDeutschManuPage() {
		WebDriverUtil.waitForVisible(homePage.driver, 5, homePage.languageMenu);
		new WebDriverWait(homePage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(homePage.languageMenu));
		homePage.openHomePage(homePage.deutschLanguageButton);
		menuPage = homePage.openMenu();
		WebDriverUtil.waitForVisible(menuPage.driver, 5, menuPage.navigationList);
		menuPage.isDeutschMenu();
		Assert.assertEquals(menuPage.getPageTitle(), "Endava");
	}

	@AfterMethod
	public void tearDown() {
		homePage.quit();
	}
}
