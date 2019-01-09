package com.endava.pages;

import com.endava.util.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ServicesPage extends BasePage {

	public By strategyMenuOption = By.xpath("//a[text()='Strategy']");

	public ServicesPage(WebDriver driver) {
		super(driver);
	}

	public void strategyIsShown() {
		Assert.assertTrue(WebDriverUtil.findElement(driver, strategyMenuOption).isDisplayed());
	}

}
