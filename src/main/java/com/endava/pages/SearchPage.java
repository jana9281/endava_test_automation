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
public class SearchPage extends BasePage {

	public By searchResult = By.xpath("//article/div/div/div[1]");

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	public void noResultsValidation() {
		Assert.assertTrue(driver.findElement(searchResult).getText()
				.equalsIgnoreCase("There are no results for your search criteria."));
	}
}
