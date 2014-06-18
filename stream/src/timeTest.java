
public class timeTest 
{
	public static void main(String[] args)
	{
		try
		{
			time t = new time();
			t.setTime(26, 4, 0);
			System.out.println("m");
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("out");
		}
		
	}
}
