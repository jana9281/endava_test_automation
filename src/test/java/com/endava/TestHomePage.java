package com.endava;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.endava.pages.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author jana.djordjevic@endava.com
 *
 */
public class TestHomePage {

	private WebDriver driver;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
	}

	/*
	 * Test validates that home page is opened by checking if contact buttons are
	 * visible on the page
	 */
	@Test
	public void testHomePageIsOpened() {
		driver = new ChromeDriver();
		HomePage homePage = new HomePage(driver);
		homePage.open();
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(homePage.contactButtons));
	}

	@AfterTest
	public void cleanUp() {
		driver.quit();
	}

}
