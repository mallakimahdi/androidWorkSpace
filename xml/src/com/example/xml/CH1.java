package com.example.xml;

import java.util.ArrayList;

import org.simpleframework.xml.ElementList;

public class CH1 
{
	@ElementList
	private ArrayList<String> str;
	
	public CH1() 
	{}
	
	public CH1(ArrayList<String> str)
	{
		this.str = str;
	}
	
	public ArrayList<String> getStr() {
		return str;
	}

	public void setStr(ArrayList<String> str) {
		this.str = str;
	}

	
}
