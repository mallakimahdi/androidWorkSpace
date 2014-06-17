package com.example.xml;

import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name="root")
public class Struct 
{
	
	@Element
	private CH1 ch1;
	
	@Element
	private CH2 ch2;
	
	@Element(name="message")
	private String text;
	
	@ElementList(name="serversList", inline=true)
	private List<Server> ser;
	
	@ElementArray(name="arrays")
	private int[] arrsInt;
	
	public Struct() 
	{}
	
	public Struct(int id, String text, List<Server> server, int[] arrsInt, CH1 ch1 , CH2 ch2) 
	{
		setText(text);
		setArrsInt(arrsInt);
		this.ch1 = ch1;
		this.ch2 = ch2;
		
		this.ser = server;
	}
	
	public List<Server> getSer() {
		return ser;
	}
	public void setSer(List<Server> ser) {
		this.ser = ser;
	}
	public int[] getArrsInt() {
		return arrsInt;
	}
	public void setArrsInt(int[] arrsInt) {
		this.arrsInt = arrsInt;
	}
	public String getText()
	{
		return this.text;
	}
	public void setText(String text) 
	{
		this.text = text;
	}
	
	@Override
	public String toString() 
	{
		String txt = this.text;
		
		return txt;
	}
}