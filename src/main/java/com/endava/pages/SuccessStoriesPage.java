package com.endava.pages;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * @author Radovan.Olujic
 *
 */
public class SuccessStoriesPage extends BasePage {
	private static Log log = LogFactory.getLog(SuccessStoriesPage.class);
	public By textSSRCG = By.xpath("/html/body/section[2]/div/div/div[1]/figure/figcaption/p");

	protected SuccessStoriesPage(WebDriver driver) {
		super(driver);
	}

	public void validateSSRCGTitle() {
		log.debug("Open method validateSSRCGTitle");
		Assert.assertTrue(
				driver.findElement(textSSRCG).getText().equalsIgnoreCase("Success Story | Retail and Consumer Goods"));
	}
}
