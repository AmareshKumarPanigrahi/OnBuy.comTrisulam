package onBuy_com.OSA.genericUtilities;

import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.AdminHomePage;
import objectRepository.AdminLoginPage;
import objectRepository.UserHomePage;
import objectRepository.UserLoginPage;

public class BaseClass {

	public  FileUtility fLib = new FileUtility();
	public ExcelFieUtility eLib = new ExcelFieUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebActionUtility wLib = new WebActionUtility();
	String ENV_FILEPATH ;
	String TEST_FILEPATH;
	
	
public WebDriver driver=null;
public static WebDriver sdriver;
	public BaseClass( ) throws Throwable
	{
		
	}
	
	
	@BeforeSuite
	public void connectToDB()
	{
		System.out.println("================Data Base Connected==================");
	}

	/* @Parameters("BROWSER") */
	@BeforeClass
	public void openBrowser(/* String BROWSER */) throws Throwable
	{
		WebDriverManager.chromedriver().setup();
		/* Get the File paths */
		String ENV_FILEPATH = fLib.getFilepathFromPropertiesFile("projectEnvConfigfilepath");
		String TEST_FILEPATH = fLib.getFilepathFromPropertiesFile("testdatafilepath");
		String ADMIN_URL = fLib.getDataFromPropertiesFile(ENV_FILEPATH, "adminurl");
		
		String BROWSER = fLib.getDataFromPropertiesFile(ENV_FILEPATH, "browser");
	
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}else
		{
			driver = new ChromeDriver();
		}
		
		sdriver=driver;
		
		wLib.maximizeTheBrowser(driver);
		wLib.waitForElementInDOM(driver);
		driver.get(ADMIN_URL);
	}
	@BeforeMethod
	public void loginToTheApplication() throws IOException
	{
		System.out.println("LOGGED IN TO THE APPLICATION");
	
		
		
	}
	@AfterMethod
	public void logoutOfTheApplication() throws Throwable {

		System.out.println("LOGGED OUT OF THE APPLICATION");
		
}
	
	@AfterClass
	public void closeTheBrowser()
	{
		/* Close the browser */
		driver.close();
		
	}
	
	@AfterSuite
	public void closeTheDB()
	{
		System.out.println("============DB is Closed=================");
	}

}
