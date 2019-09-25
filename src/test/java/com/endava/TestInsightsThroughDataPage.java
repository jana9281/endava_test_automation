package com.endava;

import com.endava.pages.HomePage;
import com.endava.pages.InsightsThroughDataPage;
import com.endava.util.WebDriverWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

public class TestInsightsThroughDataPage {

    private static final Logger logger = LoggerFactory.getLogger(TestInsightsThroughDataPage.class);

    private HomePage homePage;
    private InsightsThroughDataPage insightsThroughDataPage;

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
     * Go to endava.com, Scroll down to the page footer and from the "Services"
     * section click on "Insights through Data", Validate URL has changed,
     * Scroll down to the "Contact us" area, Populate First Name Field, Populate
     * Last Name Field, Delete Last Name, Validate that First Name is Correct,
     * Click on "Contact US" button, Validate there is a warning message
     * "Please enter Last Name" - mandatory field, Validate there is no warning
     * message "Please enter Phone Number" - non mandatory field
     */


    @Test
    public void testValidateNonMandatoryFields() {
        logger.info("Test testValidateNonMandatoryFields start");

        insightsThroughDataPage = homePage.openInsightsThroughDataPage();
        insightsThroughDataPage.assertPageTitle("Insights through Data");
        insightsThroughDataPage.clickOnTypeOfMessage();
        insightsThroughDataPage.enterFirstName("Ernest");
        insightsThroughDataPage.enterLastName("Hemingway");
        insightsThroughDataPage.clearLastName();
        insightsThroughDataPage.validateFirstName("Ernest");
        insightsThroughDataPage.clickOnCotactUsButton();
        insightsThroughDataPage.assertLastNameWarningMessageIsShown();

        logger.info("Test testValidateNonMandatoryFields end");
    }

    @AfterMethod
    public void tearDown() {
        homePage.quit();
    }
}
