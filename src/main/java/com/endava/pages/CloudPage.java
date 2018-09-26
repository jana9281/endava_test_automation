package com.endava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * @author Denis.Selimovski
 *
 */
public class CloudPage extends BasePage {

	public By termsAndConditionsLabel = By.xpath("//label[@for='terms_input']");
	public By termsAndConditionsCheckBox = By.xpath("//*[@id='terms_input']");
	public By suggestion = By.id("suggestion");
	public By contactUsArea = By.xpath("//h2[text()='Contact us']");

	public CloudPage(WebDriver driver) {
		super(driver);
	}

	public void isUrlChanged() {
		Assert.assertFalse(driver.getCurrentUrl().equals(ENDAVA_URL));
	}

}
