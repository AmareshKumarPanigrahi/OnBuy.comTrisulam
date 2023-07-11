package com.OnBuy.CategoryTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.AdminCreateCategoryPage;
import objectRepository.AdminEditCategoryPage;
import objectRepository.AdminHomePage;
import objectRepository.AdminLoginPage;
import onBuy_com.OSA.genericUtilities.BaseClass;
import onBuy_com.OSA.genericUtilities.ExcelFieUtility;
import onBuy_com.OSA.genericUtilities.FileUtility;
import onBuy_com.OSA.genericUtilities.JavaUtility;
import onBuy_com.OSA.genericUtilities.WebActionUtility;

public class TC_42_Create_Edit_Delete_CategoryTest extends BaseClass {

	public TC_42_Create_Edit_Delete_CategoryTest() throws Throwable {
		super();
	}

	@Test
	public void createEditDeleteCategory() throws Throwable {
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

	
		
		/**
		 * Admin Module
		 */

		/* navigate to category */

		AdminHomePage ahp = new AdminHomePage(driver);
		ahp.navigateToCategoryMajorTab();

		/* create category */
		String CATEGORY = eLib.getDataFromExcel(TEST_FILEPATH, "Category", "TC_01", "CATEGORY_NAME")
				+ jLib.getRandoomNumber();
		AdminCreateCategoryPage accp = new AdminCreateCategoryPage(driver);
		String createMsg = accp.createCategory(CATEGORY);
		
		//Step 6: Verify whether the category is created or not
		
		Assert.assertTrue(createMsg.contains("Category Created"),CATEGORY+ "is not created ==> FAILED");
		Reporter.log(CATEGORY+"is created ==> PASSED ",true);
		
		
		
		/*Step 7: Click on Edit icon*/
		accp.searchAndclickOnEditCategory(CATEGORY);
		
		AdminEditCategoryPage aecp= new AdminEditCategoryPage(driver);
		String EDIT_CATEGORY = eLib.getDataFromExcel(TEST_FILEPATH, "Category", "TC_01", "EDIT_NAME")
				+ jLib.getRandoomNumber();
		String updateMsg= aecp.editCategory(EDIT_CATEGORY);
		
		Assert.assertTrue(updateMsg.contains("Category Updated"),EDIT_CATEGORY+ "is not updated ==> FAILED");
		Reporter.log(EDIT_CATEGORY+"is updated ==> PASSED ",true);
		
		//Step 10: Navigate to create category
		ahp.navigateToCategoryMajorTab();
		String deleteMsg=accp.searchAndDeleteCategory(driver, EDIT_CATEGORY);
		/*Validate the content*/
		Assert.assertTrue(deleteMsg.contains("Category deleted"),EDIT_CATEGORY+ "is not deleted ==> FAILED");
		Reporter.log(EDIT_CATEGORY+"is deleted ==> PASSED ",true);
		
		/*Logout of admin*/
		ahp.logOutOfApplication(wLib);
		
	}
}
