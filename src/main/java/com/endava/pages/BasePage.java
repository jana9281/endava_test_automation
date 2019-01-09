package com.endava.pages;

import com.endava.util.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BasePage {

    public final String ENDAVA_URL = "https://www.endava.com";
    public final String LANGUAGE_ISO = "/en";

    public WebDriver driver;

    public By contactButtons = By.id("contact-buttons");
	public By burgerMenu = By.id("menu-toggle");
	public By automationAndEngineering = By.xpath("//*[@id=\"footer\"]//a[text()='Test Automation & Engineering']");
	public By cloud = By.xpath("//*[@id=\"footer\"]//a[text()='Cloud']");

	protected BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void quit() {
		if (this != null) {
			driver.quit();
		}
	}

	public void assertElementIsSelected(By element) {
		Assert.assertTrue(WebDriverUtil.findElement(driver, element).isSelected());
	}

	public void assertElementIsDisplayed(By element) {
		Assert.assertTrue(WebDriverUtil.findElement(driver, element).isDisplayed());
	}

	public void assertUrlEndsWith(String ending) {
		Assert.assertTrue(driver.getCurrentUrl().endsWith(ending));
	}
}
