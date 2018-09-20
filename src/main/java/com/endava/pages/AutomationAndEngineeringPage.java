/**
 * 
 */
package com.endava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * @author Radovan.Olujic
 *
 */
public class AutomationAndEngineeringPage extends BasePage {

	public By signMeUpforNewsletterCheckBox = By.xpath("//*[@id='newsletter_input']");
	public By signMeUpforNewsletterLabel = By.xpath("//*[@id=\"contact-form\"]/fieldset/div[3]/div[2]/div[1]/label");
	public By promptMessage = By.id("prompt_message2");

	protected AutomationAndEngineeringPage(WebDriver driver) {
		super(driver);
	}

	public void isUrlChanged() {
		Assert.assertFalse(driver.getCurrentUrl().equals(ENDAVA_URL));
	}

	public void scrollDownToElement() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("/html/body/section[7]/div/div/div/h2"));
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void tickCheckBox(By element) {
		driver.findElement(element).click();
	}

	public void isCheckBoxTicked(By element) {
		Assert.assertTrue(driver.findElement(element).isSelected());
	}

	public void isMessageAppears() {
		Assert.assertTrue(driver.findElement(promptMessage).isDisplayed());
	}
}
