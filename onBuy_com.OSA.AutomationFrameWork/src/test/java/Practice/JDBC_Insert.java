package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class JDBC_Insert {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		Connection con=null;
		try {
			
			//Step1: Driver
			Driver driver= new Driver();
			DriverManager.registerDriver(driver);
			 con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
			Statement statement = con.createStatement();
			String query="insert into project values('TY_809','Trisul','29/06/2023','Tyss','completed',7)";
			int result = statement.executeUpdate(query);
			if(result==1)
			{
				System.out.println("data is created");
			}
			else {
				System.out.println("data is not created");
			}
		} finally {
			// TODO: handle finally clause
			con.close();
			
		}
		
	
	
	
	
	}

}
