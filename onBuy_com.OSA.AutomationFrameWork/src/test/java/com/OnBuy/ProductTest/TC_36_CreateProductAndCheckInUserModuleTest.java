package com.OnBuy.ProductTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.AdminCreateCategoryPage;
import objectRepository.AdminHomePage;
import objectRepository.AdminInsertProductPage;
import objectRepository.AdminLoginPage;
import objectRepository.AdminSubCategoryPage;
import objectRepository.UserHomePage;
import objectRepository.UserLoginPage;
import onBuy_com.OSA.genericUtilities.BaseClass;
import onBuy_com.OSA.genericUtilities.ExcelFieUtility;
import onBuy_com.OSA.genericUtilities.FileUtility;
import onBuy_com.OSA.genericUtilities.JavaUtility;
import onBuy_com.OSA.genericUtilities.WebActionUtility;


public class TC_36_CreateProductAndCheckInUserModuleTest extends BaseClass{

	public TC_36_CreateProductAndCheckInUserModuleTest() throws Throwable {
		super();
	}

	String CATEGORY;
	String SUB_CATEGORY;
	String PRODUCT_NAME;

	@Test
	public void createProductAndCheckInUserModule() throws Throwable {
		// TODO Auto-generated method stub

	
		

		/* Get the File paths */
		String ENV_FILEPATH = fLib.getFilepathFromPropertiesFile("projectEnvConfigfilepath");
		String TEST_FILEPATH = fLib.getFilepathFromPropertiesFile("testdatafilepath");

		String ADMIN_URL = fLib.getDataFromPropertiesFile(ENV_FILEPATH, "adminurl");
		String ADMIN_USERNAME = fLib.getDataFromPropertiesFile(ENV_FILEPATH, "adminusername");
		String ADMIN_PASSWORD = fLib.getDataFromPropertiesFile(ENV_FILEPATH, "adminpassword");
		
		/* login to the application */
		AdminLoginPage alp = new AdminLoginPage(driver);
		alp.loginToApplication( ADMIN_USERNAME, ADMIN_PASSWORD);

		AdminHomePage ahp= new AdminHomePage(driver);
		

		/* navigate to category */
		ahp.navigateToCategoryMajorTab();

		/* create category */
		CATEGORY = eLib.getDataFromExcel(TEST_FILEPATH, "Product", "TC_36", "CATEGORY")
				+ jLib.getRandoomNumber();
		AdminCreateCategoryPage accp = new AdminCreateCategoryPage(driver);
		String catValidate= accp.createCategory(CATEGORY);
		
		/*Validate Category*/
		Assert.assertTrue(catValidate.contains("Category Created"),CATEGORY+"is not Created ==> FAILED");
		Reporter.log(CATEGORY+"is Created ==> PASSED",true);
		
		

		/* navigate to sub category major tab */
		ahp.navigateToSubCategoryMajorTab();

		/* create Sub Category */

		AdminSubCategoryPage ascp = new AdminSubCategoryPage(driver);
		SUB_CATEGORY = eLib.getDataFromExcel(TEST_FILEPATH, "Product", "TC_36", "SUB CATEGORY")
				+ jLib.getRandoomNumber();
		String subCatValidate =ascp.createSubCategory(wLib, CATEGORY, SUB_CATEGORY);
		
		
		/*Validate*/
		Assert.assertTrue(subCatValidate.contains("SubCategory Created"),SUB_CATEGORY+"is not Created ==> FAILED");
		Reporter.log(SUB_CATEGORY+"is Created ==> PASSED",true);
		

		/* click on the insert product major tab */
		ahp.navigateInsertProductMajorTab();

		/* create a product */
		 PRODUCT_NAME = eLib.getDataFromExcel(TEST_FILEPATH, "Product", "TC_36", "PRODUCT NAME")
				+ jLib.getRandoomNumber();
		String PRODUCT_COMPANY = eLib.getDataFromExcel(TEST_FILEPATH, "Product", "TC_36", "PRODUCT COMPANY")
				+ jLib.getRandoomNumber();
		String ACTUAL_PRICE = eLib.getDataFromExcel(TEST_FILEPATH, "Product", "TC_36", "ACTUAL PRICE");
		String SELLING_PRICE = eLib.getDataFromExcel(TEST_FILEPATH, "Product", "TC_36", "SELLING PRICE");
		String DESCRIPTION = eLib.getDataFromExcel(TEST_FILEPATH, "Product", "TC_36", "DESCRIPTION");
		String SHIPPING_CARGES = eLib.getDataFromExcel(TEST_FILEPATH, "Product", "TC_36", "SHIPPING CHARGES");
		String AVAILABILITY = eLib.getDataFromExcel(TEST_FILEPATH, "Product", "TC_36", "PRODUCT AVAILABILITY");
		String IMG_1 = "C:/Users/ELCOT/Pictures/OIP.jpg";
		String IMG_2 = "C:/Users/ELCOT/Pictures/OIP.jpg";
		String IMG_3 = "C:/Users/ELCOT/Pictures/OIP.jpg";

		AdminInsertProductPage aipp = new AdminInsertProductPage(driver);
		String productValidate = aipp.InsertProduct(wLib, CATEGORY, SUB_CATEGORY, PRODUCT_NAME, PRODUCT_COMPANY, ACTUAL_PRICE, SELLING_PRICE,
				DESCRIPTION, SHIPPING_CARGES, AVAILABILITY, IMG_1, IMG_2, IMG_3);

	/*Validate product is created or not*/
		Assert.assertTrue(productValidate.contains("Product Inserted Successfully"),PRODUCT_NAME+"is not Created ==> FAILED");
		Reporter.log(PRODUCT_NAME+"is Created ==> PASSED",true);
		
	
		ahp.logOutOfApplication(wLib);
		
		
		
		String USER_URL = fLib.getDataFromPropertiesFile(ENV_FILEPATH, "userurl");
		String USER_USERNAME = fLib.getDataFromPropertiesFile(ENV_FILEPATH, "userusername");
		String USER_PASSWORD = fLib.getDataFromPropertiesFile(ENV_FILEPATH, "userpassword");
		
		
		driver.get(USER_URL);
		/* login to the application */
		UserHomePage uhp= new UserHomePage(driver);
		uhp.clickOnLogin();
		
		UserLoginPage ulp = new UserLoginPage(driver);
		ulp.loginToApplication(USER_USERNAME, USER_PASSWORD);
		
		
	
		
		uhp.validateTheProduct(driver, CATEGORY, SUB_CATEGORY, PRODUCT_NAME);
		
		
		uhp.logOutToApplication();
	
		
	}

}
