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

/**
 * @author Denis.Selimovski
 *
 */

/**
 * 1) Go to endava.com 2) Scroll down to the page footer and from the "Services"
 * section click on "Cloud" 3) Validate URL has changed 4) Scroll down to the
 * "Contact us" area 5) Tick "I agree to the Terms and Conditions and Privacy
 * Notice" check box 6) Validate that check box is ticked 7) Validate that
 * "Please make our day by signing up for our newsletter." message appears on a
 * screen above the Terms of use
 */
public class TestTermsAndPrivacyCheckBoxValidation {

	private HomePage homePage;
	private CloudPage cloudPage;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
	}

	@Test
	public void testTermsAndPrivacyCheckBoxValidation() {
		homePage = new HomePage(new ChromeDriver());
		homePage.open();
		new WebDriverWait(homePage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(homePage.contactButtons));
		homePage.scrollDownAtTheBottomOfThePage();
		cloudPage = homePage.openCloudPage();
		cloudPage.isUrlChanged();
		cloudPage.scrollDownToElement();
		cloudPage.tickCheckBox(cloudPage.termsAndConditionsLabel);
		cloudPage.isCheckBoxTicked(cloudPage.termsAndConditionsCheckBox);
		cloudPage.isSuggestionShown();
	}

	@AfterMethod
	public void tearDown() {
		homePage.quit();
	}

}
