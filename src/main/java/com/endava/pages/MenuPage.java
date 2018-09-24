package com.endava.pages;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author jana.djordjevic@endava.com
 *
 */
public class MenuPage extends BasePage {
	private static Log log = LogFactory.getLog(ServicesPage.class);
	public By navigationList = By.className("navigation");
	public By servicesItem = By.xpath("//a[text()='Services']");

	public MenuPage(WebDriver driver) {
		super(driver);
	}

	public ServicesPage openServices() {
		log.debug("Open method openServices");
		driver.findElement(servicesItem).click();
		return new ServicesPage(driver);
	}

}
