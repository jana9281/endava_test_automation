
package com.endava.pages;

import java.util.ArrayList;
import java.util.Collections;
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
	public By warningMessageFirstName = By.xpath("//*[@id=\"firstname\"]/following-sibling::div");
	public By warningMessageLastName = By.xpath("//*[@id=\"lastname\"]/following-sibling::div");
	public By warningMessageEmail = By.xpath("//*[@id=\"email\"]/following-sibling::div");
	public By warningMessageCompany = By.xpath("//*[@id=\"company\"]/following-sibling::div");
	public By warningMessageCountry = By.xpath("//*[@id=\"countryRegion\"]/following-sibling::div");
	public static final String EMAIL = "Aleksandar.Zizovic@endava.com";
	public static final String COUNTRY = "Serbia";
	public static final String REGEX_EMAIL = "^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
	public static final String REGEX_COUNTRY = "[a-zA-Z]+[\\-'\\s]?[a-zA-Z ]+$";

	/**
	 * @param driver - WebDriver instance
	 */
	protected CreativeAndUXPage(WebDriver driver) {
		super(driver);
	}

	public void isUrlChanged() {
		Assert.assertNotEquals(driver.getCurrentUrl(), ENDAVA_URL);
	}

	public void scrollDownToContactUsArea() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(this.emailTextField);
		js.executeScript("arguments[0].scrollIntoView();", element);

	}

	public void populateEmailTextField(String email) {
		driver.findElement(this.emailTextField).sendKeys(email);
	}

	public void populateCountryNameTextField(String country) {
		driver.findElement(this.countryNameTextField).sendKeys(country);

	}

	public void isEmailValid() {
		Assert.assertTrue(driver.findElement(emailTextField).getAttribute("value").matches(REGEX_EMAIL));

	}

	public void isCountryNameValid() {
		Assert.assertTrue(driver.findElement(countryNameTextField).getAttribute("value").matches(REGEX_COUNTRY));

	}

	/**
	 * @param button - By instance
	 */
	public void clickOnButton(By button) {
		driver.findElement(emailTextField).clear();
		driver.findElement(countryNameTextField).clear();
		driver.findElement(button).click();
	}

//	public List<WebElement> getWarningMessages() {
//		return driver.findElements(warningMessage);
//
//	}

	public void isWarningMessageShown() {
		List<String> checkList = new ArrayList<>();
		checkList.add("Please enter First Name");
		checkList.add("Please enter Last Name");
		checkList.add("Please enter Email Address");
		checkList.add("Please enter Company");
		checkList.add("Please enter Country/Region");

		List<String> messageList = new ArrayList<>();
		messageList.add(this.driver.findElement(warningMessageFirstName).getText());
		messageList.add(this.driver.findElement(warningMessageLastName).getText());
		messageList.add(this.driver.findElement(warningMessageEmail).getText());
		messageList.add(this.driver.findElement(warningMessageCompany).getText());
		messageList.add(this.driver.findElement(warningMessageCountry).getText());

		Collections.sort(checkList);
		Collections.sort(messageList);
		Assert.assertTrue(checkList.equals(messageList));
	}
}
