package com.endava;

import com.endava.pages.HomePage;
import com.endava.pages.MenuPage;
import com.endava.util.WebDriverWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

public class TestHomePage {

    private static final Logger logger = LoggerFactory.getLogger(TestHomePage.class);

    private HomePage homePage;
    private MenuPage menuPage;

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

    /*
     * Test validates that home page is opened by checking if contact buttons are
     * visible on the page
     */
    @Test
    public void testHomePageIsOpened() {
        logger.info("Test testHomePageIsOpened start");

        homePage.assertPageTitle("Endava");
        logger.info("Test testHomePageIsOpened end");
    }

    /*
     * Test validates that menu page can be opened from home page
     */
    @Test
    public void testOpenMenu() {
        logger.info("Test testOpenMenu start");

        menuPage = homePage.openMenu();
        menuPage.assertMenuIsOpened();

        logger.info("Test testOpenMenu end");
    }

    @AfterMethod
    public void tearDown() {
        homePage.quit();
    }

}
