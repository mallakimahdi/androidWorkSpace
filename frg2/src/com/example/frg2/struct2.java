package com.example.frg2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class struct2 
{
	private Map<String, Object> mapObj;
	private String[] keys = {"id","name","family","address","tell"};
	
	public struct2() 
	{
		this.mapObj = new HashMap<String, Object>();
	}
	
	public void setId(int id)
	{
		this.mapObj.put(keys[0], id);
	}
	public Integer getId()
	{
		return (Integer) this.mapObj.get(keys[0]);
	}
	
	public void setName(String name)
	{
		this.mapObj.put(keys[1], name);
	}
	public String getName()
	{
		return (String) this.mapObj.get(keys[1]);
	}
	
	public void setFamily(String family)
	{
		this.mapObj.put(keys[2], family);
	}
	public String getFamily()
	{
		return (String) this.mapObj.get(keys[2]);
	}
	
	public void setAddress(String address)
	{
		this.mapObj.put(keys[3], address);
	}
	public String getAddress()
	{
		return (String) this.mapObj.get(keys[3]);
	}
	
	public void setTell(int tell)
	{
		this.mapObj.put(keys[4], tell);
	}
	public int getTell()
	{
		return (Integer) this.mapObj.get(keys[4]);
	}
	
	public Object[] getItemsArray()
	{
		Object[] obj = new Object[keys.length];
		
		for(int i=0 ; i<keys.length ; i++)
		{
			obj[i] = mapObj.get(keys[i]);
		}
		
		return obj;
	}
}
