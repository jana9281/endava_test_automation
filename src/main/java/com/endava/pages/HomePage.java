package com.endava.pages;

import com.endava.util.WebDriverUtil;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void open() {
		driver.get(ENDAVA_URL);
		driver.manage().window().maximize();
		WebDriverUtil.waitForVisible(driver, 5, contactButtons);
	}

	public MenuPage openMenu() {
		WebDriverUtil.findElement(driver, burgerMenu).click();
		MenuPage menuPage = new MenuPage(driver);
		WebDriverUtil.waitForVisible(driver, 5, menuPage.navigationList);
		return menuPage;
	}

	public AutomationAndEngineeringPage openAutomationAndEngineeringPage() {
		WebDriverUtil.findElement(driver, automationAndEngineering).click();
		return new AutomationAndEngineeringPage(driver);
	}

	public CloudPage openCloudPage() {
        WebDriverUtil.findElement(driver, cloud).click();
		return new CloudPage(driver);
	}

}
