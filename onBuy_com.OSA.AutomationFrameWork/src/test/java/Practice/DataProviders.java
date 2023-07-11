package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviders {

	@DataProvider
	public Object[][] data()
	{
		Object [][]obj = new Object[3][3];
		obj[0][0]="banglore";
		obj[0][1]="chennai";
		obj[0][2]="800";
		
		obj[1][0]="dehli";
		obj[1][1]="goa";
		obj[1][2]="2000";
		
		obj[2][0]="banglore";
		obj[2][1]="dehli";
		obj[2][2]="4000";
		
		return obj;
	}
	
	
	@Test(dataProvider = "data")
	public void dataProviderPractice(String src, String dst, String price)
	{
		System.out.println(src+" - "+dst+" ==> "+price);
	}
	
}
