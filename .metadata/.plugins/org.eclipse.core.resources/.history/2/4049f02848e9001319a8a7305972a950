package com.example.frg2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class struct2 
{
	private Map<String, Object> mapObj;
	
	public struct2() 
	{
		this.mapObj = new HashMap<String, Object>();
	}
	
	public void setId(int id)
	{
		this.mapObj.put("id", id);
	}
	
	public int getId()
	{
		return (Integer) this.mapObj.get("id");
	}
	
	
	public void setName(String name)
	{
		this.mapObj.put("name", name);
	}
	
	public String getName()
	{
		return (String) this.mapObj.get("name");
	}
	
	public Map<String, Object> getMap()
	{
		return this.mapObj;
	}
	
	public int getCount()
	{
		return mapObj.size();
	}
	
	public Object[] getItemsArray()
	{
		Set<String> set = mapObj.keySet();
		Object[] obj = new Object[set.size()];
		Iterator<String> iterator = set.iterator();
		String[] keys = new String[set.size()];
		
		
		for(int i=0 ; i<set.size() ; i++)
		{
			if(iterator.hasNext())
			{
				keys[i] = iterator.next(); 
			}
		}
		
		for(int i=0 ; i< keys.length ; i++)
		{
			obj[i] = mapObj.get(keys[i]);
		}
		
		return obj;
	}
}
