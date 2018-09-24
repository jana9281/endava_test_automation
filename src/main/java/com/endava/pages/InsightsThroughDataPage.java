package com.endava.pages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * @author Radovan.Olujic
 *
 */
public class InsightsThroughDataPage extends BasePage {

	public By firsNameField = By.id("firstname");
	public By lastNameField = By.id("lastname");
	public By contactUsButton = By.id("form-submit");
	public By warningMessageLastName = By.xpath("//*[@id=\"contact-form\"]//p[text()='Please enter Last Name']");
	public By warningMessagePhoneNumber = By.xpath("//*[@id=\"contact-form\"]/fieldset/div[2]/div[4]/div");
	public By contactUsArea = By.xpath("//h2[text()='Contact us']");

	public InsightsThroughDataPage(WebDriver driver) {
		super(driver);
	}

	public void isUrlChanged() {
		Assert.assertFalse(driver.getCurrentUrl().equals(ENDAVA_URL));
	}

	public void isFirstNameCorrect() {
		String str = driver.findElement(firsNameField).getAttribute("value");
		Pattern p = Pattern.compile("[a-zA-Z '.-]+");
		Matcher m = p.matcher(str);
		Assert.assertTrue(m.find());
	}

	public void isWarningMassageNotShown() {
		Assert.assertTrue(driver.findElement(warningMessagePhoneNumber).getText().equals(""));
	}
}
