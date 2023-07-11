package onBuy_com.OSA.genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class provides the methods to read and write the data from excel sheet
 * @author ELCOT
 *
 */
public class ExcelFieUtility {
	
	/**
	 * This method will get the data from provided filepath, sheetname, testcaseID and test case header
	 * @param filepath
	 * @param sheetName
	 * @param testCaseID
	 * @param testcaseHeader
	 * @return
	 * @throws IOException
	 */
	public String getDataFromExcel(String filepath, String sheetName, String testCaseID, String testcaseHeader) throws IOException {
		
		
		FileInputStream fis= new FileInputStream(filepath);
		Workbook wb = WorkbookFactory.create(fis);
		String data="";
		String actHeader="";
		String actTestID="";
		
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		int testRowNum=0;
		for (int i = 0; i <=rowCount ; i++) {
			try {
			actTestID = sheet.getRow(i).getCell(0).toString(); }catch (Exception e) {}
			
			if(actTestID.equalsIgnoreCase(testCaseID))
			{
				break;
			}
			testRowNum++;
		}
		
		int cellCountForTest = sheet.getRow(testRowNum-1).getLastCellNum();
		
		int testcellNum=0;
		for(int j=0; j<=cellCountForTest;j++)
		{
			try {
			 actHeader = sheet.getRow(testRowNum-1).getCell(j).toString();
			}catch(Exception e){}
			 
			 if(actHeader.equalsIgnoreCase(testcaseHeader))
			{
				break;
			}
			testcellNum++;
			
		}
		try {
		data = sheet.getRow(testRowNum).getCell(testcellNum).toString();
		}catch (Exception e) {
		}
		return data;
	}
	
	public void getRowNum(String path, String testcaseID)
	{
		
		
		
	}

}
