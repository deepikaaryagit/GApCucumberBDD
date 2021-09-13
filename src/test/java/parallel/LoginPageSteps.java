package parallel;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import com.gap.factory.DriverFactory;
import com.gap.pages.LoginPage;
import com.gap.utils.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginPageSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private String expectedGreetings;
	@Given("user enters the url {string}")
	public void user_enters_the_url(String string) {

		DriverFactory.getDriver().get("http://www.gap.com");
	}

	@Given("user clicks on Sign In Link")
	public void user_clicks_on_sign_in_link() {

		// Close the initial popup
		loginPage.clickOnPopUpClose();

		// Clicks on your account link
		loginPage.clickOnYourAccountLink();

		// Click on the sign In Button
		loginPage.clickOnSignInLink();
	}

	@Given("user enters the emailId as {string}")
	public void user_enters_the_email_id_as(String emailId) {
		// Enter email address
		loginPage.enterEmailAddress(emailId);
		// Click Continue Button
		loginPage.clickContinueButton();
	}

	@Given("user enters the password as {string}")
	public void user_enters_the_password_as(String password) {
		// Enter password
		loginPage.enterPassword(password);
	}

	@Given("user clicks on Sign In Button")
	public void user_clicks_on_sign_in_button() {

		loginPage.clickOnSignOnButton();
	}

	@Then("user is navigated to signin page")
	public void user_is_navigated_to_signin_page() {
	}

	@Then("user is able to see greetings as {string}")
	public void user_is_able_to_see_greetings_as(String expectedGreetings) throws InterruptedException {

		String actualGreetings = loginPage.getGreetings();
		System.out.println("********Actual Greetings is equal to  :" + actualGreetings);
		Assert.assertEquals(expectedGreetings, actualGreetings);

	}

	@Given("user enters the emailId and password from {string} sheet and row Number {int}")
	public void user_enters_the_email_id_and_password_from_sheet_and_row_number(String sheetName, Integer rowNumber)
			throws InvalidFormatException, IOException {
	
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData("TestData.xlsx", sheetName);
		System.out.println("*****Test Data : " + testData);
		String emailId = testData.get(rowNumber).get("emailId");
		System.out.println("*****Test Data  - Email Id: " + emailId);
		user_enters_the_email_id_as(emailId);
		
		String password = testData.get(rowNumber).get("password");
		System.out.println("*****Test Data  - password: " + password);
		user_enters_the_password_as(password);
		user_clicks_on_sign_in_button();
		
		expectedGreetings = testData.get(rowNumber).get("greetings");
		System.out.println("*****Test Data  - greetings: " + expectedGreetings);
		
		
	}

	@Then("user is able to see greetings")
	public void user_is_able_to_see_greetings() {
		String actualGreetings = loginPage.getGreetings();
		System.out.println("********Actual Greetings is equal to  :" + actualGreetings);
		Assert.assertEquals(expectedGreetings, actualGreetings);
	}

}
