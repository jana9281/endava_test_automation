package com.endava;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.endava.pages.HomePage;
import com.endava.pages.MenuPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLanguageMenu {
	private HomePage homePage;
	private MenuPage menuPage;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
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
		homePage = new HomePage(new ChromeDriver());
		homePage.open();
		new WebDriverWait(homePage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(homePage.contactButtons));
		homePage.openLanguageMenu();
		homePage.clickOnElement(homePage.languageMenuEn);
		menuPage = homePage.openMenu();
		new WebDriverWait(menuPage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(menuPage.navigationList));
	}

	@Test(priority = 1)
	public void testOpenDeutsch() {
		homePage = new HomePage(new ChromeDriver());
		homePage.open();
		new WebDriverWait(homePage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(homePage.contactButtons));
		homePage.openLanguageMenu();
		homePage.clickOnElement(homePage.languageMenuDe);
		menuPage = homePage.openMenu();
		new WebDriverWait(menuPage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(menuPage.navigationList));
	}

	@AfterMethod
	public void tearDown() {
		homePage.quit();
	}

}
