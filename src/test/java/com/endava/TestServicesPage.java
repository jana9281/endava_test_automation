package com.endava;

import java.util.logging.Logger;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.endava.pages.HomePage;
import com.endava.pages.MenuPage;
import com.endava.pages.ServicesPage;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Denis.Selimovski
 *
 */
public class TestServicesPage {

	private HomePage homePage;
	private MenuPage menuPage;
	private ServicesPage servicesPage;
	private static Logger log = Logger.getLogger(TestServicesPage.class.getName());
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
	}

	/**
	 * Open "burger" menu option Click on "Services" Validate STRATEGY menu option
	 * is shown
	 */
	@Test
	public void testStrategyMenuIsShown() {
		log.info("*******************Open Test Strategy Menu***********************");
		
		homePage = new HomePage(new ChromeDriver());
		homePage.open();
		new WebDriverWait(homePage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(homePage.contactButtons));
		menuPage = homePage.openMenu();
		new WebDriverWait(menuPage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(menuPage.navigationList));

		servicesPage = menuPage.openServices();
		servicesPage.strategyIsShown();
		log.info("*******************Close Test Strategy Menu***********************");
	}

	@AfterMethod
	public void tearDown() {
		homePage.quit();
	}

}
