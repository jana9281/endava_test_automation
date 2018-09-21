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

	String actualString = driver.findElement(By.xpath("//p[text()='Success Story | Retail and Consumer Goods']"))
			.getText();

	protected SuccessStoriesPage(WebDriver driver) {
		super(driver);

	}

	public void findSSRCG() {
		Assert.assertTrue(actualString.equalsIgnoreCase("Success Story | Retail and Consumer Goods"));

	}

}
