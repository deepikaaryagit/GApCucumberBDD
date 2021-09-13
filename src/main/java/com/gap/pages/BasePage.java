package com.gap.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	BasePage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,20);
		
		System.out.println("**********BASEPAGE********* : " + getClass());
		
		
	}

}
