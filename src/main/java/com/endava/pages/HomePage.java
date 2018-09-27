package com.endava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.endava.util.WebDriverUtil;

/**
 * @author jana.djordjevic@endava.com
 *
 */
public class HomePage extends BasePage {

	private final String ENDAVA_URL = "http://www.endava.com";

	public By contactButtons = By.id("contact-buttons");
	public By burgerMenu = By.id("menu-toggle");
	public By languageMenu = By.id("selected-lang");
	public By englishLanguageButton = By.xpath("//*[@id=\"langList-box\"]//a[text() = 'English']");
	public By deutschLanguageButton = By.xpath("//*[@id=\"langList-box\"]/ul/li[1]/a");

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

	public HomePage openHomePage(By languageButton) {
		driver.findElement(this.languageMenu).click();
		WebDriverUtil.waitForVisible(this.driver, 5, languageButton);
		driver.findElement(languageButton).click();
		return new HomePage(driver);
	}

}
