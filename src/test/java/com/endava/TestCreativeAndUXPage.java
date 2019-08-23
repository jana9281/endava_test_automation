package com.endava;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.endava.pages.CreativeAndUXPage;
import com.endava.pages.HomePage;
import com.endava.util.WebDriverWrapper;

public class TestCreativeAndUXPage {

    private static final Logger logger = LoggerFactory.getLogger(TestCreativeAndUXPage.class);

    private HomePage homePage;
    private CreativeAndUXPage creativeAndUXPage;

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
     * Go to endava.com. Scroll down to the page footer and from the "Services"
     * section click on "Creative & UX". Validate URL has changed. Scroll down to
     * the "Contact us" area. Populate Country/Region and Email.
	 * Validate Email Address and Country/Region name are correct. Click
     * on "Contact US" button. Validate that for all mandatory fields there is a
     * warning message if it's not populated (e.g. "Please enter First Name").
     */
    @Test
    public void testCreativeAndUXPage1() {
        logger.info("Test testCreativeAndUXPage start");

        creativeAndUXPage = homePage.openCreativeAndUXPage();
        creativeAndUXPage.assertUrlEndsWith("Creative-And-UX");
        creativeAndUXPage.clickOnTypeOfMessage();
        creativeAndUXPage.enterEmail("indira.gandhi@delhi.com");
        creativeAndUXPage.enterCountry("India");
        creativeAndUXPage.validateEmail("indira.gandhi@delhi.com");
        creativeAndUXPage.validateCountry("India");
        creativeAndUXPage.clickOnCotactUsButton();
        creativeAndUXPage.assertFirstNameWarningMessageIsShown();

        logger.info("Test testCreativeAndUXPage end");
    }


	/**
	 * Go to endava.com. Scroll down to the page footer and from the "Services"
	 * section click on "Creative & UX". Validate URL has changed. Scroll down to
	 * the "Contact us" area. Populate First name, Country/Region and Email.
	 * Validate first name, Email Address and Country/Region name are correct. Click
	 * on "Contact US" button. Validate that for all mandatory fields there is a
	 * warning message if it's not populated (e.g. "Please enter Last Name").
	 */
    @Test
    public void testCreativeAndUXPage2() {
        logger.info("Test testCreativeAndUXPage start");

        creativeAndUXPage = homePage.openCreativeAndUXPage();
        creativeAndUXPage.assertUrlEndsWith("Creative-And-UX");
        creativeAndUXPage.clickOnTypeOfMessage();
        creativeAndUXPage.enterEmail("indira.gandhi@delhi.com");
        creativeAndUXPage.enterCountry("India");
        creativeAndUXPage.validateEmail("indira.gandhi@delhi.com");
        creativeAndUXPage.validateCountry("India");
        creativeAndUXPage.enterFirstName("Indira");
        creativeAndUXPage.validateFirstName("Indira");
        creativeAndUXPage.clickOnCotactUsButton();
        creativeAndUXPage.assertLastNameWarningMessageIsShown();

        logger.info("Test testCreativeAndUXPage end");
    }

	/**
	 * Go to endava.com. Scroll down to the page footer and from the "Services"
	 * section click on "Creative & UX". Validate URL has changed. Scroll down to
	 * the "Contact us" area. Populate Last name, Country/Region and Email.
	 * Validate last name, Email Address and Country/Region name are correct. Click
	 * on "Contact US" button. Validate that for all mandatory fields there is a
	 * warning message if it's not populated (e.g. "Please enter First Name").
	 */
    @Test
    public void testCreativeAndUXPage3() {
        logger.info("Test testCreativeAndUXPage start");

        creativeAndUXPage = homePage.openCreativeAndUXPage();
        creativeAndUXPage.assertUrlEndsWith("Creative-And-UX");
        creativeAndUXPage.clickOnTypeOfMessage();
        creativeAndUXPage.enterEmail("indira.gandhi@delhi.com");
        creativeAndUXPage.enterCountry("India");
        creativeAndUXPage.validateEmail("indira.gandhi@delhi.com");
        creativeAndUXPage.validateCountry("India");
        creativeAndUXPage.enterLastName("Gandhi");
        creativeAndUXPage.validateLastName("Gandhi");
        creativeAndUXPage.clickOnCotactUsButton();
        creativeAndUXPage.assertFirstNameWarningMessageIsShown();
        //creativeAndUXPage.assertCompanyMissingWarningMessageIsShown();
        //creativeAndUXPage.assertTermsAndConditionsWarningMessageIsShown();

        logger.info("Test testCreativeAndUXPage end");
    }

	/**
	 * Go to endava.com. Scroll down to the page footer and from the "Services"
	 * section click on "Creative & UX". Validate URL has changed. Scroll down to
	 * the "Contact us" area. Populate First name, last name, Country/Region and Email.
	 * Validate first name, last name, Email Address and Country/Region name are correct. Click
	 * on "Contact US" button. Validate that for all mandatory fields there is a
	 * warning message if it's not populated (e.g. Terms and Conditions check box).
	 */
    @Test
    public void testCreativeAndUXPage4() {
        logger.info("Test testCreativeAndUXPage start");

        creativeAndUXPage = homePage.openCreativeAndUXPage();
        creativeAndUXPage.assertUrlEndsWith("Creative-And-UX");
        creativeAndUXPage.clickOnTypeOfMessage();
        creativeAndUXPage.enterEmail("indira.gandhi@delhi.com");
        creativeAndUXPage.enterCountry("India");
        creativeAndUXPage.validateEmail("indira.gandhi@delhi.com");
        creativeAndUXPage.validateCountry("India");
        creativeAndUXPage.enterFirstName("Indira");
        creativeAndUXPage.validateFirstName("Indira");
        creativeAndUXPage.enterLastName("Gandhi");
        creativeAndUXPage.validateLastName("Gandhi");
        creativeAndUXPage.clickOnCotactUsButton();
        creativeAndUXPage.assertTermsAndConditionsWarningMessageIsShown();

        logger.info("Test testCreativeAndUXPage end");
    }

	/**
	 * Go to endava.com. Scroll down to the page footer and from the "Services"
	 * section click on "Creative & UX". Validate URL has changed. Scroll down to
	 * the "Contact us" area. Populate First name, last name, Country/Region and Email.
	 * Validate first name, last name, Email Address and Country/Region name are correct. Click
	 * on "Contact US" button. Validate that for all mandatory fields there is a
	 * warning message if it's not populated, if it's populated send message.
	 * */
    @Test
    public void testCreativeAndUXPage5() {
        logger.info("Test testCreativeAndUXPage start");

        creativeAndUXPage = homePage.openCreativeAndUXPage();
        creativeAndUXPage.assertUrlEndsWith("Creative-And-UX");
        creativeAndUXPage.clickOnTypeOfMessage();
        creativeAndUXPage.enterEmail("indira.gandhi@delhi.com");
        creativeAndUXPage.enterCountry("India");
        creativeAndUXPage.validateEmail("indira.gandhi@delhi.com");
        creativeAndUXPage.validateCountry("India");
        creativeAndUXPage.enterFirstName("Indira");
        creativeAndUXPage.validateFirstName("Indira");
        creativeAndUXPage.enterLastName("Gandhi");
        creativeAndUXPage.validateLastName("Gandhi");
        creativeAndUXPage.clickOnTermsAndConditionsCheckbox();
        creativeAndUXPage.clickOnCotactUsButton();

        logger.info("Test testCreativeAndUXPage end");
    }


    @AfterMethod
    public void tearDown() {
        homePage.quit();
    }
}
