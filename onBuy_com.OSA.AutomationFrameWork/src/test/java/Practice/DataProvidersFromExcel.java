package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mysql.cj.result.Row;

import onBuy_com.OSA.genericUtilities.ExcelFieUtility;
import onBuy_com.OSA.genericUtilities.JavaUtility;

public class DataProvidersFromExcel{
	
	ExcelFieUtility eUtil= new ExcelFieUtility();
	
	
	
	@DataProvider
	public Object[][] dataFromExcel() throws Throwable
	{
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\DataProvidersSample.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		 int rowCount=sh.getPhysicalNumberOfRows();
		 int cellCount= sh.getRow(0).getPhysicalNumberOfCells();
		 
	
		
		Object[][] obj= new Object[rowCount][cellCount];
		for(int i=0; i<rowCount; i++)
		{
			
			for(int j=0; j<cellCount; j++)
			{
			obj[i][j]=sh.getRow(i).getCell(j).toString();
			
			}
		
		}
		
		
		
		
		return obj;
	}

	
	@Test(dataProvider = "dataFromExcel")
	public void test(String src, String dst, String price)
	{
		
		System.out.println(src+" | "+dst+" | "+price);
		
	}
	
}
