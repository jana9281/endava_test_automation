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
	public By contactUsTitle = By.xpath("//h2[text()='Contact us']");
	public final String CLOUD_PAGE_TITLE = driver.getTitle();

	public CloudPage(WebDriver driver) {
		super(driver);
	}

	public void validateURL() {
		Assert.assertTrue(driver.getCurrentUrl().equals(new StringBuilder(ENDAVA_URL).append(LANGUAGE_ISO)
				.append("/Services").append("/").append(CLOUD_PAGE_TITLE).toString()));
	}

}
