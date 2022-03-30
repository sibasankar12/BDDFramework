package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {".\\src\\test\\java\\features"},
		glue= {"stepDefinitions"},
		dryRun = false,//map feature file and stepDefinition for missing steps
		plugin = {"pretty","html:cucumber.html",
				"json:cucumber-json.json"},//used to print the scenario steps in console 
		//and also used for report generation
		monochrome = true//To remove special character in console o/p 	
		//tags = "not @RegressionTest"
		)
public class RunnerIO extends AbstractTestNGCucumberTests{
//@RegressionTest and @End2End:- if the secenario's having both tags then it will execute
//@RegressionTest or @End2End:- works for scenario's which is having either
	//any one the tag
}
