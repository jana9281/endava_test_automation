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
	
	private final String setText = "Success Story | Retail and Consumer Goods";
	public String actualText = driver.findElement(
			By.xpath("/html/body/section[2]/div/div/div[1]/figure/figcaption/p")).getText();

	protected SuccessStoriesPage(WebDriver driver) {
		super(driver);
	}

	public void validateSSRCGTitle() {
		Assert.assertTrue(actualText.equalsIgnoreCase(setText));
	}
}
