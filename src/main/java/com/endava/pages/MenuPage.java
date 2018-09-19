package com.endava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author jana.djordjevic@endava.com
 *
 */
public class MenuPage extends BasePage {

	public By navigationList = By.className("navigation");
	public By indPage = By.xpath("//*[@id=\"mCSB_1_container\"]/div[1]/nav/ul/li[6]/a");

	public MenuPage(WebDriver driver) {
		super(driver);
	}
	public IndustriesPage openIndustriesPage() {
		driver.findElement(this.indPage).click();
		return new IndustriesPage(driver);
	}
}
