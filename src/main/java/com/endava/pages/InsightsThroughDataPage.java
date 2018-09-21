/**
 * 
 */
package com.endava.pages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * @author Radovan.Olujic
 *
 */
public class InsightsThroughDataPage extends BasePage {

	public By firsNameField = By.id("firstname");
	public By lastNameField = By.id("lastname");
	public By contactUs = By.id("form-submit");
	public By warningMessageLastName = By.xpath("//*[@id=\"contact-form\"]//p[text()='Please enter Last Name']");
	public By warningMessagePhoneNumber = By.xpath("//*[@id=\"contact-form\"]/fieldset/div[2]/div[4]/div");

	public InsightsThroughDataPage(WebDriver driver) {
		super(driver);
	}

	public void isUrlChanged() {
		Assert.assertFalse(driver.getCurrentUrl().equals(ENDAVA_URL));
	}

	public void scrollDownToContactUs() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//h2[text()='Contact us']"));
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void populateFirstNameField() {
		driver.findElement(firsNameField).clear();
		driver.findElement(firsNameField).sendKeys("Rale");
	}

	public void populateLastNameField() {
		driver.findElement(lastNameField).clear();
		driver.findElement(lastNameField).sendKeys("Oluja");
	}

	public void clearLastNameField() {
		driver.findElement(lastNameField).clear();
	}

	public void isFirstNameCorrect() {
		String str = driver.findElement(firsNameField).getAttribute("value");
		Pattern p = Pattern.compile("[a-zA-Z '.-]+");
		Matcher m = p.matcher(str);
		Assert.assertTrue(m.find());
	}

	public void clicOnButton(By button) {
		driver.findElement(button).click();
	}

	public void isWarningMessageShown() {
		Assert.assertTrue(driver.findElement(warningMessageLastName).isDisplayed());
	}

	public void isWarningMassageNotShown() {
		Assert.assertTrue(driver.findElement(warningMessagePhoneNumber).getText().equals(""));
	}
}
