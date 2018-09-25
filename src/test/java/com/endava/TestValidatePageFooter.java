package com.endava;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.endava.pages.AboutPage;
import com.endava.pages.AgilePage;
import com.endava.pages.AutomationPage;
import com.endava.pages.CareersPage;
import com.endava.pages.ContactPage;
import com.endava.pages.DigitalPage;
import com.endava.pages.HomePage;
import com.endava.pages.IndustriesPage;
import com.endava.pages.InvestorsPage;
import com.endava.pages.MenuPage;
import com.endava.pages.ServicesPage;
import com.endava.pages.SuccessStoriesPage;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Denis.Selimovski
 *
 */
public class TestValidatePageFooter {

	private HomePage homePage;
	private MenuPage menuPage;
	private DigitalPage digitalPage;
	private AgilePage agilePage;
	private AutomationPage automationPage;
	private ServicesPage servicesPage;
	private InvestorsPage investorsPage;
	private IndustriesPage industriesPage;
	private SuccessStoriesPage successStoriesPage;
	private AboutPage aboutPage;
	private CareersPage careersPage;
	private ContactPage contactPage;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
	}

	/**
	 * 1) Go to endava.com 2) Validate page footer is existing 3) Validate three
	 * sections are shown in page footer SERVICES, INDUSTRIES, COMPANY 4) Validate
	 * company logo is shown 5) Navigate through all the pages in burger menu and
	 * validate steps 2,3&4
	 */
	@Test
	public void testValidatePageFooter() {
		homePage = new HomePage(new ChromeDriver());
		homePage.open();
		new WebDriverWait(homePage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(homePage.contactButtons));
		homePage.isElementShown(homePage.footer);
		homePage.isElementShown(homePage.servicesSection);
		homePage.isElementShown(homePage.industriesSection);
		homePage.isElementShown(homePage.companySection);
		homePage.isElementShown(homePage.endavaLogo);
		menuPage = homePage.openMenu();
		new WebDriverWait(menuPage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(menuPage.navigationList));

		digitalPage = menuPage.openDigitalPage();
		digitalPage.isElementShown(digitalPage.footer);
		digitalPage.isElementShown(digitalPage.servicesSection);
		digitalPage.isElementShown(digitalPage.industriesSection);
		digitalPage.isElementShown(digitalPage.companySection);
		digitalPage.isElementShown(digitalPage.endavaLogo);
		menuPage = digitalPage.openMenu();
		new WebDriverWait(menuPage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(menuPage.navigationList));

		agilePage = menuPage.openAgilePage();
		agilePage.isElementShown(agilePage.footer);
		agilePage.isElementShown(agilePage.servicesSection);
		agilePage.isElementShown(agilePage.industriesSection);
		agilePage.isElementShown(agilePage.companySection);
		agilePage.isElementShown(agilePage.endavaLogo);
		menuPage = agilePage.openMenu();
		new WebDriverWait(menuPage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(menuPage.navigationList));

		automationPage = menuPage.openAutomationPage();
		automationPage.isElementShown(automationPage.footer);
		automationPage.isElementShown(automationPage.servicesSection);
		automationPage.isElementShown(automationPage.industriesSection);
		automationPage.isElementShown(automationPage.companySection);
		automationPage.isElementShown(automationPage.endavaLogo);
		menuPage = automationPage.openMenu();
		new WebDriverWait(menuPage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(menuPage.navigationList));

		servicesPage = menuPage.openServices();
		servicesPage.isElementShown(servicesPage.footer);
		servicesPage.isElementShown(servicesPage.servicesSection);
		servicesPage.isElementShown(servicesPage.industriesSection);
		servicesPage.isElementShown(servicesPage.companySection);
		servicesPage.isElementShown(servicesPage.endavaLogo);
		menuPage = servicesPage.openMenu();
		new WebDriverWait(menuPage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(menuPage.navigationList));

		industriesPage = menuPage.openIndustriesPage();
		industriesPage.isElementShown(industriesPage.footer);
		industriesPage.isElementShown(industriesPage.servicesSection);
		industriesPage.isElementShown(industriesPage.industriesSection);
		industriesPage.isElementShown(industriesPage.companySection);
		industriesPage.isElementShown(industriesPage.endavaLogo);
		menuPage = industriesPage.openMenu();
		new WebDriverWait(menuPage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(menuPage.navigationList));

		successStoriesPage = menuPage.openSuccessStories();
		successStoriesPage.isElementShown(successStoriesPage.footer);
		successStoriesPage.isElementShown(successStoriesPage.servicesSection);
		successStoriesPage.isElementShown(successStoriesPage.industriesSection);
		successStoriesPage.isElementShown(successStoriesPage.companySection);
		successStoriesPage.isElementShown(successStoriesPage.endavaLogo);
		menuPage = successStoriesPage.openMenu();
		new WebDriverWait(menuPage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(menuPage.navigationList));

		aboutPage = menuPage.openAboutPage();
		aboutPage.isElementShown(aboutPage.footer);
		aboutPage.isElementShown(aboutPage.servicesSection);
		aboutPage.isElementShown(aboutPage.industriesSection);
		aboutPage.isElementShown(aboutPage.companySection);
		aboutPage.isElementShown(aboutPage.endavaLogo);
		menuPage = aboutPage.openMenu();
		new WebDriverWait(menuPage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(menuPage.navigationList));

		careersPage = menuPage.openCareersPage();
		careersPage.isElementShown(careersPage.footer);
		careersPage.isElementShown(careersPage.servicesSection);
		careersPage.isElementShown(careersPage.industriesSection);
		careersPage.isElementShown(careersPage.companySection);
		careersPage.isElementShown(careersPage.endavaLogo);
		menuPage = careersPage.openMenu();
		new WebDriverWait(menuPage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(menuPage.navigationList));

		menuPage.scrollDownToElement(menuPage.contactItem);
		contactPage = menuPage.openContactPage();
		contactPage.isElementShown(contactPage.footer);
		contactPage.isElementShown(contactPage.servicesSection);
		contactPage.isElementShown(contactPage.industriesSection);
		contactPage.isElementShown(contactPage.companySection);
		contactPage.isElementShown(contactPage.endavaLogo);
		menuPage = contactPage.openMenu();
		new WebDriverWait(menuPage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(menuPage.navigationList));

		investorsPage = menuPage.openInvestorsPage();
		investorsPage.isElementShown(investorsPage.footerInvestors);
		investorsPage.isElementShown(investorsPage.servicesSectionInvestors);
		investorsPage.isElementShown(investorsPage.industriesSectionInvestors);
		investorsPage.isElementShown(investorsPage.companySectionInvestors);
		investorsPage.isElementShown(investorsPage.endavaLogoInvestors);

	}

	@AfterMethod
	public void tearDown() {
		homePage.quit();
	}

}
