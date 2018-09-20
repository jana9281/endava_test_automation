/**
 * 
 */
package com.endava.pages;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * @author Denis.Selimovski
 *
 */
public class ServicesPage extends BasePage {
	private static Logger log = Logger.getLogger(MenuPage.class.getName());
	public By strategyMenuOption = By.xpath("//a[text()='Strategy']");

	public ServicesPage(WebDriver driver) {
		super(driver);
	}

	public void strategyIsShown() {
		log.info("*****   open method strategyisShown  ***");
		Assert.assertTrue(driver.findElement(strategyMenuOption).isDisplayed());
	}

}
