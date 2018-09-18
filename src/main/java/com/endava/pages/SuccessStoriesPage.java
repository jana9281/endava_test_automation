/**
 * 
 */
package com.endava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Radovan.Olujic
 *
 */
public class SuccessStoriesPage extends BasePage {

	public By pageTitle = By.linkText("Success Stories");
	public By storyTitle = By.linkText("Success Story | Retail and Consumer Goods");

	protected SuccessStoriesPage(WebDriver driver) {
		super(driver);

	}

	public Boolean findSSRCG() {
		if (driver.getTitle().contains("Success Story | Retail and Consumer Goods"))
			return true;
		else
			return false;

	}

}
