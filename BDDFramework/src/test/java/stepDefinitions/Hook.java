package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import util.Base;
import util.Pages;
import util.PropertyFileutil;
import util.WebDriverUtil;

public class Hook extends WebDriverUtil{
	private Base base;
	public Hook(Base base) {
		this.base=base;
	}
//	@Before(order = 0)
//	public void configBefore() {
//		System.out.println("Inside first @Before annotation order:0");
//	}
	
	@Before//(order = 1)
	public void beforeScenario() throws Throwable {
		//System.out.println(" 2nd Execute before each scenario's order:1");
		//String browser=PropertyFileutil.getPropertyValue("browser");
		String browser=System.getProperty("browserName");
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			base.driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			base.driver=new FirefoxDriver();
		}else {
			System.out.println("Invalid browser input from property file: "+browser);
		}
		base.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		base.driver.manage().window().maximize();
		Pages.loadPages(base.driver);
	}
	
	@After//(order=1)
	public void afterScenario(Scenario scenario) throws Throwable {
		//System.out.println("1st Execute after each scenario's order:1");
		if(scenario.isFailed()) {
			//screenshot code
			takeScreenshot(base.driver, scenario.getName());
			TakesScreenshot ts=(TakesScreenshot)(base.driver);
			byte[] imageBytes = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(imageBytes, "image/png", scenario.getName());
		}
		base.driver.close();
	}
	
//	@After(order=0)
//	public void configAfter() {
//		System.out.println("Inside last @After annotation order:0");
//	}

}
