package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	
//	public OrganizationInformationPage(WebDriver driver) {
//		PageFactory.initElements(driver, this);
//	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement organizationHeaderText;
	
	@FindBy(xpath = "//*[.='Industry']/following-sibling::td/descendant::font[text()]")
	private WebElement industryTextValue;

	public WebElement getOrganizationHeaderText() {
		return organizationHeaderText;
	}

	public WebElement getIndustryTextValue() {
		return industryTextValue;
	}
	
	

}
