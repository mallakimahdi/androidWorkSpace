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
			
		else if(compare.equals("IsSend"))
			return arg0.isSend().compareTo(arg1.isSend());
		else
		{
			return 0;
		}
	}
}
