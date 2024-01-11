package com.endava.pages;

import com.endava.util.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SuccessStoriesPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(SuccessStoriesPage.class);

    public static String SUCCESS_STORY_LABEL = "SUCCESS STORIES";

    public By textSSRCG = By.xpath("/html/body/section[1]/div/div/div/div[1]/div/div/div/div[1]/div/h2");

    protected SuccessStoriesPage(WebDriver driver) {
        super(driver);
    }

    public void validateSSRCGTitle() {
        logger.info("Validating Success Stories title is shown");
        Assert.assertEquals(WebDriverUtil.getElementText(driver, textSSRCG), SUCCESS_STORY_LABEL);
    }
}
