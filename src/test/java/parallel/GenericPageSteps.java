package parallel;

import org.junit.Assert;

import com.gap.factory.DriverFactory;
import com.gap.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class GenericPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private static String title;
	
		
	@Then("page title should be {string}")
	public void page_title_should_be(String expTitle) {
		 title = loginPage.getPageTitle(expTitle);
	     System.out.println("ExpTitle : " + expTitle  + " ActTitle :" + title);
	     Assert.assertEquals(expTitle, title);
	     }

}
