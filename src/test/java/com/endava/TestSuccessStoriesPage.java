/**
 * Open "burger" menu option
 * Click on "Success stories"
 * Validate there is "Success Story | Retail and Consumer Goods"
 */
package com.endava;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.endava.pages.HomePage;
import com.endava.pages.MenuPage;
import com.endava.pages.SuccessStoriesPage;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Radovan.Olujic
 *
 */
public class TestSuccessStoriesPage {
	private HomePage homePage;
	private MenuPage menuPage;
	private SuccessStoriesPage succesStoriesPage;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
	}

	/*
	 * Test validates that home page is opened by checking if contact buttons are
	 * visible on the page
	 */

	@Test
	public void testSuccessStoriesPage() {
		homePage = new HomePage(new ChromeDriver());
		homePage.open();
		new WebDriverWait(homePage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(homePage.contactButtons));
		menuPage = homePage.openMenu();
		new WebDriverWait(menuPage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(menuPage.navigationList));

		succesStoriesPage = menuPage.openSuccessStories();
		new WebDriverWait(succesStoriesPage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(succesStoriesPage.pageTitle));

		succesStoriesPage.findSSRCG();
	}

	@AfterMethod
	public void tearDown() {
		homePage.quit();
	}

}
