package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import onBuy_com.OSA.genericUtilities.WebActionUtility;

public class AdminCreateCategoryPage {
	
	@FindBy(name="category")
	private WebElement categoryTxtFld;
	
	@FindBy(name="DataTables_Table_0_length")
	private WebElement showEntriesDD;
	
	@FindBy(xpath="//input[@aria-controls='DataTables_Table_0']")
	private WebElement searchTxtfld;
	
	@FindBy(xpath="//button[.='Create']")
	private WebElement createBtn;
	
	@FindBy(xpath="//tbody[@role='alert']/tr[last()]/descendant::i[@class='icon-edit']")
	private WebElement editIcon;
	
	@FindBy(xpath="//tbody[@role='alert']/tr[last()]/descendant::i[@class='icon-remove-sign']")
	private WebElement deleteIcon;
	
	@FindBy(xpath="//div[contains(@class,'alert alert-success')]")
	private WebElement validateTxt;
	
	@FindBy(xpath="//div[contains(@class,'alert alert-error')]")
	private WebElement validatedelTxt;
	
	

	//Initialize it
	public AdminCreateCategoryPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		
	}

	//getter
	public WebElement getEditIcon() {
		return editIcon;
	}

	public WebElement getDeleteIcon() {
		return deleteIcon;
	}

	public WebElement getValidateTxt() {
		return validateTxt;
	}
	
	public WebElement getCategoryTxtFld() {
		return categoryTxtFld;
	}

	public WebElement getShowEntriesDD() {
		return showEntriesDD;
	}

	public WebElement getSearchTxtfld() {
		return searchTxtfld;
	}

	public WebElement getCreateBtn() {
		return createBtn;
	}


	//bussiness libraries
	/**
	 * THis method will accept value and pass it in the category field and click on create button
	 * @param value
	 */
	public String createCategory(String value)
	{
		categoryTxtFld.sendKeys(value);
		createBtn.click();
		
		return validateTxt.getText();
		
	}
	
	/**
	 * This method will accept value which should be passed and enters it in category text field
	 * @param value
	 */
	public void enterCategoryName(String value) {
		categoryTxtFld.sendKeys(value);
		
	}
	/**
	 * This method helps us to handle the Show Entries dropDown by 10,25,50, 100
	 * @param num
	 */
	public void selectShowEntries(String entryValue)
	{
		Select sel= new Select(showEntriesDD);
		sel.selectByVisibleText(entryValue);
	}
	
	/**
	 * This method helps us to handle the Show Entries dropDown by 10,25,50, 100
	 * @param num
	 */
	public void selectShowEntries(WebActionUtility wLib,   int indexNum)
	{
		wLib.select(showEntriesDD,indexNum);
		
	}
	
	public void searchCategory(String value)
	{
		
		searchTxtfld.sendKeys(value);
		
		
	}
	
	/**
	 * This method will search and click on edit icon
	 * @param value
	 */
	public void searchAndclickOnEditCategory( String value)
	{
		searchTxtfld.sendKeys(value);
		editIcon.click();
	}
	/**
	 * this method will search and delete the category
	 * @param driver
	 * @param value
	 */
	public String searchAndDeleteCategory(WebDriver driver, String value)
	{
		searchTxtfld.sendKeys(value);
		deleteIcon.click();
		driver.switchTo().alert().accept();
	return validatedelTxt.getText();
		
	}
	

}
