
public class fileTest 
{
	public static void main(String[] args)
	{
		createTextFile app = new createTextFile();
		System.out.println("type:");
		app.openFile();
		app.addRecord();
		app.closeFile();
	}
}
