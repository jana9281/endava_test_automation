package com.endava.pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.endava.util.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BasePage {

    public static final String ENDAVA_URL = "https://www.endava.com";
    private static final Logger logger = LoggerFactory.getLogger(BasePage.class);
    public WebDriver driver;

    public By contactButtons = By.id("contact-buttons");
    public By burgerMenu = By.id("menu-toggle");
    public By automationAndEngineering = By.xpath("//*[@id=\"footer\"]//a[text()='Test Automation & Engineering']");
    public By cloud = By.linkText("Cloud");
    //public By cloud = By.xpath("//*[@id=\"footer\"]//a[text()='Cloud']");
    public By insightsThroughDataLink = By.linkText("Insights through Data");
    public By softwareEngineeringLink = By.linkText("Software Engineering");
    public By creativeAndUXLink = By.linkText("Creative & UX");
    public By footer = By.id("footer");

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void quit() {
        if (this.driver != null) {
            logger.info("Closing browser");
            driver.quit();
        }
    }

    public void assertElementIsSelected(By locator) {
        logger.info("Asserting element {} is selected", locator);
        Assert.assertTrue(WebDriverUtil.findElement(driver, locator).isSelected());
    }

    public void assertElementIsDisplayed(By locator) {
        logger.info("Asserting element {} is displayed", locator);
        Assert.assertTrue(WebDriverUtil.isElementDisplayed(driver, locator));
    }

    public void assertUrlEndsWith(String ending) {
        logger.info("Asserting current URL ends with {}", ending);
        Assert.assertTrue(WebDriverUtil.getCurrentURL(driver).endsWith(ending));
    }

    public void assertPageTitle(String title) {
        logger.info("Asserting page title is {}", title);
        Assert.assertEquals(WebDriverUtil.getPageTitle(driver), title);
    }

    public void assertMenuIsOpened() {
        logger.info("Asserting burger menu is opened");
        Assert.assertTrue(WebDriverUtil.isElementDisplayed(driver, burgerMenu));
    }
}
