package Sorter;

import java.util.ArrayList;
import java.util.Collections;

public class sorter<T> 
{
	private ArrayList<T> arrays;
	private boolean AssendOrDessend = true;
	private String nameOfColumn;
	
	public sorter(ArrayList<T> arrays, String nameOfColumn) 
	{
		this.arrays = arrays;
		this.nameOfColumn = nameOfColumn;
	}
	
	public sorter(ArrayList<T> arrays, boolean AssendOrDessend , String nameOfColumn) 
	{
		this.arrays = arrays;
		this.AssendOrDessend = AssendOrDessend;
		this.nameOfColumn = nameOfColumn;
	}
	
	public ArrayList<T> sort()
	{
		//Collections.sort(arrays, comparator);
		
		return arrays;
	}
}
