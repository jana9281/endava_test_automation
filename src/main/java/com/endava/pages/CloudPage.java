package com.endava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * @author Denis.Selimovski
 *
 */
public class CloudPage extends BasePage {

	public By termsAndConditionsLabel = By.xpath("//*[@id=\"contact-form\"]/fieldset/div[3]/div[2]/div[2]/label");
	public By termsAndConditionsCheckBox = By.xpath("//*[@id='terms_input']");
	public By suggestion = By.id("suggestion");
	public By contactUsArea = By.xpath("/html/body/section[9]/div/div/div/h2");

	public CloudPage(WebDriver driver) {
		super(driver);
	}

	public void isUrlChanged() {
		Assert.assertFalse(driver.getCurrentUrl().equals(ENDAVA_URL));
	}

}
