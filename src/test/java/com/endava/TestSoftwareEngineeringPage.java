package com.endava;

import com.endava.pages.HomePage;
import com.endava.pages.SoftwareEngineeringPage;
import com.endava.util.WebDriverWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

public class TestSoftwareEngineeringPage {

    private static final Logger logger = LoggerFactory.getLogger(TestSoftwareEngineeringPage.class);

    private HomePage homePage;
    private SoftwareEngineeringPage softwareEngineeringPage;

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
     * section click on "Software Engineering", Validate URL has changed, Scroll
     * down to the "Contact us" area, Populate incorrect Email Address (e.g.
     * "invalidemail"), Validate that Email Address field is populated with the
     * incorrect email address, Click on "Contact US" button, Validate there is
     * a warning message "Email address is not correct" under the Email Address text field
     */
    @Test
    public void testEnterIncorrectEmail() {
        logger.info("Test testEnterIncorrectEmail start");

        softwareEngineeringPage = homePage.openSoftwareEngineeringPage();
        softwareEngineeringPage.assertUrlEndsWith("Software-Engineering");
        softwareEngineeringPage.clickOnTypeOfMessage();
        softwareEngineeringPage.enterFirstName("Indira");
        softwareEngineeringPage.validateFirstName("Indira");
        softwareEngineeringPage.enterLastName("Gandhi");
        softwareEngineeringPage.validateLastName("Gandhi");
        softwareEngineeringPage.enterEmail("invalidemail");
        softwareEngineeringPage.validateEmail("invalidemail");
        softwareEngineeringPage.clickOnCotactUsButton();
        softwareEngineeringPage.assertEmailAddressIncorrectWarningMessageIsShown();

        logger.info("Test testEnterIncorrectEmail end");
    }

    @AfterMethod
    public void tearDown() {
        homePage.quit();
    }
}
