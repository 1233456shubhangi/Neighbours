package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connectionfactory {
	public static Connection getConnection()
	{
		Connection conn=null;
		try
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/housecolony","root", "root");
			System.out.println("conn");
			System.out.println("connection value is "+conn);

			return conn;	
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		return conn;
	
	}

	}


