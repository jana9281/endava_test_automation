package com.endava;

import com.endava.pages.AutomationAndEngineeringPage;
import com.endava.pages.HomePage;
import com.endava.util.WebDriverWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

public class TestAutomationAndEngineeringPage {

    private static final Logger logger = LoggerFactory.getLogger(TestAutomationAndEngineeringPage.class);

    private HomePage homePage;
    private AutomationAndEngineeringPage automationAndEngineeringPage;

    @BeforeTest
    @Parameters({"browser"})
    public void setUp(String browser) {
        WebDriverWrapper.setUpDriver(browser);
    }

    @BeforeMethod
    @Parameters({"browser"})
    public void openBrowser(String browser) {
        homePage = new HomePage(WebDriverWrapper.createDriver(browser));
        homePage.open();
    }

    /**
     * Go to endava.com. Scroll down to the page footer and from the "Services",
     * section click on "Test Automation & Engineering". Validate URL has changed.
     * Scroll down to the "Contact us" area. Populate first name, last name, email, county,
     * Validate first name, last name, email country. Tick "Sign me up for the Endava, newsletter" check box,
     * Tick "I agree to the Terms and Conditions and Privacy Notice" check box. Validate that "I agree to the Terms and Conditions and Privacy Notice" is checked,
     * Submit.
     */

    @Test
    public void testNewsletterCheckBoxValidation() {
        logger.info("Test testNewsletterCheckBoxValidation start");

        automationAndEngineeringPage = homePage.openAutomationAndEngineeringPage();
        automationAndEngineeringPage.assertUrlEndsWith("Test-Automation-And-Engineering");
        automationAndEngineeringPage.clickOnTypeOfMessage();
        automationAndEngineeringPage.enterFirstName("Indira");
        automationAndEngineeringPage.enterLastName("Gandhi");
        automationAndEngineeringPage.enterEmail("indira.gandhi@delhi.com");
        automationAndEngineeringPage.enterCountry("India");
        automationAndEngineeringPage.validateFirstName("Indira");
        automationAndEngineeringPage.validateLastName("Gandhi");
        automationAndEngineeringPage.validateEmail("indira.gandhi@delhi.com");
        automationAndEngineeringPage.validateCountry("India");
        automationAndEngineeringPage.clickOnCotactUsButton();
        automationAndEngineeringPage.assertTermsAndConditionsWarningMessageIsShown();
        automationAndEngineeringPage.clickOnTermsAndConditionsCheckbox();
        automationAndEngineeringPage.clickOnSignMeUpForNewsletterLabel();
        automationAndEngineeringPage.clickOnCotactUsButton();
        automationAndEngineeringPage.assertSuccessSendMessage();

        logger.info("Test testNewsletterCheckBoxValidation end");
    }

    @AfterMethod
    public void tearDown() {
        homePage.quit();
    }
}
