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

	public static void scrollDownAtTheBottomOfThePage(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public static void scrollToElement(WebDriver driver, By element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(element));
	}

	public static void clickOnElement(WebDriver driver, By element) {
		driver.findElement(element).click();
	}

	public static boolean isElementSelected(WebDriver driver, By element) {
		return driver.findElement(element).isSelected();
	}

	public static boolean isElementShown(WebDriver driver, By element) {
		return driver.findElement(element).isDisplayed();
	}

}
