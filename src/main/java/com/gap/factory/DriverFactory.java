package com.gap.factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.WebDriverManagerException;

public class DriverFactory {

	public WebDriver driver;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public WebDriver init_driver(String browser) {

		System.out.println("Browser value is :" + browser);

		if (browser.equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());

		} else if (browser.equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());

		} else if (browser.equals("ie")) {

			WebDriverManager.iedriver().setup();
			tlDriver.set(new InternetExplorerDriver());

		} else if (browser.equals("safari")) {

			WebDriverManager.operadriver().setup();
			tlDriver.set(new SafariDriver());
		} else {

			System.out.println("Please pass the correct browser Value :" + browser);

		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();

	}

	/*
	 * this is used to get the threadlocal driver
	 * 
	 * 
	 */
	public static synchronized WebDriver getDriver() {

		return tlDriver.get();

	}

}
