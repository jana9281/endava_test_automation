/**
 * 
 */
package com.endava.util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * @author Aleksandar.Zizovic
 *
 */
public class WebDriverUtil {

	/**
	 * 
	 * @param driver  - WebDriver instance
	 * @param time    in seconds
	 * @param locator - By instance
	 * @return
	 */
	public static WebElement waitForVisible(WebDriver driver, long time, By locator) {
		return new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static void scrollToElement(WebDriver driver, By element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(element));
	}

	public static void isElementShown(WebDriver driver, By element) {
		Assert.assertTrue(driver.findElement(element).isDisplayed());
	}

	public static void clickOnElement(WebDriver driver, By element) {
		driver.findElement(element).click();
	}

	public static void clearField(WebDriver driver, By field) {
		driver.findElement(field).clear();
	}

	public static void populateField(WebDriver driver, By field, String text) {
		driver.findElement(field).sendKeys(text);
	}
}
