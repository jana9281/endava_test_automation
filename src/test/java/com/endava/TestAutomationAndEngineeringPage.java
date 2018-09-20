/**
 *1. Go to endava.com
 * 2.Scroll down to the page footer and from the "Services" section click on 
 *   "Test Automation & Engineering"
 * 3.Validate URL has changed
 * 4.Scroll down to the "Contact us" area
 * 5.Tick "Sign me up for the Endava newsletter" check box
 * 6.Validate that check box is ticked
 * 7.Validate that "How about signing up for our newsletter?" message appears on a screen 
 *   under the Terms of use
 */
package com.endava;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.endava.pages.AutomationAndEngineeringPage;
import com.endava.pages.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Radovan.Olujic
 *
 */
public class TestAutomationAndEngineeringPage {
	private HomePage homePage;
	private AutomationAndEngineeringPage automationAndEngineeringPage;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
	}

	@Test
	public void testNewsletterCheckBoxValidation() {
		homePage = new HomePage(new ChromeDriver());
		homePage.open();
		new WebDriverWait(homePage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(homePage.contactButtons));
		homePage.scrollDownAtTheBottomOfThePage();
		homePage.openAutomationAndEngineeringPage();
		automationAndEngineeringPage = homePage.openAutomationAndEngineeringPage();
		automationAndEngineeringPage.isUrlChanged();
		automationAndEngineeringPage.scrollDownToElement();
		automationAndEngineeringPage.tickCheckBox(automationAndEngineeringPage.signMeUpforNewsletterLabel);
		automationAndEngineeringPage.isCheckBoxTicked(automationAndEngineeringPage.signMeUpforNewsletterCheckBox);
		automationAndEngineeringPage.isMessageAppears();

	}

	@AfterMethod
	public void tearDown() {
		homePage.quit();
	}
}
