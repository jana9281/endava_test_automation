package com.endava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author jana.djordjevic@endava.com
 *
 */
public class MenuPage extends BasePage {

	public By navigationList = By.className("navigation");
	public By successStories = By.xpath("//a[text()='Success Stories']");

	public MenuPage(WebDriver driver) {
		super(driver);
	}

	public SuccessStoriesPage openSuccessStories() {
		driver.findElement(successStories).click();
		return new SuccessStoriesPage(driver);
	}
}
