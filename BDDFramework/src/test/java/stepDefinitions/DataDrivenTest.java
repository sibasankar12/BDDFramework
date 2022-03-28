package stepDefinitions;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

//To import all ctrl+Shift+O
public class DataDrivenTest {
	WebDriver driver;
	@Given("launch {string} browser")
	public void launch_browser(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else{
			System.out.println("Enter valid browser name: "+browser);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Given("Enter url {string}")
	public void enter_url(String url) {
		driver.get(url);
	}
	@Given("In login page enter username {string} and password {string}")
	public void in_login_page_enter_username_and_password(String username, String password) {
		driver.findElement(By.name("user_name")).sendKeys(username);
	    driver.findElement(By.name("user_password")).sendKeys(password);
	}
	@Given("click on login")
	public void click_on_login() {
		driver.findElement(By.id("submitButton")).click();
	}
	@When("Home page is displayed click on create organization")
	public void home_page_is_displayed_click_on_create_organization() {
		driver.findElement(By.linkText("Organizations")).click();
	}
	@When("click on create new organization Image icon")
	public void click_on_create_new_organization_image_icon() {
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	}
	@When("enter organization name as {string}")
	public void enter_organization_name_as(String organizationName) {
		int randomNum=new Random().nextInt(1000);
		driver.findElement(By.name("accountname")).sendKeys(organizationName+"_"+randomNum);
		driver.findElement(By.xpath("//*[@title='Save [Alt+S]']")).click();
	}
	@Then("Validate whether organization is created with name {string}")
	public void validate_whether_organization_is_created_with_name(String org) {
		String orgHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		boolean flag=orgHeader.contains(org);
		Assert.assertTrue(flag,"Organization names are not matching");
		driver.quit();
	}

}
