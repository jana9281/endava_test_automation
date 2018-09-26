/**
 * 
 */
package com.endava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * @author Radovan.Olujic
 *
 */
public class AutomationAndEngineeringPage extends BasePage {

	public By signMeUpforNewsletterCheckBox = By.xpath("//*[@id='newsletter_input']");
	public By signMeUpforNewsletterLabel = By.xpath("//label[@for='newsletter_input']");
	public By promptMessage = By.id("prompt_message2");
	public By contactUsTitle = By.xpath("//h2[text()='Contact us']");

	protected AutomationAndEngineeringPage(WebDriver driver) {
		super(driver);
	}

	public void isUrlChanged() {
		Assert.assertFalse(driver.getCurrentUrl().equals(ENDAVA_URL));
	}
}
