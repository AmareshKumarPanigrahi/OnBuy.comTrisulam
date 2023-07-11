package onBuy_com.OSA.genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	Random rnd= new Random();
	Date dateObj= new Date();
	SimpleDateFormat sim= new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * This method will return the random number of boundry 4000
	 * @return
	 */
	public int getRandoomNumber()
	{
		
		int rndNum = rnd.nextInt(4000);
		return rndNum;
	
	}
	/**
	 * This method will return the current date in yyyy-MM-dd format
	 * @return
	 */
	public String getDate()
	{
		String date=sim.format(dateObj);
		return date;
		
	}
	
	/**
	 * This method will retun the required date
	 * Negative numbers For previous
	 * Positive numbers for future 
	 * @param requriedCount
	 * @return
	 */
	public String getDate(int requriedCount)
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, requriedCount);
		Date dte = cal.getTime();
		String rdate = sim.format(dte);
		return rdate;
	}

}
