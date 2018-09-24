package com.endava.pages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * @author Denis.Selimovski
 *
 */
public class SoftwareEngineeringPage extends BasePage {

	public By emailAddressField = By.id("email");
	public By submitButton = By.id("form-submit");
	public By warningMessageEmail = By.xpath("//*[@id=\"contact-form\"]//p[text()='Email address is not corect']");
	public By contactUsArea = By.xpath("//h2[text()='Contact us']");

	public SoftwareEngineeringPage(WebDriver driver) {
		super(driver);
	}

	public void isUrlChanged() {
		Assert.assertFalse(driver.getCurrentUrl().equals(ENDAVA_URL));
	}

	public void isEmailAddressIncorrect() {
		String emailValue = driver.findElement(emailAddressField).getAttribute("value");
		Pattern pattern = Pattern.compile("^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
		Matcher matcher = pattern.matcher(emailValue);
		Assert.assertFalse(matcher.find());
	}

}
