package com.endava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * @author Aleksandar.Zizovic
 *
 */
public class DigitalPage extends BasePage {

	public By digitalButton = By.xpath("//*[@id=\"secondary-nav\"]/ul/li[1]");

	/**
	 * @param driver - WebDriver instance
	 */
	protected DigitalPage(WebDriver driver) {
		super(driver);
	}

	public void isActive() {
		Assert.assertTrue(driver.findElement(digitalButton).getAttribute("class").contains("active"));
	}
}
