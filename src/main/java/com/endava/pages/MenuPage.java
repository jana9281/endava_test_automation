package com.endava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author jana.djordjevic@endava.com
 *
 */
public class MenuPage extends BasePage {

	public By navigationList = By.className("navigation");

	public By successStoriesItem = By.xpath("//a[text()='Success Stories']");

	public By servicesItem = By.xpath("//a[text()='Services']");

	public MenuPage(WebDriver driver) {
		super(driver);
	}

	public SuccessStoriesPage openSuccessStories() {
		driver.findElement(successStoriesItem).click();
		return new SuccessStoriesPage(driver);
	}

	public ServicesPage openServices() {
		driver.findElement(servicesItem).click();
		return new ServicesPage(driver);
	}

}
