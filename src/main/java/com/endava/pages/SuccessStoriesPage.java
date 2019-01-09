package com.endava.pages;

import com.endava.util.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SuccessStoriesPage extends BasePage {

	public By textSSRCG = By.xpath("/html/body/section[2]/div/div/div[1]/figure/figcaption/p");

	protected SuccessStoriesPage(WebDriver driver) {
		super(driver);
	}

	public void validateSSRCGTitle() {
		Assert.assertTrue(
				WebDriverUtil.findElement(driver, textSSRCG).getText().equalsIgnoreCase("Success Story | Retail and Consumer Goods"));
	}
}
