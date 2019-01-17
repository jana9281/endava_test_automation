package com.endava.pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.endava.util.WebDriverUtil;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(HomePage.class);

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void open() {
	    logger.info("Opening {}", ENDAVA_URL);
		driver.get(ENDAVA_URL);
		driver.manage().window().maximize();
		WebDriverUtil.waitForVisible(driver, 5, contactButtons);
	}

	public MenuPage openMenu() {
        logger.info("Opening burger menu");
		WebDriverUtil.findElement(driver, burgerMenu).click();
		MenuPage menuPage = new MenuPage(driver);
		WebDriverUtil.waitForVisible(driver, 5, menuPage.navigationList);
		return menuPage;
	}

	public AutomationAndEngineeringPage openAutomationAndEngineeringPage() {
        logger.info("Opening Automation And Engineering page");
	    WebDriverUtil.findElement(driver, automationAndEngineering).click();
		return new AutomationAndEngineeringPage(driver);
	}

	public CloudPage openCloudPage() {
        logger.info("Opening Cloud page");
        WebDriverUtil.findElement(driver, cloud).click();
		return new CloudPage(driver);
	}

	public InsightsThroughDataPage openInsightsThroughDataPage() {
        logger.info("Opening Insights Through Data page");
	    WebDriverUtil.findElement(driver, insightsThroughDataLink).click();
		return new InsightsThroughDataPage(driver);
	}

}
