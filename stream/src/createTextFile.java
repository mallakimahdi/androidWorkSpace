import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;


public class createTextFile 
{
	private Formatter output;
	
	public void openFile()
	{
		try 
		{
			output = new Formatter("example.txt");
		}
		catch (SecurityException e)
		{
			System.out.println("you have not permission to access this file");
		}
		catch (FileNotFoundException e) 
		{
			System.out.println("error openning file");
		}
	}
	
	public void addRecord()
	{
		AccountRecord record = new AccountRecord();
		Scanner scanner = new Scanner(System.in);
		
		record.setAccountNumber(scanner.nextInt());
		record.setFirstName(scanner.next());
		record.setLastName(scanner.next());
		record.setBalance(scanner.nextDouble());
	}
	
	public void closeFile()
	{
		output.close();
	}
}
