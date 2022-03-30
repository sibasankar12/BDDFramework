package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {".\\src\\test\\java\\features\\DataDriven.feature"},
		glue= {"stepDefinitions"},
		dryRun = false,//map feature file and stepDefinition for missing steps
		plugin = {"pretty"},//used to print the scenario steps in console 
		//and also used for report generation
		monochrome = true//To remove special character in console o/p 	
		)
public class RunnerIO extends AbstractTestNGCucumberTests{

}
