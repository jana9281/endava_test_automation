package com.endava;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.endava.pages.CreativeAndUXPage;
import com.endava.pages.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCreativeAndUXPage {

	private HomePage homePage;
	private CreativeAndUXPage creativeAndUXPage;

	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeMethod
	public void beforeMethod() {
	}

	@Test
	public void f() {
		homePage = new HomePage(new ChromeDriver());
		homePage.open();
		new WebDriverWait(homePage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(homePage.contactButtons));
		homePage.scrollDownAtTheBottomOfThePage();
		creativeAndUXPage = homePage.openCreativeAndUXPage();
		creativeAndUXPage.isUrlChanged();
		creativeAndUXPage.scrollDownToContactUsArea();
		creativeAndUXPage.populateEmailTextField();
		creativeAndUXPage.populateCountryNameTextField();
		creativeAndUXPage.isEmailValid();
		creativeAndUXPage.isCountryNameValid();
		creativeAndUXPage.clickOnContactUsButton();
		creativeAndUXPage.isThereAWarningMessagge();
	}

	@AfterMethod
	public void tearDown() {
		homePage.quit();
	}

}
