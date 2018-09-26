package com.endava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * @author jana.djordjevic@endava.com
 *
 */
public class BasePage {

	public WebDriver driver;
	public final String ENDAVA_URL = "http://www.endava.com";

	protected BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void quit() {
		if (this != null) {
			driver.quit();
		}
	}

	public void scrollDownToElement(By element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(element));
	}

	public void isElementShown(By element) {
		Assert.assertTrue(driver.findElement(element).isDisplayed());
	}

	public void clickOnElement(By element) {
		driver.findElement(element).click();
	}

	public void populateField(By field, String text) {
		driver.findElement(field).sendKeys(text);
	}

}
