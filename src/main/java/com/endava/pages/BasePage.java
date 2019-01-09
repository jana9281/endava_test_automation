package com.endava.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {

	public WebDriver driver;

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
