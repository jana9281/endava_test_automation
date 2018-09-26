package com.endava.pages;

import org.openqa.selenium.WebDriver;

/**
 * @author jana.djordjevic@endava.com
 *
 */
public class BasePage {

	public WebDriver driver;
	public static final String ENDAVA_URL = "http://www.endava.com";

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
}
