package com.endava.pages;

import com.endava.util.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SuccessStoriesPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(SuccessStoriesPage.class);

    //Not sure which case is valid, so I'll keep both until we declare which one stay
    public static  String SUCCESS_STORY_LABEL = "SUCCESS STORIES";
    //public static String SUCCESS_STORY_LABEL = "SUCCESS STORY | RETAIL AND CONSUMER GOODS";

	//Xpath must be changed
	public By textSSRCG = By.xpath("/html/body/section[1]/div/div/div/div[1]/div/div/div/div[1]/div/h2");
    //public By textSSRCG = By.xpath("//figcaption/p");

	protected SuccessStoriesPage(WebDriver driver) {
		super(driver);
	}

	public void validateSSRCGTitle() {
	    logger.info("Validating Success Stories title is shown");
		Assert.assertEquals(WebDriverUtil.getElementText(driver, textSSRCG), SUCCESS_STORY_LABEL);
	}
}
