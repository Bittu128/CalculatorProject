package TestRunner;
import cucumber.api.testng.TestNGCucumberRunner;
//import cucumber.junit.Cucumber;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;

//import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//@RunWith(Cucumber.class)
@CucumberOptions(
        //features =  {"Features/MyTest2.feature", "Features/MyTest.feature" },
		features =  {"src/test/resources/stories/calculator.feature"},
		glue = {"storyClass"},
       // tags = {"~@Ignore"},
        plugin = {
                "pretty",
                "html:target/site/cucumber-reports/cucumber-pretty",
                "json:target/site/cucumber-reports/CucumberTestReport.json",
                "rerun:target/site/cucumber-reports/rerun.txt"
        },
        monochrome = true)
public class mySampleStory extends AbstractTestNGCucumberTests {
 
}
