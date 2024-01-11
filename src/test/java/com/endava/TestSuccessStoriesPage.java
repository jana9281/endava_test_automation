package com.endava;

import com.endava.pages.HomePage;
import com.endava.pages.MenuPage;
import com.endava.pages.SuccessStoriesPage;
import com.endava.util.WebDriverWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

public class TestSuccessStoriesPage {

    private static final Logger logger = LoggerFactory.getLogger(TestSuccessStoriesPage.class);

    private HomePage homePage;
    private MenuPage menuPage;
    private SuccessStoriesPage succesStoriesPage;

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
     * Open "burger" menu option Click on "Success stories" Validate there is
     * "Success Story | Retail and Consumer Goods"
     */

    @Test
    public void testSuccessStoriesPage() {
        logger.info("Test testSuccessStoriesPage start");

        menuPage = homePage.openMenu();
        succesStoriesPage = menuPage.openSuccessStories();
        succesStoriesPage.validateSSRCGTitle();
        succesStoriesPage.assertPageTitle("Success Stories");

        logger.info("Test testSuccessStoriesPage end");
    }

    @AfterMethod
    public void tearDown() {
        homePage.quit();
    }
}
