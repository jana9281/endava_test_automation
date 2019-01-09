package com.endava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BasePage {

	public By contactButtons = By.id("contact-buttons");
	public By burgerMenu = By.id("menu-toggle");
	public By automationAndEngineering = By.xpath("//*[@id=\"footer\"]//a[text()='Test Automation & Engineering']");
	public final String ENDAVA_URL = "http://www.endava.com";

	public WebDriver driver;

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

	public void scrollDownAtTheBottomOfThePage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void scrollToElement(By element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(element));
	}

	public void clickOnElement(By element) {
		driver.findElement(element).click();
	}

	public void isElementSelected(By element) {
		Assert.assertTrue(driver.findElement(element).isSelected());
	}

	public void isElementShown(By element) {
		Assert.assertTrue(driver.findElement(element).isDisplayed());
	}
}
