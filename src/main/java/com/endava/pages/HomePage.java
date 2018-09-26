package com.endava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author jana.djordjevic@endava.com
 *
 */
public class HomePage extends BasePage {

	private final String ENDAVA_URL = "http://www.endava.com";

	public By contactButtons = By.xpath("//*[@id=\"contact-buttons\"]/ul/li[1]/a");
	public By burgerMenu = By.id("menu-toggle");

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void open() {
		driver.get(ENDAVA_URL);
		driver.manage().window().maximize();
	}

	public MenuPage openMenu() {
		driver.findElement(this.burgerMenu).click();
		return new MenuPage(driver);
	}

	public ContactUsPage openContactUs() {
		driver.findElement(contactButtons).click();
		return new ContactUsPage(driver);
	}
}
