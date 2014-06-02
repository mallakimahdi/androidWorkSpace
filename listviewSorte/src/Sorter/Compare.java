package Sorter;

import java.util.Comparator;

public class Compare<T extends Comparable<T>> implements Comparator<T>
{
	String compare;
	
	public Compare(String compare) 
	{
		this.compare = compare;
	}

	@Override
	public int compare(T lhs, T rhs) 
	{
		lhs.compareTo(rhs);
		return 0;
	}
}
