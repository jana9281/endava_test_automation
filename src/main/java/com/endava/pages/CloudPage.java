package com.endava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * @author Denis.Selimovski
 *
 */
public class CloudPage extends BasePage {

	public By termsAndConditionsLabel = By.xpath("//*[@id=\"contact-form\"]/fieldset/div[3]/div[2]/div[2]/label");
	public By termsAndConditionsCheckBox = By.xpath("//*[@id='terms_input']");
	public By suggestion = By.id("suggestion");

	public CloudPage(WebDriver driver) {
		super(driver);
	}

	public void isUrlChanged() {
		Assert.assertFalse(driver.getCurrentUrl().equals(ENDAVA_URL));
	}

	public void scrollDownToElement() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("/html/body/section[9]/div/div/div/h2"));
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void tickCheckBox(By element) {
		driver.findElement(element).click();
	}

	public void isCheckBoxTicked(By element) {
		Assert.assertTrue(driver.findElement(element).isSelected());
	}

	public void isSuggestionShown() {
		Assert.assertTrue(driver.findElement(suggestion).isDisplayed());
	}

}
