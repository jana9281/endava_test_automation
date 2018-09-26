package com.endava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * @author jana.djordjevic@endava.com
 *
 */
public class BasePage {
	public static final String ENDAVA_URL = "http://www.endava.com";
	private static final String REGEX = "^[a-zA-Z]+[\\-'\\s]?[a-zA-Z ]+$";
	public WebDriver driver;

	protected BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void scrollDownAtTheBottomOfThePage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void scrollToElement(By element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(element));
	}

	public void clickOnElement(By element) {
		driver.findElement(element).click();
	}

	public void isElementSelected(By element) {
		Assert.assertTrue(driver.findElement(element).isSelected());
	}

	public void isElementShown(By element) {
		Assert.assertTrue(driver.findElement(element).isDisplayed());
	}

	public void isPopulatedElementCorrect(By element) {
		String model = driver.findElement(element).getAttribute("value");
		Assert.assertTrue(model.matches(REGEX) && 0 < model.length());
	}

	public void populateElement(By element, String elValue) {
		WebElement firstName = driver.findElement(element);
		firstName.sendKeys(elValue);
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void quit() {
		if (this.driver != null) {
			driver.quit();
		}
	}
}
