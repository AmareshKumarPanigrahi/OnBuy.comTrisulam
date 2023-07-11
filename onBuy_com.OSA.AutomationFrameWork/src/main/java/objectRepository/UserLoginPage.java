package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPage {
	
	/*
	 * Elements
	 */
	@FindBy(name="email")
	private WebElement userNameTxtFld;
	
	@FindBy(name="password")
	private WebElement passwordTxtFld;
	
	@FindBy(xpath="//button[.='Login']")
	private WebElement logInBtn;
	
	/*
	 * Initialization
	 */
	WebDriver driver;
	public UserLoginPage(WebDriver driver)
	{
		PageFactory.initElements( driver, this);
	}

	/*
	 * Getters
	 */
	public WebElement getUserNameTxtFld() {
		return userNameTxtFld;
	}

	public WebElement getPasswordTxtFld() {
		return passwordTxtFld;
	}

	public WebElement getLogoutBtn() {
		return logInBtn;
	}
	
	/*Business Libraries*/
	public void loginToApplication(String userName, String password)
	{
		
		userNameTxtFld.sendKeys(userName);
		passwordTxtFld.sendKeys(password);
		logInBtn.click();
	}
	

}
