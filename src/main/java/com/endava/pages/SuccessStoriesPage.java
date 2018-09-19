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

	protected SuccessStoriesPage(WebDriver driver) {
		super(driver);

	}

	public void findSSRCG() {
		Assert.assertTrue(driver.getTitle().contains("Success Story | Retail and Consumer Goods"));
	}

}
