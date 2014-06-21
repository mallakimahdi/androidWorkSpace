package com.example.listviewsorte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Random;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
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
       
        if(IsTablet(this))
        {
        	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); 
        }
        else
        {
        	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); 
        }
        
        FragmentManager fm = getFragmentManager();
        if(fm.findFragmentById(android.R.id.content) == null)
        {
        	myFragment list = new myFragment();
        	fm.beginTransaction().add(android.R.id.content, list).commit();
        }
        
        /*
        imageSortId.setBackgroundResource(R.drawable.navigateup);
        columnId.setOnClickListener(clickColumnId);
        columnCalender.setOnClickListener(clickColumnCalender);
        */
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
	
	private static boolean IsTablet(Context context)
	{
		return (context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
		        >= Configuration.SCREENLAYOUT_SIZE_LARGE;
	}
}
