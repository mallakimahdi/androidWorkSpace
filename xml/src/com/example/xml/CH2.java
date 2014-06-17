package com.example.xml;

import org.simpleframework.xml.Element;

public class CH2 
{
	@Element
	private int id;
	
	@Element
	private String name;

	public CH2() 
	{}
	
	public CH2(int id, String name)
	{
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
