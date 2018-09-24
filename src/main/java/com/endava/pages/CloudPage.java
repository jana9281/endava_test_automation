package com.endava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * 
 * @author Nadezda.Petrovic
 *
 * 
 * 
 */

public class CloudPage extends BasePage {

	public By contactUs = By.id("form-submit");
	public By warningMessage1 = By.xpath("//*[@class=\"error\"]//p[text()='Please enter Email Address']");
	public By warningMessage2 = By.xpath("//*[@class=\"error\"]//p[text()='Please enter Company']");
	public By warningMessage3 = By.xpath("//*[@class=\"error\"]//p[text()='Please enter Country/Region']");

	public CloudPage(WebDriver driver) {
		super(driver);
	}

	public void isUrlChanged() {
		Assert.assertFalse(driver.getCurrentUrl().equals(ENDAVA_URL));
	}

	public void scrollDownToContacts() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement contact = driver.findElement(contactUs);
		js.executeScript("arguments[0].scrollIntoView();", contact);
	}

	public void populateFirstLastName() {
		WebElement firstName = driver.findElement(By.id("firstname"));
		WebElement lastName = driver.findElement(By.id("lastname"));
		firstName.sendKeys("Petar");
		lastName.sendKeys("Petrovic");
	}

	public void isPopulatedFirstNameCorrect() {
		String firstName = driver.findElement(By.id("firstname")).getAttribute("value");
		Assert.assertTrue(firstName.matches("^[a-zA-Z]+[\\-'\\s]?[a-zA-Z ]+$"));
		Assert.assertTrue(35 > firstName.length());
		Assert.assertTrue(0 < firstName.length());
	}

	public void isPopulatedLastNameCorrect() {
		String lastName = driver.findElement(By.id("lastname")).getAttribute("value");
		Assert.assertTrue(lastName.matches("^[a-zA-Z]+[\\-'\\s]?[a-zA-Z ]+$"));
		Assert.assertTrue(35 > lastName.length());
		Assert.assertTrue(0 < lastName.length());
	}

	public void clikContactUs(By element) {
		driver.findElement(element).click();
	}

	public void isWarnningMessageExists(By element) {
		Assert.assertTrue(driver.findElement(element).isDisplayed());
	}

}