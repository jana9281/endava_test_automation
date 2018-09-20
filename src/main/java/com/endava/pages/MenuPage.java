package com.endava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author jana.djordjevic@endava.com
 *
 */
public class MenuPage extends BasePage {

	public By navigationList = By.className("navigation");
	public By indPage = By.xpath("//a[text()='Industries']");

	public MenuPage(WebDriver driver) {
		super(driver);
	}
	public IndustriesPage openIndustriesPage() {
		driver.findElement(this.indPage).click();
		return new IndustriesPage(driver);
	}
}
