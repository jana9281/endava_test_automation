package com.endava.pages;

import com.endava.util.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DigitalPage extends BasePage {

	public By digitalItem = By.xpath("//*[@id='secondary-nav']//a[text()='Digital']/..");

	/**
	 * @param driver - WebDriver instance
	 */
	protected DigitalPage(WebDriver driver) {
		super(driver);
	}

	public void isActive() {
		Assert.assertTrue(WebDriverUtil.findElement(driver, digitalItem).getAttribute("class").contains("active"));
	}
}
