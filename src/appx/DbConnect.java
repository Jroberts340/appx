package appx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect 
{
	public static DbConnect getInstance()
	{
		return new DbConnect();
	}
	
	public Connection getConnection() throws SQLException
	{
		Connection connect = null;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/mevesting?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
		}
		catch (ClassNotFoundException e1)
		{
			e1.printStackTrace();
		}
		
		return connect;
	}
}
