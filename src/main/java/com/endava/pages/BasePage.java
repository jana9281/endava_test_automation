package com.endava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * @author jana.djordjevic@endava.com
 *
 */
public class BasePage {

	public WebDriver driver;

	protected BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnElement(By element) {
		driver.findElement(element).click();
	}

	public void isElementSelected(By element) {
		Assert.assertTrue(driver.findElement(element).isSelected());
	}

	public void quit() {
		if (this != null) {
			driver.quit();
		}
	}
}
