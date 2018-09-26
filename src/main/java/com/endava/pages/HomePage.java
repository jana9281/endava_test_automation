package com.endava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author jana.djordjevic@endava.com
 *
 */
public class HomePage extends BasePage {

	public By contactButtons = By.id("contact-buttons");
	public By burgerMenu = By.id("menu-toggle");
	public By creativeAndUXItem = By.xpath("//*[@id=\"footer\"]/section[1]/div/div[1]/ul/li[6]/a");

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void open() {
		driver.get(ENDAVA_URL);
		driver.manage().window().maximize();
	}

	public MenuPage openMenu() {
		driver.findElement(this.burgerMenu).click();
		return new MenuPage(driver);
	}

	/**
	 * 
	 */
	public void scrollDownAtTheBottomOfThePage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(creativeAndUXItem);
		js.executeScript("arguments[0].scrollIntoView();", element);

	}

	/**
	 * @return
	 */
	public CreativeAndUXPage openCreativeAndUXPage() {
		driver.findElement(this.creativeAndUXItem).click();
		return new CreativeAndUXPage(driver);
	}
}