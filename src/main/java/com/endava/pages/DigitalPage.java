package com.endava.pages;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * @author Aleksandar.Zizovic
 *
 */
public class DigitalPage extends BasePage {
	private static Log log = LogFactory.getLog(DigitalPage.class);
	public By digitalItem = By.xpath("//*[@id='secondary-nav']//a[text()='Digital']/..");

	/**
	 * @param driver - WebDriver instance
	 */
	protected DigitalPage(WebDriver driver) {
		super(driver);
	}

	public void isActive() {
		log.debug("Open method isActive");
		Assert.assertTrue(driver.findElement(digitalItem).getAttribute("class").contains("active"));
	}
}
