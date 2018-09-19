package com.endava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IndustriesPage extends BasePage {
	
	public By pageClick = By.xpath("/html/body/section[2]/div/div/div[1]/div/p/a");
	
	public IndustriesPage(WebDriver driver) {
		super(driver);
	}
	
public void checkRead() {
	 if(driver.getTitle().contains("/html/body/section[2]/div/div/div[1]/div/p/a"));
		System.out.println("true");
		 }
}
