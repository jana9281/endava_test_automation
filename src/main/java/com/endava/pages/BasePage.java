package com.endava.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * @author nadezda.petrovic@endava.com
 *
 */
public class BasePage {
	public final String ENDAVA_URL = "http://www.endava.com";
	public WebDriver driver;

	protected BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void scrollDownAtTheBottomOfThePage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void quit() {
		if (this != null) {
			driver.quit();
		}
	}
}
