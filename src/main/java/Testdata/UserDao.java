package Testdata;

import java.sql.*;

import javax.servlet.http.HttpSession;

import Userinfo.Userdata;
import db.Connectionfactory;

public class UserDao  implements Userfetch
{
	@Override
	public void addUserdata(Userdata userdata) {
		// TODO Auto-generated method stub
		
		
		try
		{
			Connection conn=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/housecolony","root", "root");
			System.out.println("conn");
			System.out.println("connection value is "+conn);

			
			Statement statement=conn.createStatement();
			System.out.println("Request arrived="+userdata.getName());
			String query="INSERT INTO `neighbours`(`name`,`mobile`,`password`,`area`,`city`,`state`,`country`) VALUES('"+userdata.getName()+"','"+userdata.getMobile()+"','"+userdata.getPassword()+"','"+userdata.getarea()+"','"+userdata.getCity()+"','"+userdata.getState()+"','"+userdata.getCountry()+"')";
			statement.executeUpdate(query);
			 System.out.println("Success");
		}
			catch(Exception e)
			{
				System.out.println(e);
			}
		
		

	}

	public boolean loginUser(Userdata userdata) {
		System.out.println("Inside dao");
		Connection con=null;
		con=Connectionfactory.getConnection();
		try
		{
			
			
			Statement statement=con.createStatement();
			System.out.println(userdata.getName());
			System.out.println("inside try");
			
			
			String query="SELECT * From neighbours where name='"+userdata.getName()+"' AND `password`='"+userdata.getPassword()+"'";
			ResultSet resultSet=statement.executeQuery(query);
			if(resultSet.next())
			{
				return true;
			}
			
			
		}
			catch(Exception e)
			{
				System.out.println(e);
			}
		
		
		
		return false;
	}

	

	

}
