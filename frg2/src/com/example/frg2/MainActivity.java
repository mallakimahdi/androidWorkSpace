package com.example.frg2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.PriorityQueue;

import android.R.integer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

public class MainActivity extends Activity 
{
	ListView lst;
	Button btnBack ,btnNext;
	adapter2 adapter;
	ArrayList<struct2> arrays;
	ListIterator<PriorityQueue<Integer>> listiterator;
	Map<Integer, Integer> detailsOfColumn;
	int currectPage;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnBack = (Button) findViewById(R.id.btnBack);
		btnNext = (Button) findViewById(R.id.btnNext);
		
		arrays = new ArrayList<struct2>();
		for(int i = 0; i<100 ; i++)
		{
			struct2 stru = new struct2();
			stru.setId(i);
			stru.setName("name"+i);
			
			arrays.add(stru);
		}
		
		detailsOfColumn = new HashMap<Integer, Integer>();
		detailsOfColumn.put(0, 50);
		detailsOfColumn.put(1, 100);
		/*
		detailsOfColumn.put(2, 40);
		detailsOfColumn.put(3, 80);
		detailsOfColumn.put(4, 55);
		*/
		
		int sumOfAllColumns = 0;
		for(int i=0 ; i< detailsOfColumn.size() ; i++)
		{
			sumOfAllColumns += detailsOfColumn.get(i);
		}
		
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		//float widthInches = metrics.widthPixels / metrics.xdpi;
		
		LinkedList<PriorityQueue<Integer>> queeParent = new LinkedList<PriorityQueue<Integer>>();
		int counter = 0;
		int sumParent = 0;
		while(sumParent < sumOfAllColumns)
		{
			int sumChild = 0;
			PriorityQueue<Integer> queeChild = new PriorityQueue<Integer>();
			while(sumChild < metrics.widthPixels)
			{
				if(counter < detailsOfColumn.size())
				{
					queeChild.add(detailsOfColumn.get(counter));
					sumChild += detailsOfColumn.get(counter);
					counter++;
				}
				else
				{
					break;
				}
			}
			sumParent += sumChild;
			queeParent.add(queeChild);
		}
		
		ListIterator<PriorityQueue<Integer>> listiterator = queeParent.listIterator();
		
		if(listiterator.hasNext())
		{
			PriorityQueue<Integer> obj = listiterator.next();
			Object[] arr = obj.toArray();
			int[] arrToAdapter = new int[arr.length];
			
			for(int i=0 ; i<arr.length ; i++)
			{
				arrToAdapter[i] = getIndexOfValue((Integer) arr[i], detailsOfColumn);
			}
			
			adapter = new adapter2(this, arrays, arrToAdapter);
			lst = (ListView) findViewById(R.id.lst);
			lst.setAdapter(adapter);
		}
		
		btnBack.setOnClickListener(clickBack);
		btnNext.setOnClickListener(clickNext);
	}

	OnClickListener clickNext = new OnClickListener() 
	{
		@Override
		public void onClick(View v) 
		{
			
			if(listiterator.hasNext())
			{
				PriorityQueue<Integer> obj = listiterator.next();
				Object[] arr = obj.toArray();
				int[] arrToAdapter = new int[arr.length];
				
				for(int i=0 ; i<arr.length ; i++)
				{
					arrToAdapter[i] = getIndexOfValue((Integer) arr[i], detailsOfColumn);
				}
				
				adapter = new adapter2(MainActivity.this, arrays, arrToAdapter);
				lst = (ListView) findViewById(R.id.lst);
				lst.setAdapter(adapter);
			}
			
		}
	};
	
	OnClickListener clickBack = new OnClickListener() 
	{
		@Override
		public void onClick(View v) 
		{
			if(listiterator.hasPrevious())
			{
				PriorityQueue<Integer> obj = listiterator.previous();
				Object[] arr = obj.toArray();
				int[] arrToAdapter = new int[arr.length];
				
				for(int i=0 ; i<arr.length ; i++)
				{
					arrToAdapter[i] = getIndexOfValue((Integer) arr[i], detailsOfColumn);
				}
				
				adapter = new adapter2(MainActivity.this, arrays, arrToAdapter);
				lst = (ListView) findViewById(R.id.lst);
				lst.setAdapter(adapter);
			}
			
		}
	};
	
	private int getIndexOfValue(int value , Map<Integer, Integer> detailsOfColumn)
	{
		for(int i=0 ; i<detailsOfColumn.size() ; i++)
		{
			if(detailsOfColumn.get(i).equals(value))
			{
				return i;
			}
		}
		
		return -1;
	}
}
