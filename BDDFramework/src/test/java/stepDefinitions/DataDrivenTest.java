package stepDefinitions;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pagefactory.LoginPage;
import util.Base;
import util.Pages;
import util.WebDriverUtil;

//To import all ctrl+Shift+O
public class DataDrivenTest extends WebDriverUtil{
	private Base base;
	public DataDrivenTest(Base base) {
		this.base=base;
	}
//	@Given("launch {string} browser")
//	public void launch_browser(String browser) {
//		if(browser.equalsIgnoreCase("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver=new ChromeDriver();
//		}
//		else if(browser.equalsIgnoreCase("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			driver=new FirefoxDriver();
//		}
//		else{
//			System.out.println("Enter valid browser name: "+browser);
//		}
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	}
	@Given("Enter url {string}")
	public void enter_url(String url) {
		base.driver.get(url);
	}
	@Given("In login page enter username {string} and password {string}")
	public void in_login_page_enter_username_and_password(String username, String password) {
//		base.driver.findElement(By.name("user_name")).sendKeys(username);
//		base.driver.findElement(By.name("user_password")).sendKeys(password);
		Pages.loginPage.loginToCRM(username, password);
	}
	@Given("click on login")
	public void click_on_login() {
		//base.driver.findElement(By.id("submitButton")).click();
		Pages.loginPage.clickOnLoginButton();
	}
	@When("Home page is displayed click on create organization")
	public void home_page_is_displayed_click_on_create_organization() {
//		base.driver.findElement(By.linkText("Organizations")).click();
		Pages.homePage.getOrganizationLink().click();
	}
	@When("click on create new organization Image icon")
	public void click_on_create_new_organization_image_icon() {
		//base.driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		Pages.organizationPage.getCreateOrganizationImage().click();
	}
	@When("enter organization name as {string}")
	public void enter_organization_name_as(String organizationName) {
		int randomNum=new Random().nextInt(1000);
//		base.driver.findElement(By.name("accountname")).sendKeys(organizationName+"_"+randomNum);
//		base.driver.findElement(By.xpath("//*[@title='Save [Alt+S]']")).click();
		Pages.createNewOrganizationPage.getOrganizationNameTF().sendKeys(organizationName+"_"+randomNum);
		Pages.createNewOrganizationPage.getSaveButton().click();
	}
	@Then("Validate whether organization is created with name {string}")
	public void validate_whether_organization_is_created_with_name(String org) {
		//String orgHeader=base.driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		String orgHeader=Pages.organizationInformationPage.getOrganizationHeaderText().getText();
		boolean flag=orgHeader.contains(org);
		Assert.assertTrue(flag,"Organization names are not matching");
		//base.driver.quit();
	}

	@When("enter organization name {string}")
	public void enter_organization_name(String orgName) {
		int randomNum=new Random().nextInt(1000);
		//base.driver.findElement(By.name("accountname")).sendKeys(orgName+"_"+randomNum);
		Pages.createNewOrganizationPage.getOrganizationNameTF().sendKeys(orgName+"_"+randomNum);
	}
	@When("From dropdown select industry type as {string}")
	public void from_dropdown_select_industry_type_as(String industryType) {
		//WebElement industryDropDown=base.driver.findElement(By.name("industry"));
		WebElement industryDropDown=Pages.createNewOrganizationPage.getIndustryDropDown();
//		Select select=new Select(industryDropDown);
//		select.selectByValue(industryType);
		dropdownByValue(industryDropDown, industryType);
		//base.driver.findElement(By.xpath("//*[@title='Save [Alt+S]']")).click(); 
		Pages.createNewOrganizationPage.getSaveButton().click();
	}


	@Then("validate the organization name {string} and dropdown {string}")
	public void validate_the_organization_name_and_dropdown(String orgName, String industryType) {
		//String orgHeader=base.driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		String orgHeader=Pages.organizationInformationPage.getOrganizationHeaderText().getText();
		boolean flag=orgHeader.contains(orgName);
		Assert.assertTrue(flag,"Organization names are not matching");
		//String industryWeb=base.driver.findElement(By.xpath("//*[.='Industry']/following-sibling::td/descendant::font[text()]")).getText();
		String industryWeb=Pages.organizationInformationPage.getIndustryTextValue().getText();
		Assert.assertEquals(industryWeb+"    ", industryType,"Both industry names are not matching");
		//base.driver.quit();
	}
	@When("I want to read data from below table")
	public void i_want_to_read_data_from_below_table(io.cucumber.datatable.DataTable dataTable) {
	   System.out.println(dataTable);
	   List<List<String>> data = dataTable.asLists();
	   System.out.println(data.get(1));
	   System.out.println(data.get(1).get(1));
	   System.out.println(data.get(2).get(0));
	   //workbook.getRow().getCell().getStringCellValue();
	}

}
