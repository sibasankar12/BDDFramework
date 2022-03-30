package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganizationPage {
	//initialization code present in util.pages class
//	public CreateNewOrganizationPage(WebDriver driver) {
//		PageFactory.initElements(driver, this);
//	}
	
	@FindBy(name="accountname")
	private WebElement organizationNameTF;
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public WebElement getOrganizationNameTF() {
		return organizationNameTF;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	

}
