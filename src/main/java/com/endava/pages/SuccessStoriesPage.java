package com.endava.pages;

import com.endava.util.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SuccessStoriesPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(SuccessStoriesPage.class);

	public By textSSRCG = By.xpath("/html/body/section[2]/div/div/div[1]/figure/figcaption/p");

	protected SuccessStoriesPage(WebDriver driver) {
		super(driver);
	}

	public void validateSSRCGTitle() {
	    logger.info("Validating Success Stories title is shown");
		Assert.assertTrue(
				WebDriverUtil.findElement(driver, textSSRCG).getText().equalsIgnoreCase("Success Story | Retail and Consumer Goods"));
	}
}
