package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
(features=".\\src\\test\\java\\Feature\\addToCart.feature",
glue={"stepDefinitions"},
dryRun=false,
monochrome=true,
plugin={"pretty","html:reports/cucumber.html"})

public class Flipkart   extends AbstractTestNGCucumberTests{

	
}
