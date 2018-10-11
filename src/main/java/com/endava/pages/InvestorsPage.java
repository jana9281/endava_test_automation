/**
 * 
 */
package com.endava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Denis.Selimovski
 *
 */
public class InvestorsPage extends BasePage {

	public By footerInvestors = By.className("layout_footer");
	public By servicesSectionInvestors = By.xpath("//*[@id=\"_ctrl0_ctl42_divModuleContainer\"]/div/div/div/div[1]");
	public By industriesSectionInvestors = By.xpath("//*[@id=\"_ctrl0_ctl42_divModuleContainer\"]/div/div/div/div[3]");
	public By companySectionInvestors = By.xpath("//*[@id=\"_ctrl0_ctl42_divModuleContainer\"]/div/div/div/div[4]");
	public By endavaLogoInvestors = By.xpath("//*[@id=\"_ctrl0_ctl51_divModuleContainer\"]/div/div/a");

	public InvestorsPage(WebDriver driver) {
		super(driver);
	}

}
