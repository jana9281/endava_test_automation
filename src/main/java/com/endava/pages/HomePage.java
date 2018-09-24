package com.endava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author jana.djordjevic@endava.com
 *
 */
public class HomePage extends BasePage {

	public By contactButtons = By.id("contact-buttons");
	public By burgerMenu = By.id("menu-toggle");
	public By softwareEngineering = By.linkText("Software Engineering");
	public By footer = By.id("footer");

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

	public SoftwareEngineeringPage openSoftwareEngineeringPage() {
		driver.findElement(softwareEngineering).click();
		return new SoftwareEngineeringPage(driver);
	}

}
