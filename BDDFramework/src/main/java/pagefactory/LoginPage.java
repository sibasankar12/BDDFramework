package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//5. create a constructor for initializing all the webElements using PageFactory.initElements
//	public LoginPage(WebDriver driver) {
//		PageFactory.initElements(driver, this);
//	}  
	
	//1. identify the element by @FindBy, @FindBys or @FindAll
	//@AndroidFindBy or IOSFindBy
	//2. decalare the webelement or MobileElement ref as private
	@FindBy(name="user_name") private WebElement usernameTF;
	@FindBy(name="user_password") private WebElement passwordTF;
	@FindBy(id="submitButton") private WebElement loginButton;
	
	//3. provide a getter method for private WebElements
	public WebElement getUsernameTF() {
		return usernameTF;
	}
	public WebElement getPasswordTF() {
		return passwordTF;
	}
	public WebElement getLoginButton() {
		return loginButton;
	}
	
	//4. business logic
	public void loginToCRM(String username,String password) {
		usernameTF.sendKeys(username);
		passwordTF.sendKeys(password);
	}
	
	public void clickOnLoginButton() {
		loginButton.click();
	}
	
	
	

}
