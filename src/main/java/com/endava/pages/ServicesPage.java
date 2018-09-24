/**
 * 
 */
package com.endava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Denis.Selimovski
 *
 */
public class ServicesPage extends BasePage {

	public By strategyMenuOption = By.xpath("//a[text()='Strategy']");

	public ServicesPage(WebDriver driver) {
		super(driver);
	}
}
