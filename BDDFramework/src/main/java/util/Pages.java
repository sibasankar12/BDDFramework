package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.google.common.util.concurrent.Service.State;

import pagefactory.CreateNewOrganizationPage;
import pagefactory.HomePage;
import pagefactory.LoginPage;
import pagefactory.OraganizationPage;
import pagefactory.OrganizationInformationPage;

public class Pages {
	//declare all the pages as public and static
	public static LoginPage loginPage;
	public static HomePage homePage;
	public static OraganizationPage organizationPage;
	public static CreateNewOrganizationPage createNewOrganizationPage;
	public static OrganizationInformationPage organizationInformationPage;
	//call loadPages method inside @Before annotation in hook
	public static void loadPages(WebDriver driver) {
		loginPage=PageFactory.initElements(driver, LoginPage.class);
		homePage=PageFactory.initElements(driver, HomePage.class);
		organizationPage=PageFactory.initElements(driver, OraganizationPage.class);
		createNewOrganizationPage=PageFactory.initElements(driver, CreateNewOrganizationPage.class);
		organizationInformationPage=PageFactory.initElements(driver, OrganizationInformationPage.class);
	}

}
