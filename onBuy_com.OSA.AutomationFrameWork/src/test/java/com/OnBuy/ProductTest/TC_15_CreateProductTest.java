package com.OnBuy.ProductTest;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;

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
import onBuy_com.OSA.genericUtilities.BaseClass;
import onBuy_com.OSA.genericUtilities.ExcelFieUtility;
import onBuy_com.OSA.genericUtilities.FileUtility;
import onBuy_com.OSA.genericUtilities.JavaUtility;
import onBuy_com.OSA.genericUtilities.WebActionUtility;


public class TC_15_CreateProductTest extends BaseClass{

	public TC_15_CreateProductTest() throws Throwable {
		super();
	}

	@Test
	public void createProduct() throws Throwable {

		


		/* Get the File paths */
		String ENV_FILEPATH = fLib.getFilepathFromPropertiesFile("projectEnvConfigfilepath");
		String TEST_FILEPATH = fLib.getFilepathFromPropertiesFile("testdatafilepath");

		String ADMIN_URL = fLib.getDataFromPropertiesFile(ENV_FILEPATH, "adminurl");
		String ADMIN_USERNAME = fLib.getDataFromPropertiesFile(ENV_FILEPATH, "adminusername");
		String ADMIN_PASSWORD = fLib.getDataFromPropertiesFile(ENV_FILEPATH, "adminpassword");
		
		

		/* login to the application */
		AdminLoginPage alp = new AdminLoginPage(driver);
		alp.loginToApplication( ADMIN_USERNAME, ADMIN_PASSWORD);
		
		/* navigate to category */

		AdminHomePage ahp = new AdminHomePage(driver);
		
		ahp.navigateToCategoryMajorTab();

		/* create category */
		String CATEGORY = eLib.getDataFromExcel(TEST_FILEPATH, "Product", "TC_15", "CATEGORY")
				+ jLib.getRandoomNumber();
		AdminCreateCategoryPage accp = new AdminCreateCategoryPage(driver);
		String catValidate=accp.createCategory(CATEGORY);
		
		/*Validation*/
		Assert.assertTrue(catValidate.contains("Category Created"),CATEGORY+"is not Created ==> FAILED");
		Reporter.log(CATEGORY+"is Created ==> PASSED",true);
		
		
		
		
		/* navigate to sub category major tab */
		ahp.navigateToSubCategoryMajorTab();

		/* create Sub Category */

		AdminSubCategoryPage ascp = new AdminSubCategoryPage(driver);
		String SUB_CATEGORY = eLib.getDataFromExcel(TEST_FILEPATH, "Product", "TC_15", "SUB CATEGORY")
				+ jLib.getRandoomNumber();
		String subcatValidate=ascp.createSubCategory(wLib, CATEGORY, SUB_CATEGORY);
		
		/*Validate*/
		Assert.assertTrue(subcatValidate.contains("SubCategory Created"),SUB_CATEGORY+"is not Created ==> FAILED");
		Reporter.log(SUB_CATEGORY+"is Created ==> PASSED",true);
		
		/* click on the insert product major tab */
		ahp.navigateInsertProductMajorTab();

		/* create a product */
		String PRODUCT_NAME = eLib.getDataFromExcel(TEST_FILEPATH, "Product", "TC_15", "PRODUCT NAME")
				+ jLib.getRandoomNumber();
		String PRODUCT_COMPANY = eLib.getDataFromExcel(TEST_FILEPATH, "Product", "TC_15", "PRODUCT COMPANY")
				+ jLib.getRandoomNumber();
		String ACTUAL_PRICE = eLib.getDataFromExcel(TEST_FILEPATH, "Product", "TC_15", "ACTUAL PRICE");
		String SELLING_PRICE = eLib.getDataFromExcel(TEST_FILEPATH, "Product", "TC_15", "SELLING PRICE");
		String DESCRIPTION = eLib.getDataFromExcel(TEST_FILEPATH, "Product", "TC_15", "DESCRIPTION");
		String SHIPPING_CARGES = eLib.getDataFromExcel(TEST_FILEPATH, "Product", "TC_15", "SHIPPING CHARGES");
		String AVAILABILITY = eLib.getDataFromExcel(TEST_FILEPATH, "Product", "TC_15", "PRODUCT AVAILABILITY");
		String IMG_1 = "C:/Users/ELCOT/Pictures/OIP.jpg";
		String IMG_2 = "C:/Users/ELCOT/Pictures/OIP.jpg";
		String IMG_3 = "C:/Users/ELCOT/Pictures/OIP.jpg";

		AdminInsertProductPage aipp = new AdminInsertProductPage(driver);
		String productValidate= aipp.InsertProduct(wLib, CATEGORY, SUB_CATEGORY, PRODUCT_NAME, PRODUCT_COMPANY, ACTUAL_PRICE, SELLING_PRICE,
				DESCRIPTION, SHIPPING_CARGES, AVAILABILITY, IMG_1, IMG_2, IMG_3);

		/*Validate Insert Product*/
		Assert.assertTrue(productValidate.contains("Product Inserted Successfully"),PRODUCT_NAME+"is not Created ==> FAILED");
		Reporter.log(PRODUCT_NAME+"is Created ==> PASSED",true);
		
		
		
		ahp.logOutOfApplication(wLib);

	}

}
