/**
 * 
 */
package com.endava.util;

import org.openqa.selenium.By;
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
}
