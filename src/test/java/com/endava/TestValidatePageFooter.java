package com.endava;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
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
import com.endava.util.WebDriverUtil;
import com.endava.util.WebDriverWrapper;

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
	@Parameters({ "browser" })
	public void setUp(String browser) {
		WebDriverWrapper.setUpDriver(browser);
	}

	@BeforeMethod
	@Parameters({ "browser" })
	public void openBrowser(String browser) {
		homePage = new HomePage(WebDriverWrapper.createDriver(browser));
		homePage.open();
	}

	/**
	 * 1) Go to endava.com 2) Validate page footer is existing 3) Validate three
	 * sections are shown in page footer SERVICES, INDUSTRIES, COMPANY 4) Validate
	 * company logo is shown 5) Navigate through all the pages in burger menu and
	 * validate steps 2,3&4
	 */
	@Test
	public void testValidatePageFooter() {
		WebDriverUtil.waitForVisible(homePage.driver, 5, homePage.contactButtons);
		homePage.isElementShown(homePage.footer);
		homePage.isElementShown(homePage.servicesSection);
		homePage.isElementShown(homePage.industriesSection);
		homePage.isElementShown(homePage.companySection);
		homePage.isElementShown(homePage.endavaLogo);
		menuPage = homePage.openMenu();
		WebDriverUtil.waitForVisible(menuPage.driver, 5, menuPage.navigationList);

		digitalPage = menuPage.openDigitalPage();
		digitalPage.isElementShown(digitalPage.footer);
		digitalPage.isElementShown(digitalPage.servicesSection);
		digitalPage.isElementShown(digitalPage.industriesSection);
		digitalPage.isElementShown(digitalPage.companySection);
		digitalPage.isElementShown(digitalPage.endavaLogo);
		menuPage = digitalPage.openMenu();
		WebDriverUtil.waitForVisible(menuPage.driver, 5, menuPage.navigationList);

		agilePage = menuPage.openAgilePage();
		agilePage.isElementShown(agilePage.footer);
		agilePage.isElementShown(agilePage.servicesSection);
		agilePage.isElementShown(agilePage.industriesSection);
		agilePage.isElementShown(agilePage.companySection);
		agilePage.isElementShown(agilePage.endavaLogo);
		menuPage = agilePage.openMenu();
		WebDriverUtil.waitForVisible(menuPage.driver, 5, menuPage.navigationList);

		automationPage = menuPage.openAutomationPage();
		automationPage.isElementShown(automationPage.footer);
		automationPage.isElementShown(automationPage.servicesSection);
		automationPage.isElementShown(automationPage.industriesSection);
		automationPage.isElementShown(automationPage.companySection);
		automationPage.isElementShown(automationPage.endavaLogo);
		menuPage = automationPage.openMenu();
		WebDriverUtil.waitForVisible(menuPage.driver, 5, menuPage.navigationList);

		servicesPage = menuPage.openServices();
		servicesPage.isElementShown(servicesPage.footer);
		servicesPage.isElementShown(servicesPage.servicesSection);
		servicesPage.isElementShown(servicesPage.industriesSection);
		servicesPage.isElementShown(servicesPage.companySection);
		servicesPage.isElementShown(servicesPage.endavaLogo);
		menuPage = servicesPage.openMenu();
		WebDriverUtil.waitForVisible(menuPage.driver, 5, menuPage.navigationList);

		industriesPage = menuPage.openIndustriesPage();
		industriesPage.isElementShown(industriesPage.footer);
		industriesPage.isElementShown(industriesPage.servicesSection);
		industriesPage.isElementShown(industriesPage.industriesSection);
		industriesPage.isElementShown(industriesPage.companySection);
		industriesPage.isElementShown(industriesPage.endavaLogo);
		menuPage = industriesPage.openMenu();
		WebDriverUtil.waitForVisible(menuPage.driver, 5, menuPage.navigationList);

		successStoriesPage = menuPage.openSuccessStories();
		successStoriesPage.isElementShown(successStoriesPage.footer);
		successStoriesPage.isElementShown(successStoriesPage.servicesSection);
		successStoriesPage.isElementShown(successStoriesPage.industriesSection);
		successStoriesPage.isElementShown(successStoriesPage.companySection);
		successStoriesPage.isElementShown(successStoriesPage.endavaLogo);
		menuPage = successStoriesPage.openMenu();
		WebDriverUtil.waitForVisible(menuPage.driver, 5, menuPage.navigationList);

		aboutPage = menuPage.openAboutPage();
		aboutPage.isElementShown(aboutPage.footer);
		aboutPage.isElementShown(aboutPage.servicesSection);
		aboutPage.isElementShown(aboutPage.industriesSection);
		aboutPage.isElementShown(aboutPage.companySection);
		aboutPage.isElementShown(aboutPage.endavaLogo);
		menuPage = aboutPage.openMenu();
		WebDriverUtil.waitForVisible(menuPage.driver, 5, menuPage.navigationList);

		careersPage = menuPage.openCareersPage();
		careersPage.isElementShown(careersPage.footer);
		careersPage.isElementShown(careersPage.servicesSection);
		careersPage.isElementShown(careersPage.industriesSection);
		careersPage.isElementShown(careersPage.companySection);
		careersPage.isElementShown(careersPage.endavaLogo);
		menuPage = careersPage.openMenu();
		WebDriverUtil.waitForVisible(menuPage.driver, 5, menuPage.navigationList);

		menuPage.scrollDownToElement(menuPage.contactItem);
		contactPage = menuPage.openContactPage();
		contactPage.isElementShown(contactPage.footer);
		contactPage.isElementShown(contactPage.servicesSection);
		contactPage.isElementShown(contactPage.industriesSection);
		contactPage.isElementShown(contactPage.companySection);
		contactPage.isElementShown(contactPage.endavaLogo);
		menuPage = contactPage.openMenu();
		WebDriverUtil.waitForVisible(menuPage.driver, 5, menuPage.navigationList);

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
