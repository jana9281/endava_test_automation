package com.endava;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.endava.pages.CloudPage;
import com.endava.pages.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestTextFieldFirstLastName {

	private HomePage homePage;
	private CloudPage cloudPage;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
	}

	/*
	 * Test validates that home page is opened by checking if contact buttons are
	 * visible on the page
	 */

	@Test
	public void testTextFieldFirstLastName() {
		homePage = new HomePage(new ChromeDriver());
		homePage.open();
		new WebDriverWait(homePage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(homePage.contactButtons));
		homePage.scrollDownAtTheBottomOfThePage();
		cloudPage = homePage.openCloudPage();
		cloudPage.isUrlChanged();
		cloudPage.scrollDownToElement(cloudPage.contactUs);
		cloudPage.populateElement(cloudPage.firstName, "Petar");
		cloudPage.populateElement(cloudPage.lastName, "Petrovic");
		cloudPage.isPopulatedElementCorrect(cloudPage.firstName);
		cloudPage.isPopulatedElementCorrect(cloudPage.lastName);
		cloudPage.clickOnElement(cloudPage.contactUs);
		cloudPage.isElementShown(cloudPage.warningMessage1);
		cloudPage.isElementShown(cloudPage.warningMessage2);
		cloudPage.isElementShown(cloudPage.warningMessage3);
	}

	@AfterMethod
	public void tearDown() {
		homePage.quit();
	}

}