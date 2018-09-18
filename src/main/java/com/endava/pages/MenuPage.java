package com.endava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author jana.djordjevic@endava.com
 *
 */
public class MenuPage extends BasePage {

	public By navigationList = By.className("navigation");
	public By servicesItem = By.cssSelector("#mCSB_1_container > div.inner > nav > ul > li:nth-child(4) > a");

	public MenuPage(WebDriver driver) {
		super(driver);
	}

	public ServicesPage openServices() {
		driver.findElement(servicesItem).click();
		return new ServicesPage(driver);
	}

}
