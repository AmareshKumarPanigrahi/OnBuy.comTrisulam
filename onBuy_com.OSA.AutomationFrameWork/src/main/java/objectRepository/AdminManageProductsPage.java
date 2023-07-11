package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminManageProductsPage {
	
	@FindBy(name="DataTables_Table_0_length")
	private WebElement showEntriesDD;
	
	@FindBy(xpath="//input[@aria-controls='DataTables_Table_0']")
	private WebElement searchTxtFld;
	
	//	Initialize
	public AdminManageProductsPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}

	
	//geteers
	public WebElement getShowEntriesDD() {
		return showEntriesDD;
	}

	public WebElement getSearchTxtFld() {
		return searchTxtFld;
	}
	
	//Business Libraries
	
	
	
	

}
