package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import onBuy_com.OSA.genericUtilities.WebActionUtility;

public class AdminInsertProductPage  extends WebActionUtility{
	@FindBy(name="category")
	private WebElement categoryDD;
	
	@FindBy(name="subcategory")
	private WebElement subCategoryDD;
	
	@FindBy(name="productName")
	private WebElement productNameTxtFld;
	
	@FindBy(name="productCompany")
	private WebElement productCompanyTxtFld;
	
	@FindBy(name="productpricebd")
	private WebElement actualPriceTxtFld;
	
	@FindBy(name="productprice")
	private WebElement productPriceTxtFld;
	@FindBy(name="productDescription")
	private WebElement descriptionTxtBox;
	
	@FindBy(name="productShippingcharge")
	private WebElement shippingChargeTxtFld;
	
	@FindBy(name="productAvailability")
	private WebElement productAvailabilityDD;
	
	@FindBy(xpath="//input[@name='productimage1']")
	private WebElement img1;
	
	@FindBy(name="productimage2")
	private WebElement img2;
	
	@FindBy(name="productimage3")
	private WebElement img3;
	
	@FindBy(xpath="//button[.='Insert']")
	private WebElement insertBtn;
	
	@FindBy(xpath="//div[contains(@class,'alert alert-success')]")
	private WebElement validateTxt;
	
	
	
	public WebElement getValidateTxt() {
		return validateTxt;
	}


	public WebElement getInsertBtn() {
		return insertBtn;
	}


	//Initialsize
	public AdminInsertProductPage(WebDriver driver) throws Throwable
	{
		PageFactory.initElements(driver, this);
		
	}

	
	//getters
	public WebElement getCategoryDD() {
		return categoryDD;
	}

	public WebElement getSubCategoryDD() {
		return subCategoryDD;
	}

	public WebElement getProductNameTxtFld() {
		return productNameTxtFld;
	}

	public WebElement getProductCompanyTxtFld() {
		return productCompanyTxtFld;
	}

	public WebElement getActualPriceTxtFld() {
		return actualPriceTxtFld;
	}

	public WebElement getProductPriceTxtFld() {
		return productPriceTxtFld;
	}

	public WebElement getShippingChargeTxtFld() {
		return shippingChargeTxtFld;
	}

	public WebElement getProductAvailabilityDD() {
		return productAvailabilityDD;
	}

	public WebElement getImg1() {
		return img1;
	}

	public WebElement getImg2() {
		return img2;
	}

	public WebElement getImg3() {
		return img3;
	}
	
	
	

	public WebElement getDescriptionTxtBox() {
		return descriptionTxtBox;
	}
	
	//business libraries



	public String InsertProduct(WebActionUtility wLib,   
			String categoryName,
			String subCategoryName, 
			String productName, 
			String productCompany, 
			String actualPrice, 
			String sellingPrice, 
			String description,
			String shippingCharges,String productAvailability, 
								String img1Path,String img2Path, String img3Path) {
		wLib.select(categoryDD, categoryName);
		wLib.select(subCategoryDD, subCategoryName);
		productNameTxtFld.sendKeys(productName);
		productCompanyTxtFld.sendKeys(productCompany);
		actualPriceTxtFld.sendKeys(actualPrice);
		productPriceTxtFld.sendKeys(sellingPrice);
		descriptionTxtBox.sendKeys(description);
		shippingChargeTxtFld.sendKeys(shippingCharges);
		wLib.select(productAvailabilityDD, productAvailability);
		img1.sendKeys(img1Path);
		img2.sendKeys(img2Path);
		img3.sendKeys(img3Path);
		insertBtn.click();
		
		return validateTxt.getText();
		
	}
	
	
	
	
	
}
