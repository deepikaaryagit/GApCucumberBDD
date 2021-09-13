package com.gap.pages;

import org.openqa.selenium.By.ById;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

	private @FindBy(xpath = "//button[@class='sitewide-1qosac6']") WebElement popUpClose;

	private @FindBy(xpath = "//div[text()='Your Account']") WebElement yourAccountLink;

	private @FindBy(xpath = "//a[text()='Sign In']") WebElement signInLink;

	private @FindBy(id = "verify-account-email") WebElement emailAddress;

	private @FindBy(xpath = "//button[text()='Continue']") WebElement continueButton;

	private @FindBy(xpath = "//input[@id='password']") WebElement password;

	private @FindBy(xpath = "//input[@name='email']") WebElement emailIdOnPOPup;
	
	private @FindBy(xpath = "//a[contains(text(),'SIGN IN')]") WebElement signOnButton;
	
	private @FindBy(xpath = "//div[@id='profile-root']//h3[@id='rewardsHeading']") WebElement greetings;
	
	
	

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	public void clickOnPopUpClose() {
		wait.until(d->popUpClose.isDisplayed());
		popUpClose.click();
	}

	public void clickOnYourAccountLink() {

		yourAccountLink.click();

	}

	public void clickOnSignInLink() {

		signInLink.click();

	}

	public void enterEmailAddress(String emailId) {
		wait.until(d->emailAddress.isDisplayed());
		emailAddress.sendKeys(emailId);

	}

	public void clickContinueButton() {

		continueButton.click();

	}
	
	public void enterPassword(String pwd)  {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("oidcFrame")));
		driver.switchTo().frame("oidcFrame");
		wait.until(d->password.isDisplayed());
		password.sendKeys(pwd);

	}
	
	public void clickOnSignOnButton() {
		wait.until(d->signOnButton.isDisplayed());
		signOnButton.click();
		
	}
	
	public String getGreetings() {
		wait.until(d->greetings.isDisplayed());
		driver.switchTo().defaultContent();
		return greetings.getText();
	
	}
	
	public String getPageTitle(String expTitle) {

		System.out.println("***Get page title in login page");
		wait.until(ExpectedConditions.titleIs(expTitle));
		return driver.getTitle();

	}

	
	public AccountPage doLogin(String emailId, String password)
	{
		clickOnPopUpClose();
		clickOnYourAccountLink();
		signInLink.click();
		enterEmailAddress(emailId);
		clickContinueButton();
		enterPassword(password);
		clickOnSignOnButton();
		return new AccountPage(driver);
	}
	

}
