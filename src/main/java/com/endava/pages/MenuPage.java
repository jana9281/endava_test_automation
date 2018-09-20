package com.endava.pages;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author jana.djordjevic@endava.com
 *
 */
public class MenuPage extends BasePage {
	private static Logger log = Logger.getLogger(MenuPage.class.getName());
	public By navigationList = By.className("navigation");
	public By servicesItem = By.xpath("//a[text()='Services']");

	public MenuPage(WebDriver driver) {
		super(driver);
	}

	public ServicesPage openServices() {
		log.info("*****   open method openServices  ***");
		driver.findElement(servicesItem).click();
		return new ServicesPage(driver);
	}

}
