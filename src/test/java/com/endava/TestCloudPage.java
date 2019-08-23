package com.endava;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.endava.pages.CloudPage;
import com.endava.pages.HomePage;
import com.endava.util.WebDriverWrapper;

public class TestCloudPage {

    private static final Logger logger = LoggerFactory.getLogger(TestCloudPage.class);

    private HomePage homePage;
    private CloudPage cloudPage;

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

    @Test
    public void testPageTitle() {
        cloudPage = homePage.openCloudPage();
        cloudPage.assertPageTitle("Cloud");
    }

    /**
     * 1) Go to endava.com 2) Scroll down to the page footer and from the "Services"
     * section click on "Cloud" 3) Validate URL has changed 4) Scroll down to the
     * "Contact us" area 5) Tick "I agree to the Terms and Conditions and Privacy
     * Ncheck bootice" check box.
     */
    @Test
    public void testTermsAndPrivacyCheckBoxValidation() {
        logger.info("Test testTermsAndPrivacyCheckBoxValidation start");

        cloudPage = homePage.openCloudPage();
        cloudPage.assertUrlEndsWith("Cloud");
        cloudPage.clickOnTypeOfMessage();
        cloudPage.clickOnTermsAndConditionsCheckbox();

        logger.info("Test testTermsAndPrivacyCheckBoxValidation end");
    }

    /**
     * Go to endava.com
     * Scroll down to the page footer and from the "Services" section click on "Cloud"
     * Validate URL has changed
     * Scroll down to the "Contact us" area
     * Populate First Name field
     * Populate Second Name field
     * Validate First and Last name are correct
     * Click on "Contact US" button
     * Validate that for all mandatory fields there is a warning message if it's not populated (e.g. "Please enter Email Address")
     */

    @Test
    public void testMandatoryFieldsFormValidation() {
        logger.info("Test testTextFieldFirstLastName start");

        cloudPage = homePage.openCloudPage();
        cloudPage.assertUrlEndsWith("Cloud");
        cloudPage.clickOnTypeOfMessage();
        cloudPage.enterFirstName("Harper");
        cloudPage.enterLastName("Lee");
        cloudPage.validateFirstName("Harper");
        cloudPage.validateLastName("Lee");
        cloudPage.clickOnCotactUsButton();
        cloudPage.assertEmailAddressMissingWarningMessageIsShown();

        logger.info("Test testTextFieldFirstLastName end");
    }

    @AfterMethod
    public void tearDown() {
        homePage.quit();
    }
}
