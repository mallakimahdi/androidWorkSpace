package Sorter;

import java.util.Date;

public class struct implements Comparable
{
	private int id;
	private Date date;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int compareTo(Object another) 
	{
		
		return 0;
	}

}
