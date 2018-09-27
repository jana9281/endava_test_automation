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
	public By servicesItemDeutsch = By.xpath("//*[@id=\"mCSB_1_container\"]/div[1]/nav/ul/li[4]/a");
	public By burgerOptions = By.xpath("//*[@id=\"mCSB_1_container\"]");
	public By navigationMenu = By.xpath("//*[@id=\"mCSB_1_container\"]/div[1]/nav/ul/li");
	private static List<String> listWeb = new ArrayList<>();
	private static List<String> list = new ArrayList<>();

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

	public void isOnEnglish() {
		list.add("DIGITAL");
		list.add("AGILE");
		list.add("AUTOMATION");
		list.add("SERVICES");
		list.add("INVESTORS");
		list.add("INDUSTRIES");
		list.add("SUCCESS STORIES");
		list.add("ABOUT");

		for (WebElement el : getListOfElements(navigationMenu)) {
			listWeb.add(el.getText());
		}
		Assert.assertTrue(listWeb.containsAll(list));
	}

	public void isOnDeutsch() {
		list.add("DIGITAL");
		list.add("AGILE");
		list.add("AUTOMATION");
		list.add("DIENSTLEISTUNGEN");
		list.add("INVESTOREN");
		list.add("BRANCHEN");
		list.add("FALLSTUDIEN");
		list.add("ÜBER UNS");

		for (WebElement element : getListOfElements(navigationMenu)) {
			listWeb.add(element.getText());
		}
		Assert.assertTrue(listWeb.containsAll(list));
	}

}
