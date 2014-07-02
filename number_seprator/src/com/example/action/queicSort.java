package com.example.action;

import java.util.Random;

public class queicSort 
{
	private Random random;
	
	public queicSort() 
	{
		random = new Random();
	}
	
	public int[] quickSort(int[] A, int p, int r)
	{
		if(p<r)
		{
			int q = partition(A, p, r);
			quickSort(A, p, q-1);
			quickSort(A, q+1, r);
		}
		
		return A;
	}
	
	private int partition(int[] A, int p, int r)
	{
		int x = A[r];
		
		int i = p - 1;
		for(int j=p ; j < r-1 ; j++)
		{
			if(A[j] <= x)
			{
				i++;
				xChange(A,i,j);
			}
		}
		xChange(A, i+1, r);
		
		return i+1;
	}
	
	private void xChange(int A[],int i,int j)
	{
		int value = A[i];
		A[i] = A[j];
		A[j] = value;
	}
}
