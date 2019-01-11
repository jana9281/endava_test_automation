package com.endava.pages;

import com.endava.util.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MenuPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(MenuPage.class);

	public By navigationList = By.className("navigation");
	public By digitalItem = By.xpath("//a[text()='Digital']");
	public By industriesItem = By.xpath("//a[text()='Industries']");
	public By successStoriesItem = By.xpath("//a[text()='Success Stories']");
	public By servicesItem = By.xpath("//a[text()='Services']");

	public MenuPage(WebDriver driver) {
		super(driver);
	}

	public DigitalPage openDigitalPage() {
	    logger.info("Opening Digital page");
		WebDriverUtil.findElement(driver, digitalItem).click();
		return new DigitalPage(driver);
	}

	public IndustriesPage openIndustriesPage() {
        logger.info("Opening Industries page");
		WebDriverUtil.findElement(driver, industriesItem).click();
		return new IndustriesPage(driver);
	}

	public SuccessStoriesPage openSuccessStories() {
        logger.info("Opening Success Stories page");
		WebDriverUtil.findElement(driver, successStoriesItem).click();
		return new SuccessStoriesPage(driver);
	}

	public ServicesPage openServices() {
        logger.info("Opening Services page");
		WebDriverUtil.findElement(driver, servicesItem).click();
		return new ServicesPage(driver);
	}
}
