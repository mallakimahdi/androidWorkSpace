import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JFrame;

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
			Connection connection = DriverManager.getConnection("jdbc:derby:/home/mahdi/mydb", "root", "123");
			java.sql.PreparedStatement selectPerson = connection.prepareStatement("select * from derby");
			
			
			/*
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery("select * from tbl1");
			java.sql.ResultSetMetaData metadata = resultset.getMetaData();
			*/
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
