import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;

import com.mysql.jdbc.PreparedStatement;

public class database extends JFrame
{
	public database() 
	{
		super("Display query result");
	}
	
	public static void main(String[] args)
	{
		try 
		{
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery("select * from tbl1");
			java.sql.ResultSetMetaData metadata = resultset.getMetaData();
			
			java.sql.PreparedStatement authorBook = connection.prepareStatement("");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
