package Practice;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Date_Format {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date d= new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
		System.out.println(sdf.format(d));

		Calendar cal= Calendar.getInstance();
		cal.add(Calendar.DATE, 30);
		Date date=cal.getTime();
		
		System.out.println(sdf.format(date));
	}

}
