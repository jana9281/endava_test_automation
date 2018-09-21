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

	public By firstLastNameErrorLocation = By.xpath("//*[@id=\"contact-form\"]/fieldset/div[2]/div[1]/div/p");
	public By warningMessage= By.className("error");
	public By contactUs= By.id("form-submit");
	
	public CloudPage(WebDriver driver) {
		super(driver);
	}

	public void isUrlChanged() {
		Assert.assertFalse(driver.getCurrentUrl().equals(ENDAVA_URL));
	}

	public void scrollDownToContacts() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement contact = driver.findElement(By.xpath("/html/body/section[9]/div/div/div/h2"));
		js.executeScript("arguments[0].scrollIntoView();", contact);
	}

	public void populateFirstLastName() {
		WebElement firstName = driver.findElement(By.id("firstname"));
		WebElement lastName = driver.findElement(By.id("lastname"));
		firstName.sendKeys("petra");
		lastName.sendKeys("Petrovic");
	}

	public void isPopulatedFirstNameCorrect(By element) {
		Assert.assertTrue(driver.findElement(element).isSelected());
	}

	public void isPopulatedLastNameCorrect(By element) {
		Assert.assertTrue(driver.findElement(element).isSelected());
	}

	public void clikContactUs(By element) {
		driver.findElement(element).click();
	}

	public void isWarnningMessageExists(By element) {
		Assert.assertTrue(driver.findElement(element).isSelected());
	}

}