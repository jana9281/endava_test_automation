package com.endava.pages;

import com.endava.util.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MenuPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(MenuPage.class);

	public By navigationList = By.className("navigation");
	//public By digitalItem = By.cssSelector(" li:nth-child(1) > a ");
	public By industriesItem = By.cssSelector(" li:nth-child(6) > a ");
	public By successStoriesItem = By.cssSelector(" li:nth-child(7) > a ");
	public By servicesItem = By.cssSelector(" li:nth-child(4) > a ");

	public By digitalItem = By.xpath("/html/body/header/div/div[2]/div/div[2]/div/div/div[1]/div[1]/nav/ul/li[1]/a");
	//public By successStoriesItem = By.cssSelector("//a[text()='Success Stories']");
	//public By industriesItem = By.xpath("//a[text()='Industries']");
	//public By servicesItem = By.xpath("//a[text()='Services']");

	public MenuPage(WebDriver driver) {
		super(driver);
	}

	public DigitalPage openDigitalPage() {
	    logger.info("Opening Digital page");
		WebDriverUtil.clickOnElement(driver, digitalItem);
		return new DigitalPage(driver);
	}

	public IndustriesPage openIndustriesPage() {
        logger.info("Opening Industries page");
		WebDriverUtil.clickOnElement(driver, industriesItem);
		return new IndustriesPage(driver);
	}

	public SuccessStoriesPage openSuccessStories() {
        logger.info("Opening Success Stories page");
		WebDriverUtil.clickOnElement(driver, successStoriesItem);
		return new SuccessStoriesPage(driver);
	}

	public ServicesPage openServices() {
        logger.info("Opening Services page");
		WebDriverUtil.clickOnElement(driver, servicesItem);
		return new ServicesPage(driver);
	}
}
