package com.endava.pages;

import com.endava.util.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IndustriesPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(IndustriesPage.class);

    //Find fix for xpath
    public By finance = By.xpath("//a[text()='Finance']");

	public IndustriesPage(WebDriver driver) {
		super(driver);
	}

	public void assertFinanceIsDisplayed() {
	    logger.info("Validating Finance is displayed");
		Assert.assertTrue(WebDriverUtil.findElement(driver, finance).isDisplayed());
	}
}
