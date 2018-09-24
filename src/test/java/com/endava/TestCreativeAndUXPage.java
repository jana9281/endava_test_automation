package com.endava;

import org.openqa.selenium.By;
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
	private By ContactUsButton = By.xpath("//*[@id=\"form-submit\"]");

	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeMethod
	public void beforeMethod() {
	}

	/**
	 * Go to endava.com. Scroll down to the page footer and from the "Services"
	 * section click on "Creative & UX". Validate URL has changed. Scroll down to
	 * the "Contact us" area. Populate Email Address field. Populate Country/Region
	 * Name field. Validate Email Address and Country/Region name are correct. Click
	 * on "Contact US" button. Validate that for all mandatory fields there is a
	 * warning message if it's not populated (e.g. "Please enter First Name").
	 */
	@Test
	public void testCreativeAndUXPage() {
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
		creativeAndUXPage.clickOnButton(ContactUsButton);
		creativeAndUXPage.isWarningMessageShown();
	}

	@AfterMethod
	public void tearDown() {
		homePage.quit();
	}

}
