package com.endava.pages;

import com.endava.util.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage extends BasePage {

	public By navigationList = By.className("navigation");
	public By digitalItem = By.xpath("//a[text()='Digital']");
	public By idustriesItem = By.xpath("//a[text()='Industries']");
	public By successStoriesItem = By.xpath("//a[text()='Success Stories']");
	public By servicesItem = By.xpath("//a[text()='Services']");

	public MenuPage(WebDriver driver) {
		super(driver);
	}

	public DigitalPage openDigitalPage() {
		WebDriverUtil.findElement(driver, digitalItem).click();
		return new DigitalPage(driver);
	}

	public IndustriesPage openIndustriesPage() {
		WebDriverUtil.findElement(driver, idustriesItem).click();
		return new IndustriesPage(driver);
	}

	public SuccessStoriesPage openSuccessStories() {
		WebDriverUtil.findElement(driver, successStoriesItem).click();
		return new SuccessStoriesPage(driver);
	}

	public ServicesPage openServices() {
		WebDriverUtil.findElement(driver, servicesItem).click();
		return new ServicesPage(driver);
	}
}
