package com.example.listviewsorte;

import fragmets.fragmentTrackingLog;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.pm.ActivityInfo;
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
    private fragmentTrackingLog fragment;
    private FragmentManager fm;
    private Context mContext;
	
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
        this.mContext = this;
       
        fm = getFragmentManager();
        if(fm.findFragmentById(R.id.fragmentTrackingLog) == null)
        {
        	fragment = new fragmentTrackingLog();
        	fm.beginTransaction().add(R.id.fragmentTrackingLog, fragment).commit();
        }
        
        imageSortId.setBackgroundResource(R.drawable.navigateup);
        columnId.setOnClickListener(clickColumnId);
        columnCalender.setOnClickListener(clickColumnCalender);
        
        if(baseApplication.isTablet)
        	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        else
        {
        	linearRoot.setVisibility(View.GONE);
        	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
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
				
				fragment = (fragmentTrackingLog) fm.findFragmentById(R.id.fragmentTrackingLog);
				
				fragment.cursor = getObjects.getHelperDBTrakingLog(mContext).sortById(false);
				fragment.adapter.swapCursor(fragment.cursor);
			}
			else
			{
				isSortedById = true;
				isSortedByDate = false;
				imageSortId.setVisibility(View.VISIBLE);
				imageSortDate.setVisibility(View.INVISIBLE);
				imageSortId.setBackgroundResource(R.drawable.navigateup);
				
				fragment.cursor = getObjects.getHelperDBTrakingLog(mContext).sortById(true);
				fragment.adapter.swapCursor(fragment.cursor);
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
				
				fragment.cursor = getObjects.getHelperDBTrakingLog(mContext).sortByDate(false);
				fragment.adapter.swapCursor(fragment.cursor);
			}
			else
			{
				imageSortDate.setVisibility(View.VISIBLE);
				imageSortDate.setBackgroundResource(R.drawable.navigateup);
				imageSortId.setVisibility(View.INVISIBLE);
				isSortedByDate = true;
				isSortedById = false;
				
				fragment = (fragmentTrackingLog) fm.findFragmentById(R.id.fragmentTrackingLog);
				
				fragment.cursor = getObjects.getHelperDBTrakingLog(mContext).sortByDate(true);
				fragment.adapter.swapCursor(fragment.cursor);
			}
			
			fragment.adapter.notifyDataSetChanged();
		}
	};
	
}
