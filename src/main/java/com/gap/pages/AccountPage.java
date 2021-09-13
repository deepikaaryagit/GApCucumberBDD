package com.gap.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountPage extends BasePage {

	public AccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div//h2")
	List<WebElement> accountSections;
	

public List<String> getAccountSectionList() {
	
	wait.until(ExpectedConditions.visibilityOfAllElements(accountSections));
	List<String> accountList = new ArrayList<>();
	for(WebElement we : accountSections)
	{
		
		accountList.add(we.getText());
		
	}
	
	return accountList;
	
	
}
	
public int getAccountSectionCount() {
	return accountSections.size();
}
	
	/*
	 * @FindBy(xpath="//h2[text()='Account Details']") WebElement
	 * accountSectionAccountDetails;
	 * 
	 * 
	 * @FindBy(xpath="//h2[text()='Orders & Returns']") WebElement
	 * accountSectionOrderAndReturns;
	 * 
	 * 
	 * @FindBy(xpath="//h2[text()='Wallet']") WebElement accountSectionWallet;
	 * 
	 * 
	 * public String getAccountSectionDetails() { return
	 * accountSectionAccountDetails.getText(); }
	 * 
	 * public String getAccountSectionOrderAndReturns() { return
	 * accountSectionOrderAndReturns.getText(); }
	 * 
	 * public String getAccountSectionWallet() { return
	 * accountSectionWallet.getText(); }
	 */
	
}
