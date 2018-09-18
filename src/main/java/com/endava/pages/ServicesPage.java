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

	public By strategyMenuOption = By.cssSelector(
			"body > section.servicelist-section.text-center.cropped > div > div > div:nth-child(1) > figure > figcaption > p");

	public ServicesPage(WebDriver driver) {
		super(driver);
	}

	public void strategyIsShown() {
		if (driver.findElement(By.xpath("/html/body/section[2]/div/div/div[1]/figure/figcaption/p")).isDisplayed())
			System.out.println("Strategy menu option is shown.");
		else
			System.out.println("Strategy menu option isn't shown.");
	}

}
