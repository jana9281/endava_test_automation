package com.endava.pages;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * @author Nadezda.Petrovic
 *
 */
public class IndustriesPage extends BasePage {
	private static Log log = LogFactory.getLog(IndustriesPage.class);
	public By finance = By.xpath("//a[text()='Finance']");

	public IndustriesPage(WebDriver driver) {
		super(driver);
	}

	public void checkRead() {
		log.debug("Open method checkRead");
		Assert.assertTrue(driver.findElement(finance).isDisplayed());
	}
}
