package com.endava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * @author Aleksandar.Zizovic
 *
 */
public class DigitalPage extends BasePage {

	public By digitalItem = By.xpath("//*[@id='secondary-nav']//a[text()='Digital']/..");

	/**
	 * @param driver - WebDriver instance
	 */
	protected DigitalPage(WebDriver driver) {
		super(driver);
	}

	public void isActive() {
		Assert.assertTrue(driver.findElement(digitalItem).getAttribute("class").contains("active"));
	}
}
