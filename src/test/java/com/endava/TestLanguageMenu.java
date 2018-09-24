package com.endava;

import org.openqa.selenium.By;
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

	public HomePage homePage;
	public MenuPage menuPage;
	public By englishLanguageButton = By.xpath("//*[@id=\"langList-box\"]//a[text() = 'English']");
	public By deutschLanguageButton = By.xpath("//*[@id=\"langList-box\"]/ul/li[1]/a");

	@Test
	public void TestEnglishManuPage() {
		HomePage homePage = new HomePage(new ChromeDriver());
		homePage.open();
		new WebDriverWait(homePage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(homePage.languageMenu));
		homePage = homePage.openHomePage(this.englishLanguageButton);
	}

	@Test
	public void TestDeutschManuPage() {
		HomePage homePage = new HomePage(new ChromeDriver());
		homePage.open();
		new WebDriverWait(homePage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(homePage.languageMenu));
		homePage.openHomePage(this.deutschLanguageButton);
	}

	@AfterMethod
	public void tearDown() {
		homePage.quit();
	}

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
	}

}
