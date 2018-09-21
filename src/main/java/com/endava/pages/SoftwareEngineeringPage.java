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
 * @author Denis.Selimovski
 *
 */
public class SoftwareEngineeringPage extends BasePage {

	public By emailAddressField = By.id("email");
	public By submitButton = By.id("form-submit");
	public By warningMessageEmail = By.xpath("//*[@id=\"contact-form\"]//p[text()='Email address is not corect']");

	public SoftwareEngineeringPage(WebDriver driver) {
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

	public void populateIncorrectEmailAddress() {
		driver.findElement(emailAddressField).clear();
		driver.findElement(emailAddressField).sendKeys("blahblah123");
	}

	public void isEmailAddressIncorrect() {
		String emailValue = driver.findElement(emailAddressField).getAttribute("value");
		Pattern pattern = Pattern.compile("^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
		Matcher matcher = pattern.matcher(emailValue);
		Assert.assertFalse(matcher.find());
	}

	public void clickOnButton(By button) {
		driver.findElement(button).click();
	}

	public void isWarningMessageShown() {
		Assert.assertTrue(driver.findElement(warningMessageEmail).isDisplayed());
	}

}
