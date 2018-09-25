package com.endava.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
	private static final String ON_ENGLISH = "SERVICES";
	private static final String ON_DEUTSCH = "DIENSTLEISTUNGEN";
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

	public void englishIsShown() {
		String text = driver.findElement(servicesItem).getText();
		Assert.assertEquals(text, ON_ENGLISH);
	}

	public void deutschIsShown() {
		String text = driver.findElement(servicesItemDeutsch).getText();
		Assert.assertEquals(text, ON_DEUTSCH);
	}

	public static void compareArrays(String[] array1, String[] array2) {
		boolean b = true;
		if (array1 != null && array2 != null) {
			if (array1.length != array2.length)
				b = false;
			else
				for (int i = 0; i < array2.length; i++) {
					if (array2[i] != array1[i]) {
						b = false;
					}
				}
		} else {
			b = false;
		}
		System.out.println(b);
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
		List<String> list2 = new ArrayList<>();
		list2.add(driver.findElement(burgerOptions).getText());
		Assert.assertEquals(list, list2);
	}
}
