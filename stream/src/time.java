
public class time 
{
	private int hour;
	private int minute;
	private int secound;
	
	public void setTime(int hour, int minute, int secound)
	{
		if(hour < 24)
		{
			this.hour = hour;
			this.minute = minute;
			this.secound = secound;
		}
		else
			throw new IllegalArgumentException("this value is out of range");
	}
}
