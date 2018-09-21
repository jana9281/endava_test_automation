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

	public static WebElement waitUntilElementLocated(WebDriver driver, long time, By locator) {
		return new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}
