package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {".\\src\\test\\java\\features\\DataDriven.feature"},
		glue= {"stepDefinitions"},
		dryRun = false//map feature file and stepDefinition for missing steps
		)
public class RunnerIO extends AbstractTestNGCucumberTests{

}
