package com.example.listviewsorte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Random;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity 
{
	ListView lst;
	ArrayList<struct> arrays;
	private Random random;
	private TextView columnId;
	private TextView columnIsSend;
	private TextView columnVisitLat;
	private Adapter adapter;
	private boolean[] clickedSort;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        random = new Random();
        arrays = new ArrayList<struct>();
        columnId = (TextView) findViewById(R.id.columnId);
        columnIsSend = (TextView) findViewById(R.id.columnisSend);
        columnVisitLat = (TextView) findViewById(R.id.columnVisitLat);
        
        clickedSort = new boolean[10];
        clickedSort[0] = true;
        
        for(int i=0 ; i<100 ; i++)
        {
        	struct stru = new struct();
        	
        	stru.setId(i);
        	stru.setVisitLat((int) (random.nextDouble()*1000));
        	stru.setVisitLong((int) (random.nextDouble()*1000));
        	stru.setSend(random.nextBoolean() ? 1 : 0);
        	stru.setMasfa(random.nextBoolean());
        	
        	arrays.add(stru);
        }
        
        adapter = new Adapter(this, arrays);
        
        lst = (ListView) findViewById(R.id.lst);
        lst.setAdapter(adapter);
        
        columnId.setOnClickListener(clickColumnId);
        columnIsSend.setOnClickListener(clickColumnIsSend);
        columnVisitLat.setOnClickListener(clickColumnVisitLat);
    }   
    
    OnClickListener clickColumnId = new OnClickListener() 
    {
		@Override
		public void onClick(View arg0) 
		{
			if(clickedSort[0])
			{
				Collections.sort(arrays, new Compare("Id"));
				Collections.reverse(arrays);
				Arrays.fill(clickedSort, false);
				clickedSort[0] = false;
			}
			else
			{
				Collections.sort(arrays, new Compare("Id"));
				clickedSort[0] = true;
			}
			
			adapter.notifyDataSetChanged();
		}
	};
	
	OnClickListener clickColumnVisitLat = new OnClickListener() 
	{
		@Override
		public void onClick(View arg0) 
		{
			if(clickedSort[1])
			{
				
			}
			else
			{
				
			}
		}
	};
	
	OnClickListener clickColumnIsSend = new OnClickListener() 
	{
		@Override
		public void onClick(View arg0) 
		{
			if(clickedSort[3])
			{
				Collections.sort(arrays, new Compare("IsSend"));
				Collections.reverse(arrays);
				Arrays.fill(clickedSort, false);
				clickedSort[3] = true;
			}
			else
			{
				Collections.sort(arrays, new Compare("IsSend"));
				Arrays.fill(clickedSort, false);
				clickedSort[3] = true;
			}
			
			adapter.notifyDataSetChanged();
		}
	};
}
