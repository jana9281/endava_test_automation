package com.endava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * @author Nadezda.Petrovic
 *
 */
public class IndustriesPage extends BasePage {

	public By finance = By.xpath("//a[text()='Finance']");

	public IndustriesPage(WebDriver driver) {
		super(driver);
	}

	public void checkRead() {
		Assert.assertTrue(driver.findElement(finance).isDisplayed());
	}
}
