package com.endava.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtil {

	private static final Logger logger = LoggerFactory.getLogger(WebDriverUtil.class);

	/**
	 * 
	 * @param driver  - WebDriver instance
	 * @param time    in seconds
	 * @param locator - By instance
	 * @return
	 */
	public static WebElement waitForVisible(WebDriver driver, long time, By locator) {
		logger.debug("Waiting max {} for element {} to become visible", time, locator);
		return new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static WebElement findElement(WebDriver driver, By locator) {
		logger.debug("Finding element {}", locator);
		return driver.findElement(locator);
	}

	public static List<WebElement> findElements(WebDriver driver, By locator) {
		logger.debug("Finding element {}", locator);
		return driver.findElements(locator);
	}

	public static boolean isElementPresent(WebDriver driver, By locator) {
		logger.debug("Checking if element {} is present", locator);
		return findElements(driver, locator)
				.stream()
				.findFirst()
				.isPresent();
	}

	public static boolean isElementDisplayed(WebDriver driver, By locator) {
		logger.debug("Checking if element {} is displayed", locator);
		return findElements(driver, locator)
				.stream()
				.filter(WebElement::isDisplayed)
				.findFirst()
				.isPresent();
	}

	public static String getCurrentURL(WebDriver driver) {
		String url = driver.getCurrentUrl();
		logger.debug("Getting page URL: {}", url);
		return url;
	}

	public static String getPageTitle(WebDriver driver) {
		String title = driver.getTitle();
		logger.debug("Getting page title: {}", title);
		return title;
	}

	public static void clickOnElement(WebDriver driver, By locator) {
		logger.debug("Clicking on element {}", locator);
		findElement(driver, locator).click();
	}

	public static void scrollToElement(WebDriver driver, By locator) {
		logger.debug("Scrolling to element {}", locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
	}

	public static void scrollDownAtTheBottomOfThePage(WebDriver driver) {
		logger.debug("Scrolling to the page bottom");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public static void clearField(WebDriver driver, By locator) {
		logger.debug("Clearing field {}", locator);
		findElement(driver, locator).clear();
	}

	public static void populateField(WebDriver driver, By locator, String text) {
		logger.debug("Entering text {} in field {}", text, locator);
		findElement(driver, locator).sendKeys(text);
	}

	public static String getElementText(WebDriver driver, By locator) {
		logger.debug("Retrieves text from element {}", locator);
		return findElement(driver, locator).getText();
	}

	public static String getElementAttributeValue(WebDriver driver, By locator) {
		logger.debug("Getting value attribute from element {}", locator);
		return findElement(driver, locator).getAttribute("value");
	}
}
