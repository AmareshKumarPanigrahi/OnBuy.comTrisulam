package onBuy_com.OSA.genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

	/**
	 * This method helps us to get file path from .\\config\\filepath.properties
	 * @param keyFilepath
	 * @return
	 * @throws IOException
	 */
	public String getFilepathFromPropertiesFile(String keyFilepath) throws IOException 
	{
		FileInputStream fis= new FileInputStream(".\\config\\filepath.properties");
		Properties pObj= new Properties();
		pObj.load(fis);
		String filepath=pObj.getProperty(keyFilepath);
		return filepath;
	}
	
	/**
	 * This method is used to fetch the data from properties file when the filepath and key should be given as input argument
	 * @param filePath
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getDataFromPropertiesFile(String filePath , String key) throws IOException {
		FileInputStream fis = new FileInputStream(filePath);
		Properties p= new Properties();
		p.load(fis);
		return  p.getProperty(key);
	}

	
	
	
	
	
	
	
	
}

