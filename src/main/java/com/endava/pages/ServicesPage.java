package com.endava.pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.endava.util.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ServicesPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(ServicesPage.class);

	public By strategyMenuOption = By.xpath("//a[text()='Strategy']");

	public ServicesPage(WebDriver driver) {
		super(driver);
	}

	public void assertStrategyIsDisplayed() {
	    logger.info("Validating Strategy menu option is displayed");
		Assert.assertTrue(WebDriverUtil.isElementDisplayed(driver, strategyMenuOption));
	}
}
