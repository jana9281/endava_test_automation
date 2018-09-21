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
 * @author Aleksandar.Zizovic
 *
 */
public class CreativeAndUXPage extends BasePage {

	public By contactUsButton;
	public By emailTextField = By.id("email");
	public By countryNameTextField = By.id("countryRegion");
	public By contactUsArea = By.xpath("/html/body/section[7]/div/div/div");

	/**
	 * @param driver
	 */
	protected CreativeAndUXPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * 
	 */
	public void isUrlChanged() {
		Assert.assertFalse(driver.getCurrentUrl().equals(ENDAVA_URL));
	}

	/**
	 * 
	 */
	public void scrollDownToContactUsArea() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(this.contactUsArea);
		js.executeScript("arguments[0].scrollIntoView();", element);

	}

	/**
	 * @param emailTextField2
	 */
	public void populateEmailTextField() {
		driver.findElement(this.emailTextField).sendKeys("Aleksandar.Zizovic@endava");
	}

	/**
	 * @param countryNameTextField2
	 */
	public void populateCountryNameTextField() {
		driver.findElement(this.countryNameTextField).sendKeys("Serbia");

	}

	/**
	 * 
	 */
	public void isEmailValid() {
		Assert.assertTrue(driver.findElement(emailTextField).getAttribute("value")
				.matches("^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$"));

	}

	/**
	 * 
	 */
	public void isCountryNameValid() {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 */
	public void clickOnContactUsButton() {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 */
	public void isThereAWarningMessagge() {
		// TODO Auto-generated method stub

	}

}
