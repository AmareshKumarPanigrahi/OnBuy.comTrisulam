package Practice;

import java.util.Scanner;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import objectRepository.AdminLoginPage;
import objectRepository.UserHomePage;
import objectRepository.UserLoginPage;

public class TestNG_Undersand {
	
	
	@BeforeSuite
	public void bs()
	{
		System.out.println("Before Suite");
	}
	@BeforeTest
	public void bt()
	{
		System.out.println("Before Test");
	}
	@BeforeClass
	public void bc()
	{
		System.out.println("Before Class");
	}
	/*
	 * Scanner sc= new Scanner(System.in); String value;
	 */
	
	Scanner sc= new Scanner(System.in);
	String value;
	@BeforeMethod
	public void bm()
	{
		System.out.println("which module u want");
		value=sc.next();

		/*
		 * System.out.println("Enter which module to be executed");
		 * System.out.println("Admin"); System.out.println("User");
		 */
		
		if(value.equalsIgnoreCase("Admin"))
		{
			System.out.println("======================Admin Login=================================");

		}
		else if(value.equalsIgnoreCase("User"))
		{
			System.out.println("=======================user Login==================================");
		}
		else {
			
			System.out.println("Input not Matched");
			
		}

	}
	
	@AfterMethod
	public void am()

	{
		if(value.equalsIgnoreCase("Admin"))
		{
			System.out.println("=================Admin loggedout =========================S");

		}
		else if(value.equalsIgnoreCase("User"))
		{
			System.out.println("=========== user loggedout ===================");
		}
		else {
			
			System.out.println("Input not Matched");
		}
	}
	
	@Test
	public void TC_21_CreateCategory()
	{
		System.out.println("Banlore");
	}
	
	@Test
	public void TC_22_CreateCategory2()
	{
	
		System.out.println("Delhi");
	}

	@AfterSuite
	public void as()
	{
		System.out.println("After Suite");
	}
	@AfterTest
	public void at()
	{
		System.out.println("After Test");
	}
	@AfterClass
	public void ac()
	{
		System.out.println("After Class");
	}
	
}
