package com.endava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ContactUsPage extends BasePage {

	public By contactButtons = By.id("contact-buttons");
	public By sharedButtons = By.className("share-field light");
	public By radioButton = By.xpath("//*[@id=\"contact-form\"]/fieldset[1]/p[1]/label");
	// By.id("services-choice");
	// xpath("//*[@id=\"services-choice\"]");
	/// html/body/section[3]/div/div/div/form/fieldset[1]/p[1]/label
	public By radioButton2 = By.id("join-team");

	protected ContactUsPage(WebDriver driver) {
		super(driver);
	}

	public void isPageOpen() {
		Assert.assertNotEquals(driver.getCurrentUrl(), ENDAVA_URL);
	}

}
