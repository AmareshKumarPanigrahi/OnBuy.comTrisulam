package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class JDBC_Validation {
	
	public static void main(String[] args) throws Throwable {
		
		
		Connection con=null;
		String projectName="flipkart";
		try {
			
			//Step1: Driver
			Driver driver= new Driver();
			DriverManager.registerDriver(driver);
			 con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
			Statement statement = con.createStatement();
			String query="select * from project";
			ResultSet result = statement.executeQuery(query);
			boolean flag=false;
			while(result.next())
			{
				String value=result.getString(4);
				if(value.equalsIgnoreCase(projectName))
				{
					System.out.println("project is created");
					flag=true;
					break;
				}
			}
			if(!flag)
			{
				System.out.println("project is created");
			}
		} finally {
			// TODO: handle finally clause
			con.close();
			
		}

	}

}
