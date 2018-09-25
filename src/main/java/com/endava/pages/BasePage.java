package com.endava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * @author jana.djordjevic@endava.com
 *
 */
public class BasePage {

	public WebDriver driver;
	public By footer = By.id("footer");
	public By servicesSection = By.xpath("//*[@id=\"footer\"]/section[1]/div/div[1]");
	public By industriesSection = By.xpath("//*[@id=\"footer\"]/section[1]/div/div[3]");
	public By companySection = By.xpath("//*[@id=\"footer\"]/section[1]/div/div[4]");
	public By endavaLogo = By.xpath("//*[@id=\"footer\"]/section[2]/div/div/div[2]/object");
	public By burgerMenu = By.id("menu-toggle");

	protected BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void quit() {
		if (this != null) {
			driver.quit();
		}
	}

	public MenuPage openMenu() {
		driver.findElement(this.burgerMenu).click();
		return new MenuPage(driver);
	}

	public void isElementShown(By element) {
		Assert.assertTrue(driver.findElement(element).isDisplayed());
	}

	public void scrollDownToElement(By element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(element));
	}

}
