package com.endava.pages;

import com.endava.util.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class IndustriesPage extends BasePage {

	public By finance = By.xpath("//a[text()='Finance']");

	public IndustriesPage(WebDriver driver) {
		super(driver);
	}

	public void checkRead() {
		Assert.assertTrue(WebDriverUtil.findElement(driver, finance).isDisplayed());
	}
}
