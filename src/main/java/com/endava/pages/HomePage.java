package com.endava.pages;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author jana.djordjevic@endava.com
 *
 */
public class HomePage extends BasePage {

	private final String ENDAVA_URL = "http://www.endava.com";
	private static Log log = LogFactory.getLog(HomePage.class);
	public By contactButtons = By.id("contact-buttons");
	public By burgerMenu = By.id("menu-toggle");

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void open() {
		log.debug("Method open home page ");
		driver.get(ENDAVA_URL);
		driver.manage().window().maximize();
	}

	public MenuPage openMenu() {
		log.debug("Method open menu page ");
		driver.findElement(this.burgerMenu).click();
		return new MenuPage(driver);
	}
}
