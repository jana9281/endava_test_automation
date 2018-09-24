package com.endava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author jana.djordjevic@endava.com
 *
 */
public class HomePage extends BasePage {

	private final String ENDAVA_URL = "http://www.endava.com";

	public By contactButtons = By.id("contact-buttons");
	public By burgerMenu = By.id("menu-toggle");
	public By languageMenuEn = By.xpath("//*[@id=\"langList-box\"]/ul/li[2]/a");
	// public By languageMenuDe =
	// By.xpath("//*[@id=\"selected-lang\"]//p[text()='Deutsch']");//*[@id="langList-box"]/ul/li[2]/a

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

}
