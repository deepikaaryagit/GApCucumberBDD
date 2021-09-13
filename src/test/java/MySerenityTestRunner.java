
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import net.serenitybdd.cucumber.CucumberWithSerenity;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		dryRun = false,
		glue = { "parallel"},
		features = { "src/test/resources/parallel" },
		plugin = {"pretty",
				"html:target/cucumber-html-report.html",
				"json:target/cucumber.json",
				"junit:target/cucumber.xml",
				//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
			//	"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html",
				
				"timeline:test-output-thread/",
				"rerun:target/failedTestcases.txt"
						}, 
		//tags = "@positive",
		monochrome = true
	
	
)

public class MySerenityTestRunner extends AbstractTestNGCucumberTests{

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios(){
		return super.scenarios();
		
	}
}
