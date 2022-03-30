package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OraganizationPage {
	
//	public OraganizationPage(WebDriver driver) {
//		PageFactory.initElements(driver, this);
//	}
	
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createOrganizationImage;

	public WebElement getCreateOrganizationImage() {
		return createOrganizationImage;
	}
	
	

}
