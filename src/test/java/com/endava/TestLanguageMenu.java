package com.endava;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.endava.pages.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLanguageMenu {
	private HomePage homePage;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
	}

	/*
	 * Test validates that home page is opened by checking if contact buttons are
	 * visible on the page
	 */

	@Test
	public void testOpenEnglish() {
		homePage = new HomePage(new ChromeDriver());
		homePage.open();
		new WebDriverWait(homePage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(homePage.contactButtons));
		homePage.clickOnElement(homePage.languageMenuEn);
		new WebDriverWait(homePage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(homePage.languageMenuEn));
	}
	/*
	 * @Test public void testOpenDeutsch() { homePage = new HomePage(new
	 * ChromeDriver()); homePage.open(); new WebDriverWait(homePage.driver, 5)
	 * .until(ExpectedConditions.visibilityOfElementLocated(homePage.contactButtons)
	 * ); homePage.clickOnElement(homePage.languageMenuEn); new
	 * WebDriverWait(homePage.driver, 5)
	 * .until(ExpectedConditions.visibilityOfElementLocated(homePage.languageMenuEn)
	 * ); }
	 */

	@AfterMethod
	public void tearDown() {
		homePage.quit();
	}

}
