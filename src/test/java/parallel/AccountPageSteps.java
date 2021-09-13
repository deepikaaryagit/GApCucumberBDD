package parallel;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.gap.factory.DriverFactory;
import com.gap.pages.AccountPage;
import com.gap.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountPageSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountPage accountPage;
	
	@Given("user has already logged into the application")
	public void user_has_already_logged_into_the_application(DataTable dataTable) {
	
		List<Map<String, String>> credList = dataTable.asMaps();
		String emailId = credList.get(0).get("emailId");
		String password = credList.get(0).get("password");
		
		DriverFactory.getDriver().get("http://www.gap.com");
		
		System.out.println("***Email Id :" + emailId + " ***Password :" + password);
		accountPage=loginPage.doLogin(emailId, password);
		
	}

	
	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
		System.out.println("user is on Accounts Page");
		
	}

	
	@Then("user can see the accounts sections")
	public void user_can_see_the_accounts_sections(DataTable accountSectionsTable) {
	  
		List<String> expAccountSectionList = accountSectionsTable.asList();
		System.out.println("*******expAccountSectionList :"  + expAccountSectionList);
		
		
		List<String> actAccountSectionList = accountPage.getAccountSectionList();
		
		System.out.println("*******actAccountSectionList :"  + actAccountSectionList);
		
		Assert.assertTrue(expAccountSectionList.containsAll(actAccountSectionList));
	}

	@Then("account section count should be {int}")
	public void account_section_count_should_be(Integer expSize) {
		System.out.println("***Exp Size : " + expSize );
		Assert.assertTrue(expSize == accountPage.getAccountSectionCount());
	  
	}

	
}
