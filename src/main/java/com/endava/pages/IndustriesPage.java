package com.endava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class IndustriesPage extends BasePage {
	
	public String path="//a[text()='Finance']";
	public By finance = By.xpath(path);
	
	public IndustriesPage(WebDriver driver) {
		super(driver);
	}
	
public void checkRead() {
	Assert.assertTrue(driver.findElement(finance).isDisplayed());
		 }
}
