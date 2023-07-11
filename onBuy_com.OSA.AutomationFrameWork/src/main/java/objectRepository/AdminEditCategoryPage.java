package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminEditCategoryPage {

	@FindBy(name="category")
	private WebElement editCategoryFld;
	
	@FindBy(xpath="//button[.='Update']")
	private WebElement updatebtn;
	
	@FindBy(xpath="//div[contains(@class,'alert alert-success')]")
	private WebElement validateTxt;

	public WebElement getValidateTxt() {
		return validateTxt;
	}

	public WebElement getEditCategoryFld() {
		return editCategoryFld;
	}

	public WebElement getUpdatebtn() {
		return updatebtn;
	}
	
	public AdminEditCategoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	/*Bussiness Libraries*/
	public String editCategory(String newCategoryName) 
	{
		editCategoryFld.clear();
		editCategoryFld.sendKeys(newCategoryName);
		updatebtn.click();
		return validateTxt.getText();
		
	}
	

	
	
}
