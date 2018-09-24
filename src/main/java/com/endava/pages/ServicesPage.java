package com.endava.pages;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * @author Denis.Selimovski
 *
 */
public class ServicesPage extends BasePage {
	private static Log log = LogFactory.getLog(ServicesPage.class);
	public By strategyMenuOption = By.xpath("//a[text()='Strategy']");

	public ServicesPage(WebDriver driver) {
		super(driver);
	}

	public void strategyIsShown() {
		log.debug("Open method strategyisShown");
		Assert.assertTrue(driver.findElement(strategyMenuOption).isDisplayed());
	}

}
