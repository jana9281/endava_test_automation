package com.endava.pages;

import com.endava.util.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DigitalPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(DigitalPage.class);
    public By digitalItem = By.xpath("//*[@id='secondary-nav']//a[text()='Digital']/..");

    /**
     * @param driver - WebDriver instance
     */
    protected DigitalPage(WebDriver driver) {
        super(driver);
    }

    public void assertIsActive() {
        logger.info("Asserting Digital is selected.");
        Assert.assertTrue(WebDriverUtil.findElement(driver, digitalItem).getAttribute("class").contains("active"));
    }
}