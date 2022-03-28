package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	WebDriver driver;
	@Given("I will launch browser")
	public void i_will_launch_browser() {
	    WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Given("I will enter the url")
	public void i_will_enter_the_url() {
	    driver.get("http://localhost:8888");
	}

	@When("login page is displayed I will enter  username and password")
	public void login_page_is_displayed_i_will_enter_username_and_password() {
	    driver.findElement(By.name("user_name")).sendKeys("admin");
	    driver.findElement(By.name("user_password")).sendKeys("admin");
	}

	@When("I will click on login")
	public void i_will_click_on_login() {
	    driver.findElement(By.id("submitButton")).click();
	}

	@Then("I will validate whether home page is displayed or not")
	public void i_will_validate_whether_home_page_is_displayed_or_not() {
	   String title= driver.getTitle().trim();
	   Assert.assertEquals(title, "Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM");
	   driver.close();
	}
	
	@When("login page is displayed enter invalid username and password")
	public void login_page_is_displayed_enter_invalid_username_and_password() {
		driver.findElement(By.name("user_name")).sendKeys("admin123");
	    driver.findElement(By.name("user_password")).sendKeys("admin123");
	}
	@Then("Validate error message is displayed or not")
	public void validate_error_message_is_displayed_or_not() {
	   String msg = driver.findElement(By.xpath("//div[@class='errorMessage']")).getText().trim();
	   Assert.assertEquals(msg, "You must specify a valid username and password.");
	   driver.quit();
	}

}
