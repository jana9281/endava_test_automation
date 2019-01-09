package com.endava.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWrapper {

	public static void setUpDriver(String browser) {
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			break;
		}
	}

	public static WebDriver createDriver(String browser) {
		WebDriver driver = null;
		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "ie":
			driver = new InternetExplorerDriver();
			break;
		}
		return driver;
	}
}
