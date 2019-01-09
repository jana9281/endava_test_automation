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
		return new MenuPage(driver);
	}

	public AutomationAndEngineeringPage openAutomationAndEngineeringPage() {
		WebDriverUtil.findElement(driver, automationAndEngineering).click();
		return new AutomationAndEngineeringPage(driver);
	}

}
