package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class JDBC_Fetch {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		Connection con=null;
		try {
			
			//Step1: Driver
			Driver driver= new Driver();
			DriverManager.registerDriver(driver);
			 con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
			Statement statement = con.createStatement();
			String query="select * from project";
			ResultSet result = statement.executeQuery(query);
			while(result.next())
			{
				String value=result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4)+" "+result.getString(5)+" "+result.getInt(6);
				System.out.println(value);
			}
		} finally {
			// TODO: handle finally clause
			con.close();
			
		}

	}

}
