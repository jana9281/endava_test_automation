package com.endava.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * @author jana.djordjevic@endava.com
 *
 */
public class MenuPage extends BasePage {

	public By navigationList = By.className("navigation");
	public By digitalItem = By.xpath("//a[text()='Digital']");
	public By idustriesItem = By.xpath("//a[text()='Industries']");
	public By successStoriesItem = By.xpath("//a[text()='Success Stories']");
	public By servicesItem = By.xpath("//a[text()='Services']");
	public By navigationListItems = By.xpath("//*[@id=\"mCSB_1_container\"]/div[1]/nav/ul/li");

	public MenuPage(WebDriver driver) {
		super(driver);
	}

	public DigitalPage openDigitalPage() {
		driver.findElement(this.digitalItem).click();
		return new DigitalPage(driver);
	}

	public IndustriesPage openIndustriesPage() {
		driver.findElement(idustriesItem).click();
		return new IndustriesPage(driver);
	}

	public SuccessStoriesPage openSuccessStories() {
		driver.findElement(successStoriesItem).click();
		return new SuccessStoriesPage(driver);
	}

	public ServicesPage openServices() {
		driver.findElement(servicesItem).click();
		return new ServicesPage(driver);
	}

	private List<WebElement> getNavigationList() {
		return this.driver.findElements(navigationListItems);
	}

	public void isEnglishMenu() {
		List<String> checkList = new ArrayList<>();
		checkList.add("DIGITAL");
		checkList.add("AGILE");
		checkList.add("AUTOMATION");
		checkList.add("SERVICES");
		checkList.add("INVESTORS");
		checkList.add("INDUSTRIES");
		checkList.add("SUCCESS STORIES");
		checkList.add("ABOUT");

		List<String> navigationList = new ArrayList<>();
		for (WebElement webElement : getNavigationList()) {
			navigationList.add(webElement.getText());
		}

		Assert.assertTrue(navigationList.containsAll(checkList));
	}

	public void isDeutschMenu() {
		List<String> checkList = new ArrayList<>();
		checkList.add("DIGITAL");
		checkList.add("AGILE");
		checkList.add("AUTOMATION");
		checkList.add("DIENSTLEISTUNGEN");
		checkList.add("INVESTOREN");
		checkList.add("BRANCHEN");
		checkList.add("FALLSTUDIEN");
		checkList.add("ÜBER UNS");

		List<String> navigationList = new ArrayList<>();
		for (WebElement webElement : getNavigationList()) {
			navigationList.add(webElement.getText());
		}

		Assert.assertTrue(navigationList.containsAll(checkList));
	}
}
