package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import onBuy_com.OSA.genericUtilities.WebActionUtility;

public class AdminEditSubCategoryPage extends WebActionUtility {

	@FindBy(name="category")
	private WebElement categoryDD;

	@FindBy(name="subcategory")
	private WebElement subCategoryTxtFld;
	
	@FindBy(xpath="//button[.='Update']")
	private WebElement updateBtn;
	
	@FindBy(xpath="//div[contains(@class,'alert alert-success')]")
	private WebElement validateTxt;

	public WebElement getCategoryDD() {
		return categoryDD;
	}

	public WebElement getSubCategoryTxtFld() {
		return subCategoryTxtFld;
	}

	public WebElement getUpdateBtn() {
		return updateBtn;
	}
	
	
	public WebElement getValidateTxt() {
		return validateTxt;
	}

	public AdminEditSubCategoryPage(WebDriver driver) throws Throwable
	{
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Business Libraries
	 */
	public String editSubCategory( String category, String editSubCategory)
	{
		this.select(categoryDD, category);
		subCategoryTxtFld.clear();
		subCategoryTxtFld.sendKeys(editSubCategory);
		updateBtn.click();
		
		return validateTxt.getText();
		
	}
	
	
	
}
