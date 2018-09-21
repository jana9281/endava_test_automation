package com.endava;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.endava.pages.HomePage;
import com.endava.pages.IndustriesPage;
import com.endava.pages.MenuPage;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author jana.djordjevic@endava.com
 *
 */
public class TestIndustriesPage {

	private HomePage homePage;
	private MenuPage menuPage;
	private IndustriesPage industriesPage;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
	}
	
	@Test
	public void testHomePageIsOpened() {
		homePage = new HomePage(new ChromeDriver());
		homePage.open();
		new WebDriverWait(homePage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(homePage.contactButtons));
	}

	@Test
	public void testOpenIndustriesPage() {
		homePage = new HomePage(new ChromeDriver());

		homePage.open();
		new WebDriverWait(homePage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(homePage.contactButtons));
		menuPage = homePage.openMenu();
		new WebDriverWait(menuPage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(menuPage.navigationList));
		industriesPage = menuPage.openIndustriesPage();
		new WebDriverWait(industriesPage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(industriesPage.finance));
		industriesPage.checkRead();
	}

	@AfterMethod
	public void tearDown() {
		homePage.quit();
	}

}
