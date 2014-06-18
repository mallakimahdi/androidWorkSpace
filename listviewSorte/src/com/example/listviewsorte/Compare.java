package com.example.listviewsorte;

import java.util.Comparator;

public class Compare implements Comparator<struct> 
{
	String compare;
	
	public Compare(String compare) 
	{
		this.compare = compare;
	}
	
	@Override
	public int compare(struct arg0, struct arg1) 
	{
		if(compare.equals("Id"))
			return arg0.getId().compareTo(arg1.getId());
		else if(compare.equals("date"))
			return arg0.getGc().compareTo(arg1.getGc());
		else
		{
			return 0;
		}
	}
}
