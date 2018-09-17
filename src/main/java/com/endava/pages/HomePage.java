package com.endava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author jana.djordjevic@endava.com
 *
 */
public class HomePage {

	private WebDriver driver = null;
	private final String ENDAVA_URL = "http://www.endava.com";

	public By contactButtons = By.id("contact-buttons");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage open() {
		driver.get(ENDAVA_URL);
		driver.manage().window().maximize();
		return null;
	}
}
