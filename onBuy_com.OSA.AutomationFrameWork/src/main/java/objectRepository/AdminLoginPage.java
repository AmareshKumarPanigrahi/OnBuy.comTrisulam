package objectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {

	//
	@FindBy(name="username") 
	private WebElement userNameTxtFld;
	
	@FindBy(name="password") 
	private WebElement passwordTxtFld;
	
	@FindBy(xpath="//button[.='Login']") 
	private WebElement loginBtn;
	
	//Initialize
	WebDriver driver;
	public AdminLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//Provide Getterws
	
	public WebElement getUserNameTxtFld() {
		return userNameTxtFld;
	}

	public WebElement getPasswordTxtFld() {
		return passwordTxtFld;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Bussiness Linrary
	
	/**
	 * This method will login to the application
	 * @param userName
	 * @param Password
	 */
	public void loginToApplication(String userName, String Password)
	{
		
		userNameTxtFld.sendKeys(userName);
		passwordTxtFld.sendKeys(Password);
		loginBtn.click();
		
		
	}
	
	
}
