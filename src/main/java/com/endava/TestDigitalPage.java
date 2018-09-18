package com.endava;

import org.testng.annotations.Test;

import com.endava.pages.DigitalPage;
import com.endava.pages.HomePage;
import com.endava.pages.MenuPage;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;


public class TestDigitalPage {
	private HomePage homePage;
	private MenuPage menuPage;
	private DigitalPage digitalPage;
	
	 @BeforeTest
	  public void setUp() {
		  WebDriverManager.chromedriver().setup();
	  }

		@Test
		public void testOpenMenu() {
			homePage = new HomePage(new ChromeDriver());
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
			digitalPage.quit();
		}
}
