package com.endava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author jana.djordjevic@endava.com
 *
 */
public class MenuPage extends BasePage {

	public By navigationList = By.className("navigation");
	public By digitalItem = By.xpath("//a[text()='Digital']");
	public By idustriesItem = By.xpath("//a[text()='Industries']");
	public By successStoriesItem = By.xpath("//a[text()='Success Stories']");
	public By servicesItem = By.xpath("//a[text()='Services']");
	public By searchBar = By.id("search-input");
	public By magnifyingGlass = By.id("searchSubmit");

	public MenuPage(WebDriver driver) {
		super(driver);
	}

	public DigitalPage openDigitalPage() {
		driver.findElement(this.digitalItem).click();
		return new DigitalPage(driver);
	}

	public IndustriesPage openIndustriesPage() {
		driver.findElement(idustriesItem).click();
		return new IndustriesPage(driver);
	}

	public SuccessStoriesPage openSuccessStories() {
		driver.findElement(successStoriesItem).click();
		return new SuccessStoriesPage(driver);
	}

	public ServicesPage openServices() {
		driver.findElement(servicesItem).click();
		return new ServicesPage(driver);
	}

	public SearchPage openSearchPage() {
		driver.findElement(magnifyingGlass).click();
		return new SearchPage(driver);
	}
}
