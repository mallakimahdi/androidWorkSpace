package com.example.listviewsorte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Random;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity 
{
	ListView lst;
	ArrayList<struct> arrays;
	private Random random;
	private TextView columnId;
	private TextView columnCalender;
	private Adapter adapter;
	private boolean isSortedById = true;
    private boolean isSortedByDate = false;
    private ImageView imageSortId, imageSortDate;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        random = new Random();
        arrays = new ArrayList<struct>();
        columnId = (TextView) findViewById(R.id.columnId);
        columnCalender = (TextView) findViewById(R.id.columnCalender);
        imageSortId = (ImageView) findViewById(R.id.imageSortId);
        imageSortDate = (ImageView) findViewById(R.id.imageSortCalender);
        
        for(int i=0 ; i<10000 ; i++)
        {
        	struct stru = new struct();
        	
        	stru.setId(i);
        	stru.setVisitLat((int) (random.nextDouble()*1000));
        	stru.setVisitLong((int) (random.nextDouble()*1000));
        	stru.setSend(random.nextBoolean() ? 1 : 0);
        	stru.setMasfa(random.nextBoolean());
        	
        	GregorianCalendar gc = new GregorianCalendar();
        	
        	gc.set(gc.YEAR, randBetween(2003, 2014));
        	gc.set(gc.DAY_OF_YEAR, randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR)));
            
        	stru.setGc(gc);
        	
        	arrays.add(stru);
        }
        
        adapter = new Adapter(this, arrays);
        
        lst = (ListView) findViewById(R.id.lst);
        lst.setAdapter(adapter);
        
        imageSortId.setBackgroundResource(R.drawable.navigateup);
        
        columnId.setOnClickListener(clickColumnId);
        columnCalender.setOnClickListener(clickColumnCalender);
    }   
    
    OnClickListener clickColumnId = new OnClickListener() 
    {
		@Override
		public void onClick(View arg0) 
		{
			if(isSortedById)
			{
				Collections.sort(arrays, new Compare("Id"));
				Collections.reverse(arrays);
				isSortedById = false;
				isSortedByDate = false;
				imageSortId.setVisibility(View.VISIBLE);
				imageSortDate.setVisibility(View.INVISIBLE);
				imageSortId.setBackgroundResource(R.drawable.navigatedown);
			}
			else
			{
				Collections.sort(arrays, new Compare("Id"));
				isSortedById = true;
				isSortedByDate = false;
				imageSortId.setVisibility(View.VISIBLE);
				imageSortDate.setVisibility(View.INVISIBLE);
				imageSortId.setBackgroundResource(R.drawable.navigateup);
			}
			
			adapter.notifyDataSetChanged();
		}
	};
	
	OnClickListener clickColumnCalender = new OnClickListener() 
	{
		@Override
		public void onClick(View v) 
		{
			if(isSortedByDate)
			{
				Collections.sort(arrays, new Compare("date"));
				Collections.reverse(arrays);
				imageSortDate.setVisibility(View.VISIBLE);
				imageSortDate.setBackgroundResource(R.drawable.navigatedown);
				imageSortId.setVisibility(View.INVISIBLE);
				isSortedByDate = false;
				isSortedById = false;
			}
			else
			{
				Collections.sort(arrays, new Compare("date"));
				imageSortDate.setVisibility(View.VISIBLE);
				imageSortDate.setBackgroundResource(R.drawable.navigateup);
				imageSortId.setVisibility(View.INVISIBLE);
				isSortedByDate = true;
				isSortedById = false;
			}
			
			adapter.notifyDataSetChanged();
		}
	};
	
	private int randBetween(int start, int end) 
	{
        return start + (int)Math.round(Math.random() * (end - start));
    }
}
