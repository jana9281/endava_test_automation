/**
 * 
 */
package com.endava.pages;

import java.util.List;

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

	public By emailTextField = By.id("email");
	public By countryNameTextField = By.id("countryRegion");
	public By warningMessage = By.xpath("//*[contains(text(), 'Please enter')]");

	/**
	 * @param driver - WebDriver instance
	 */
	protected CreativeAndUXPage(WebDriver driver) {
		super(driver);
	}

	public void isUrlChanged() {
		Assert.assertFalse(driver.getCurrentUrl().equals(ENDAVA_URL));
	}

	public void scrollDownToContactUsArea() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(this.emailTextField);
		js.executeScript("arguments[0].scrollIntoView();", element);

	}

	public void populateEmailTextField() {
		driver.findElement(this.emailTextField).sendKeys("Aleksandar.Zizovic@endava.com");
	}

	public void populateCountryNameTextField() {
		driver.findElement(this.countryNameTextField).sendKeys("Serbia");

	}

	public void isEmailValid() {
		Assert.assertTrue(driver.findElement(emailTextField).getAttribute("value")
				.matches("^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$"));

	}

	public void isCountryNameValid() {
		Assert.assertTrue(driver.findElement(countryNameTextField).getAttribute("value")
				.matches("[a-zA-Z]+[\\-'\\s]?[a-zA-Z ]+$"));

	}

	/**
	 * @param button - By instance
	 */
	public void clickOnButton(By button) {
		driver.findElement(button).click();
	}

	public List<WebElement> getWarningMessages() {
		return driver.findElements(warningMessage);

	}

	public void isWarningMessageShown() {
		for (WebElement webElement : getWarningMessages()) {
			Assert.assertTrue(webElement.isDisplayed());
		}

	}
}
