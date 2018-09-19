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

import com.endava.pages.DigitalPage;
import com.endava.pages.HomePage;
import com.endava.pages.MenuPage;

import io.github.bonigarcia.wdm.WebDriverManager;

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
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		WebDriverManager.iedriver().setup();
	}

	@Test
	@Parameters({ "browser" })
	public void testDigitalPageIsOpened(String browser) {
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
		digitalPage = menuPage.openDigitalPage();

		digitalPage.isActive();
	}

	@AfterMethod
	public void tearDown() {
		homePage.quit();
	}
}
