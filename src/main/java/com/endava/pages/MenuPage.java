package com.endava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author jana.djordjevic@endava.com
 *
 */
public class MenuPage extends BasePage {

	public By navigationList = By.className("navigation");
	public By digital = By.xpath("//*[@id=\"mCSB_1_container\"]/div[1]/nav/ul/li[1]/a");

	public MenuPage(WebDriver driver) {
		super(driver);
	}
	
	public DigitalPage openDigitalPage() {
		driver.findElement(this.digital).click();
		return new DigitalPage(driver);
	}
}
