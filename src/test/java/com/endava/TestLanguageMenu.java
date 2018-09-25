package com.endava;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	public By englishLanguageButton = By.xpath("//*[@id=\"langList-box\"]//a[text() = 'English']");
	public By deutschLanguageButton = By.xpath("//*[@id=\"langList-box\"]/ul/li[1]/a");

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
		new WebDriverWait(homePage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(homePage.languageMenu));
		homePage = homePage.openHomePage(this.englishLanguageButton);
		menuPage = homePage.openMenu();
		WebDriverUtil.waitForVisible(menuPage.driver, 5, menuPage.navigationList);
	}

	@Test(priority = 2)
	public void TestDeutschManuPage() {
		WebDriverUtil.waitForVisible(homePage.driver, 5, homePage.languageMenu);
		new WebDriverWait(homePage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(homePage.languageMenu));
		homePage.openHomePage(this.deutschLanguageButton);
		menuPage = homePage.openMenu();
		WebDriverUtil.waitForVisible(menuPage.driver, 5, menuPage.navigationList);
	}

	@AfterMethod
	public void tearDown() {
		homePage.quit();
	}
}
