package com.example.frg2;

import java.util.Comparator;

public class Compare implements Comparator<struct2> 
{
	String compare;
	
	public Compare(String compare) 
	{
		this.compare = compare;
	}
	
	@Override
	public int compare(struct2 arg0, struct2 arg1) 
	{
		if(compare.equals("Id"))
			return arg0.getId().compareTo(arg1.getId());
			
		else if(compare.equals("IsSend"))
			return arg0.getName().compareTo(arg1.getName());
		else
		{
			return 0;
		}
	}
}
