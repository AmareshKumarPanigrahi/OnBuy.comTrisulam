package objectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class UserHomePage {
	/*
	 * Elements Repo
	 */
	@FindBy(xpath="//a[.='Login']")
	private WebElement logInBtn;
	
	@FindBy(xpath="//a[.='Home']")
	private WebElement homeBtn;
	
	@FindBy(xpath="//a[.='Logout']")
	private WebElement logOutBtn;
	
	
	/*
	 * Initailize
	 */
	public UserHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * Getters
	 */
	public WebElement getLogInBtn() {
		return logInBtn;
	}
	
	public WebElement getHomeBtn() {
		return homeBtn;
	}
	
	public WebElement getLogOutBtn() {
		return logOutBtn;
	}

	
	/*
	 * Bussiness Libraries
	 */
	/**
	 * Validate the product is present in the category i.e, it takes input as driver ref, dynamic category name, sub category name and product name
	 * @param driver
	 * @param categoryName
	 * @param subCategory
	 * @param productName
	 */
	public void validateTheProduct(WebDriver driver,String categoryName, String subCategory, String productName)
	{
		homeBtn.click();
		driver.findElement(By.xpath("//a[normalize-space(text())='"+categoryName+"']")).click();
		driver.findElement(By.xpath("//a[normalize-space(text())='"+subCategory+"']")).click();
		 List<WebElement> productDisplayed = driver.findElements(By.xpath("//div[@class='row']/descendant::a[text()='"+productName+"']"));
			
		 boolean count=false;
		for (WebElement ele : productDisplayed) {
			String element = ele.getText();
			if(element.contains(productName))
			{
				
				System.out.println(productName+"====> is present");
				count=true;
				break;
				
			}
			
		}
		
		Assert.assertTrue(count==true,productName+" is not present ==> FAILED");
		Reporter.log(productName+" is present",true);
		
			
	
	}
	/**
	 * This method will click on the login button present in home page
	 */
	public void clickOnLogin()
	{
		logInBtn.click();
	}
	
	/**
	 * This will logout of the applucation 
	 */
	public void logOutToApplication()
	{
		logOutBtn.click();
	}
	
	
	
}
