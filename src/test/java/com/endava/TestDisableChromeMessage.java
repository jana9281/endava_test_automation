package com.endava;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.endava.pages.HomePage;
import com.endava.pages.MenuPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDisableChromeMessage {

	private HomePage homePage;
	private MenuPage menuPage;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
	}

	/*
	 * Find out how you can remove
	 * "Chrome is being controlled by automated test software" message.
	 */
	@Test
	public void testHomePageIsOpened() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		homePage = new HomePage(new ChromeDriver(options));
		homePage.open();
		new WebDriverWait(homePage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(homePage.contactButtons));
	}

	@Test
	public void testOpenMenu() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		homePage = new HomePage(new ChromeDriver(options));
		homePage.open();
		new WebDriverWait(homePage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(homePage.contactButtons));
		menuPage = homePage.openMenu();
		new WebDriverWait(menuPage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(menuPage.navigationList));
	}

	@AfterMethod
	public void tearDown() {
		homePage.quit();
	}

}
