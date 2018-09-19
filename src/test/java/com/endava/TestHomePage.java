package com.endava;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.endava.pages.HomePage;
import com.endava.pages.MenuPage;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author jana.djordjevic@endava.com
 *
 */
public class TestHomePage {

	private HomePage homePage;
	private MenuPage menuPage;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		WebDriverManager.iedriver().setup();
	}

	/*
	 * Test validates that home page is opened by checking if contact buttons are
	 * visible on the page
	 */
	@Test
	@Parameters({ "browser" })
	public void testHomePageIsOpened(String browser) {
		if (browser.equalsIgnoreCase("chrome"))
			homePage = new HomePage(new ChromeDriver());
		else if (browser.equalsIgnoreCase("firefox"))
			homePage = new HomePage(new FirefoxDriver());
		else if (browser.equalsIgnoreCase("ie"))
			homePage = new HomePage(new InternetExplorerDriver());
		homePage.open();
		new WebDriverWait(homePage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(homePage.contactButtons));
	}

	@Test
	@Parameters({ "browser" })
	public void testOpenMenu(String browser) {
		if (browser.equalsIgnoreCase("chrome"))
			homePage = new HomePage(new ChromeDriver());
		else if (browser.equalsIgnoreCase("firefox"))
			homePage = new HomePage(new FirefoxDriver());
		else if (browser.equalsIgnoreCase("ie"))
			homePage = new HomePage(new InternetExplorerDriver());
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
