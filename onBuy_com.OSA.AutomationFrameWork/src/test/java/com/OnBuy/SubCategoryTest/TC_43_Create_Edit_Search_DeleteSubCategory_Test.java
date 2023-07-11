package com.OnBuy.SubCategoryTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
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
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.AdminCreateCategoryPage;
import objectRepository.AdminEditCategoryPage;
import objectRepository.AdminEditSubCategoryPage;
import objectRepository.AdminHomePage;
import objectRepository.AdminLoginPage;
import objectRepository.AdminSubCategoryPage;
import onBuy_com.OSA.genericUtilities.BaseClass;
import onBuy_com.OSA.genericUtilities.ExcelFieUtility;
import onBuy_com.OSA.genericUtilities.FileUtility;
import onBuy_com.OSA.genericUtilities.JavaUtility;
import onBuy_com.OSA.genericUtilities.WebActionUtility;


public class TC_43_Create_Edit_Search_DeleteSubCategory_Test extends BaseClass {

	public TC_43_Create_Edit_Search_DeleteSubCategory_Test() throws Throwable {
		super();
	}

	@Test
	public void createEditSearchSubCategory() throws Throwable {

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
		String CATEGORY = eLib.getDataFromExcel(TEST_FILEPATH, "SubCategory", "TC_43", "CATEGORY")
				+ jLib.getRandoomNumber();
		AdminCreateCategoryPage accp = new AdminCreateCategoryPage(driver);
		String createMsg=accp.createCategory(CATEGORY);
		
		/*Validate*/
		Assert.assertTrue(createMsg.contains("Category Created"),CATEGORY+"is not Created ==> FAILED");
		Reporter.log(CATEGORY+"is Created ==> PASSED",true);
		
		/* navigate to sub category major tab */
		ahp.navigateToSubCategoryMajorTab();

		/* create Sub Category */

		AdminSubCategoryPage ascp = new AdminSubCategoryPage(driver);
		String SUB_CATEGORY = eLib.getDataFromExcel(TEST_FILEPATH, "SubCategory", "TC_43", "SUB_CATEGORY")
				+ jLib.getRandoomNumber();
		String subcatCreateMsg=ascp.createSubCategory(wLib, CATEGORY, SUB_CATEGORY);
		
		/*Validate*/
		Assert.assertTrue(subcatCreateMsg.contains("SubCategory Created"),SUB_CATEGORY+"is not Created ==> FAILED");
		Reporter.log(SUB_CATEGORY+"is Created ==> PASSED",true);
		
		/* select the show entries Dropdown */
		ascp.selectShowEntries(3);
		
		/*Step 10: Enter the subcategory on Search bar and click on edit icon*/
		ascp.searchSubCategoryAndClickOnEdit(SUB_CATEGORY);
		
		
		
		String EDIT_SUB_CATEGORY = eLib.getDataFromExcel(TEST_FILEPATH, "SubCategory", "TC_43", "EDIT SUB CATEGORY")
		+ jLib.getRandoomNumber();
		
		
		AdminEditSubCategoryPage aescp= new AdminEditSubCategoryPage(driver);
		String subcatUpdateMsg= aescp.editSubCategory(CATEGORY, EDIT_SUB_CATEGORY);
		
		/*Validate*/
		Assert.assertTrue(subcatUpdateMsg.contains("Sub-Category Updated"),EDIT_SUB_CATEGORY+"is not Updated ==> FAILED");
		Reporter.log(EDIT_SUB_CATEGORY+"is Updated ==> PASSED",true);
		
		
		
		/* Click on subcategory major tab*/ 
		ahp.navigateToSubCategoryMajorTab();
		
		String subcatDeleteMsg= ascp.searchAndDelete(driver, EDIT_SUB_CATEGORY);
		
		/*Validate*/
		Assert.assertTrue(subcatDeleteMsg.contains("SubCategory deleted"),EDIT_SUB_CATEGORY+"is not deleted ==> FAILED");
		Reporter.log(EDIT_SUB_CATEGORY+"is deleted ==> PASSED",true);
		
	
		ahp.logOutOfApplication(wLib);

		
		
		


		
	}

}
