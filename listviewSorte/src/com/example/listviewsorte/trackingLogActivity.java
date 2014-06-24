package com.example.listviewsorte;

import fragmets.fragmentTrackingLog;
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
    private fragmentTrackingLog lfm;
	
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
       
        FragmentManager fm = getFragmentManager();
        if(fm.findFragmentById(R.id.listFragment) == null)
        {
        	lfm = new fragmentTrackingLog();
        	fm.beginTransaction().add(R.id.listFragment, lfm).commit();
        }
        
        imageSortId.setBackgroundResource(R.drawable.navigateup);
        columnId.setOnClickListener(clickColumnId);
        columnCalender.setOnClickListener(clickColumnCalender);
        
        if(!G.isTablet)
        	linearRoot.setVisibility(View.GONE);
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
				
				lfm.cursor = G.dbHelper.sortById(false);
				lfm.adapter.swapCursor(lfm.cursor);
			}
			else
			{
				isSortedById = true;
				isSortedByDate = false;
				imageSortId.setVisibility(View.VISIBLE);
				imageSortDate.setVisibility(View.INVISIBLE);
				imageSortId.setBackgroundResource(R.drawable.navigateup);
				
				lfm.cursor = G.dbHelper.sortById(true);
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
				
				lfm.cursor = G.dbHelper.sortByDate(false);
				lfm.adapter.swapCursor(lfm.cursor);
			}
			else
			{
				imageSortDate.setVisibility(View.VISIBLE);
				imageSortDate.setBackgroundResource(R.drawable.navigateup);
				imageSortId.setVisibility(View.INVISIBLE);
				isSortedByDate = true;
				isSortedById = false;
				
				lfm.cursor = G.dbHelper.sortByDate(true);
				lfm.adapter.swapCursor(lfm.cursor);
			}
			
			lfm.adapter.notifyDataSetChanged();
		}
	};
	
}
