package com.example.frg2;

import java.util.ArrayList;
import java.util.Collections;
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
import android.widget.TextView;

public class MainActivity extends Activity 
{
	ListView lst;
	Button btnBack ,btnNext;
	adapter2 adapter;
	ArrayList<struct2> arrays;
	private static ListIterator<LinkedList<Integer>> listiterator;
	Map<Integer, Integer> detailsOfColumn;
	int currectPage;
	TextView topTxtId, TopTxtName;
	private boolean[] clickSort;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnBack = (Button) findViewById(R.id.btnBack);
		btnNext = (Button) findViewById(R.id.btnNext);
		lst = (ListView) findViewById(R.id.lst);
		topTxtId = (TextView) findViewById(R.id.topTxtId);
		TopTxtName = (TextView) findViewById(R.id.topTxtName);
		
		arrays = new ArrayList<struct2>();
		for(int i = 0; i<100 ; i++)
		{
			struct2 stru = new struct2();
			stru.setId(i);
			stru.setName("name"+i);
			stru.setFamily("family"+i);
			stru.setAddress("address"+i);
			stru.setTell(i*30+12);
			
			arrays.add(stru);
		}
		
		detailsOfColumn = new HashMap<Integer, Integer>();
		detailsOfColumn.put(0, 80);
		detailsOfColumn.put(1, 210);
		detailsOfColumn.put(2, 230);
		detailsOfColumn.put(3, 200);
		detailsOfColumn.put(4, 250);
		clickSort = new boolean[5];
		clickSort[0] = true;
		
		int sumOfAllColumns = 0;
		for(int i=0 ; i< detailsOfColumn.size() ; i++)
		{
			sumOfAllColumns += detailsOfColumn.get(i);
		}
		
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		
		LinkedList<LinkedList<Integer>> queeParent = new LinkedList<LinkedList<Integer>>();
		int counter = 0;
		int sumParent = 0;
		while(sumParent < sumOfAllColumns)
		{
			int sumChild = 0;
			LinkedList<Integer> queeChild = new LinkedList<Integer>();
			while(sumChild < 500)  //metrics.widthPixels
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
		
		listiterator = queeParent.listIterator();
		
		if(listiterator.hasNext())
		{
			LinkedList<Integer> obj = listiterator.next();
			Object[] arr = obj.toArray();
			int[] arrToAdapter = new int[arr.length];
			
			for(int i=0 ; i<arr.length ; i++)
			{
				arrToAdapter[i] = getIndexOfValue((Integer) arr[i], detailsOfColumn);
			}
			
			adapter = new adapter2(this, arrays, arrToAdapter);
			lst.setAdapter(adapter);
		}
		
		btnNext.setOnClickListener(clickNext);
		btnBack.setOnClickListener(clickBack);
		topTxtId.setOnClickListener(clickTopTxtId);
		TopTxtName.setOnClickListener(clickTopTxtName);
	}

	OnClickListener clickNext = new OnClickListener() 
	{
		@Override
		public void onClick(View v) 
		{
			if(listiterator.hasNext())
			{
				LinkedList<Integer> obj = listiterator.next();
				Object[] arr = obj.toArray();
				int[] arrToAdapter = new int[arr.length];
				
				for(int i=0 ; i<arr.length ; i++)
				{
					arrToAdapter[i] = getIndexOfValue((Integer) arr[i], detailsOfColumn);
				}
				
				adapter = new adapter2(MainActivity.this, arrays, arrToAdapter);
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
				LinkedList<Integer> obj = listiterator.previous();
				Object[] arr = obj.toArray();
				int[] arrToAdapter = new int[arr.length];
				
				for(int i=0 ; i<arr.length ; i++)
				{
					arrToAdapter[i] = getIndexOfValue((Integer) arr[i], detailsOfColumn);
				}
				
				adapter = new adapter2(MainActivity.this, arrays, arrToAdapter);
				lst.setAdapter(adapter);
			}
			
		}
	};
	
	OnClickListener clickTopTxtId = new OnClickListener() 
	{
		@Override
		public void onClick(View v) 
		{
			if(clickSort[0])
			{
				Collections.sort(arrays, new Compare("Id"));
				Collections.reverse(arrays);
				
				clickSort[0] = false;
			}
			else
			{
				Collections.sort(arrays, new Compare("Id"));
				clickSort[0] = true;
			}
			
			adapter.notifyDataSetChanged();
		}
	};
	
	OnClickListener clickTopTxtName = new OnClickListener() 
	{
		@Override
		public void onClick(View v) 
		{
			if(clickSort[0])
			{
				Collections.sort(arrays, new Compare("Name"));
				Collections.reverse(arrays);
				
				clickSort[0] = false;
			}
			else
			{
				Collections.sort(arrays, new Compare("Name"));
				clickSort[0] = true;
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
