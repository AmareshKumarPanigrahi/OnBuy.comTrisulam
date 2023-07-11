package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import onBuy_com.OSA.genericUtilities.WebActionUtility;

public class AdminHomePage {
	
	
	@FindBy(xpath="//a[normalize-space(text())='Create Category']")
	private WebElement createCategoryLnk;
	
	@FindBy(xpath="//a[normalize-space(text())='Sub Category']")
	private WebElement subCategoryLnk;
	
	@FindBy(xpath="//a[normalize-space(text())='Insert Product']")
	private WebElement insertProductLnk;
	
	@FindBy(xpath="//a[normalize-space(text())='Manage Products']")
	private WebElement manageProductsLnk;
	
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	private WebElement adminImg;
	
	@FindBy(xpath = "//a[normalize-space(text())='Logout']")
	private WebElement logoutLnk;
	
	public AdminHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateCategoryLnk() {
		return createCategoryLnk;
	}

	public WebElement getSubCategoryLnk() {
		return subCategoryLnk;
	}

	public WebElement getInsertProductLnk() {
		return insertProductLnk;
	}

	public WebElement getManageProductsLnk() {
		return manageProductsLnk;
	}

	
	public WebElement getAdminImg() {
		return adminImg;
	}

	public WebElement getLogoutLnk() {
		return logoutLnk;
	}
	
	
	//Business libraries
	
	public void navigateToCategoryMajorTab()
	{
		createCategoryLnk.click();
	}
	
	public void navigateToSubCategoryMajorTab()
	{
		subCategoryLnk.click();
	}
	
	public void navigateInsertProductMajorTab()
	{
		insertProductLnk.click();
	}
	public void navigateToManageProductMajorTab()
	{
		manageProductsLnk.click();
	}
	public void logOutOfApplication(WebActionUtility wLib) throws Throwable
	{
		adminImg.click();
		wLib.waitAndClick(logoutLnk);
	}
	

}
