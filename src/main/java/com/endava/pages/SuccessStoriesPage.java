/**
 * 
 */
package com.endava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * @author Radovan.Olujic
 *
 */
public class SuccessStoriesPage extends BasePage {

	public By pageTitle = By.linkText("Success Stories");
	public By textSSRCG = By.xpath("//p[text()='Success Story | Retail and Consumer Goods']");

	protected SuccessStoriesPage(WebDriver driver) {
		super(driver);
	}

	public void validateSSRCGTitle() {
		Assert.assertTrue(
				driver.findElement(textSSRCG).getText().equalsIgnoreCase("Success Story | Retail and Consumer Goods"));
	}
}
