package objectRepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import onBuy_com.OSA.genericUtilities.WebActionUtility;

public class AdminSubCategoryPage extends WebActionUtility{

	WebDriverWait wait=null;
	
	public AdminSubCategoryPage(WebDriver driver) throws Throwable
	{
		PageFactory.initElements(driver, this);
		wait= new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	
	
	@FindBy(name="category")
	private WebElement categoryDD;
	
	@FindBy(xpath="//input[@name='subcategory']")
	private WebElement subCategoryTxtFld;
	
	@FindBy(xpath="//button[.='Create']")
	private WebElement createBtn;
	
	@FindBy(name="DataTables_Table_0_length")
	private WebElement showEntriesDD;
	
	@FindBy(xpath="//input[@aria-controls='DataTables_Table_0']")
	private WebElement searchTxtFld;
	
	@FindBy(xpath="//tbody[@role='alert']/tr[last()]/descendant::i[@class='icon-edit']")
	private WebElement editIcon;
	
	@FindBy(xpath="//tbody[@role='alert']/tr[last()]/descendant::i[@class='icon-remove-sign']")
	private WebElement deleteIcon;
	
	@FindBy(xpath="//div[contains(@class,'alert alert-success')]")
	private WebElement validateTxt;
	
	@FindBy(xpath="//div[contains(@class,'alert alert-error')]")
	private WebElement validatedeleteTxt;
	

	public WebElement getValidatedeleteTxt() {
		return validatedeleteTxt;
	}

	public WebElement getValidateTxt() {
		return validateTxt;
	}

	public WebElement getCategoryDD() {
		return categoryDD;
	}

	public WebElement getSubCategoryTxtFld() {
		return subCategoryTxtFld;
	}

	public WebElement getCreateBtn() {
		return createBtn;
	}

	public WebElement getShowEntriesDD() {
		return showEntriesDD;
	}

	public WebElement getSearchTxtFld() {
		return searchTxtFld;
	}
	
	
	public WebElement getDeleteIcon() {
		return deleteIcon;
	}

	public WebElement getEditIcon() {
		return editIcon;
	}

	//Business Libraries
	/**
	 * this method will help us to create a sub category
	 * @param wLib
	 * @param categoryName
	 * @param subCategoryName
	 * @throws InterruptedException 
	 */
	public String createSubCategory(WebActionUtility wLib, String categoryName, String subCategoryName) throws InterruptedException
	{
		
		wLib.select(categoryDD, categoryName);
		wait.until(ExpectedConditions.elementToBeClickable(subCategoryTxtFld)).sendKeys(subCategoryName);;
		createBtn.click();
		
		return validateTxt.getText();
		
	}
	
	public void selectShowEntries( int indexNum)
	{
		this.select(showEntriesDD, indexNum);
	}
	public void selectShowEntries( String visibleText)
	{
		this.select(showEntriesDD, visibleText);
	}
	
	
	
	public void searchSubCategoryAndClickOnEdit(String value)
	{
		
		searchTxtFld.sendKeys(value);
		editIcon.click();
	}
	
	public String searchAndDelete(WebDriver driver, String value)
	{
		searchTxtFld.sendKeys(value);
		deleteIcon.click();
		driver.switchTo().alert().accept();
		return validatedeleteTxt.getText();
		
	}
	
}
