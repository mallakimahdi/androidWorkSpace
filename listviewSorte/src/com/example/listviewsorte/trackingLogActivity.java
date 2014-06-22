package com.example.listviewsorte;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class trackingLogActivity extends Activity 
{
	private TextView columnId;
	private TextView columnCalender;
	private boolean isSortedById = true;
    private boolean isSortedByDate = false;
    private ImageView imageSortId, imageSortDate;
    private LinearLayout linearRoot;
    private myFragment lfm;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_trackinglog);
        
        columnId = (TextView) findViewById(R.id.columnId);
        columnCalender = (TextView) findViewById(R.id.columnCalender);
        imageSortId = (ImageView) findViewById(R.id.imageSortId);
        imageSortDate = (ImageView) findViewById(R.id.imageSortCalender);
        linearRoot = (LinearLayout) findViewById(R.id.LinearRoot);
       
        if(IsTablet(this))
        {
        	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); 
        }
        else
        {
        	linearRoot.setVisibility(View.GONE);
        	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); 
        }
        
        
        FragmentManager fm = getFragmentManager();
        if(fm.findFragmentById(R.id.listFragment) == null)
        {
        	lfm = new myFragment();
        	fm.beginTransaction().add(R.id.listFragment, lfm).commit();
        }
        
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
				isSortedById = false;
				isSortedByDate = false;
				imageSortId.setVisibility(View.VISIBLE);
				imageSortDate.setVisibility(View.INVISIBLE);
				imageSortId.setBackgroundResource(R.drawable.navigatedown);
				
				lfm.cursor = parentApp.dbHelper.sortById(true);
				lfm.adapter.swapCursor(lfm.cursor);
			}
			else
			{
				isSortedById = true;
				isSortedByDate = false;
				imageSortId.setVisibility(View.VISIBLE);
				imageSortDate.setVisibility(View.INVISIBLE);
				imageSortId.setBackgroundResource(R.drawable.navigateup);
				
				lfm.cursor = parentApp.dbHelper.sortById(false);
				lfm.adapter.swapCursor(lfm.cursor);
			}
		}
	};
	
	OnClickListener clickColumnCalender = new OnClickListener() 
	{
		@Override
		public void onClick(View v) 
		{
			if(isSortedByDate)
			{
				imageSortDate.setVisibility(View.VISIBLE);
				imageSortDate.setBackgroundResource(R.drawable.navigatedown);
				imageSortId.setVisibility(View.INVISIBLE);
				isSortedByDate = false;
				isSortedById = false;
			}
			else
			{
				imageSortDate.setVisibility(View.VISIBLE);
				imageSortDate.setBackgroundResource(R.drawable.navigateup);
				imageSortId.setVisibility(View.INVISIBLE);
				isSortedByDate = true;
				isSortedById = false;
			}
			
			lfm.adapter.notifyDataSetChanged();
		}
	};
	
	public static boolean IsTablet(Context context)
	{
		return (context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
		        >= Configuration.SCREENLAYOUT_SIZE_LARGE;
	}
}
