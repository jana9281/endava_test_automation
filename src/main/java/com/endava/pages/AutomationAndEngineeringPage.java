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
	public By signMeUpforNewsletterLabel = By.xpath("//*[@id=\"contact-form\"]/fieldset/div[3]/div[2]/div[1]/label");
	public By promptMessage = By.id("prompt_message2");
	public By contactUsArea = By.xpath("/html/body/section[7]/div/div/div/h2");

	protected AutomationAndEngineeringPage(WebDriver driver) {
		super(driver);
	}

	public void isUrlChanged() {
		Assert.assertFalse(driver.getCurrentUrl().equals(ENDAVA_URL));
	}
}
