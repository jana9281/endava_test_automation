package com.endava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author jana.djordjevic@endava.com
 *
 */
public class MenuPage extends BasePage {

	public By navigationList = By.className("navigation");
	public By idustriesItem = By.xpath("//a[text()='Industries']");
	public By successStoriesItem = By.xpath("//a[text()='Success Stories']");
	public By servicesItem = By.xpath("//a[text()='Services']");
	public By digitalItem = By.xpath("//a[text()='Digital']");
	public By agileItem = By.xpath("//a[text()='Agile']");
	public By automationItem = By.xpath("//a[text()='Automation']");
	public By investorsItem = By.xpath("//a[text()='Investors']");
	public By aboutItem = By.xpath("//a[text()='About']");
	public By careersItem = By.xpath("//a[text()='Careers']");
	public By contactItem = By.xpath("//a[text()='Contact']");

	public MenuPage(WebDriver driver) {
		super(driver);
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

	public DigitalPage openDigitalPage() {
		driver.findElement(digitalItem).click();
		return new DigitalPage(driver);
	}

	public AgilePage openAgilePage() {
		driver.findElement(agileItem).click();
		return new AgilePage(driver);
	}

	public AutomationPage openAutomationPage() {
		driver.findElement(automationItem).click();
		return new AutomationPage(driver);
	}

	public InvestorsPage openInvestorsPage() {
		driver.findElement(investorsItem).click();
		return new InvestorsPage(driver);
	}

	public AboutPage openAboutPage() {
		driver.findElement(aboutItem).click();
		return new AboutPage(driver);
	}

	public CareersPage openCareersPage() {
		driver.findElement(careersItem).click();
		return new CareersPage(driver);
	}

	public ContactPage openContactPage() {
		driver.findElement(contactItem).click();
		return new ContactPage(driver);
	}

}
