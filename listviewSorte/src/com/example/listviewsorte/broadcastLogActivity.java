package com.example.listviewsorte;

import fragmets.fragmentBroadcastList;
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

public class broadcastLogActivity extends Activity 
{
	private LinearLayout linearRootBroadcastLog;
	private fragmentBroadcastList fragment;
	TextView txtColumnId;
	TextView txtColumnDate;
	ImageView imageSortId, imageSortDate;
	boolean isSortedById = true;
	boolean isSortByDate = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_broadcast_log);
		
		txtColumnId = (TextView) findViewById(R.id.txtIdBroadcastLog);
		txtColumnDate = (TextView) findViewById(R.id.txtDateBroadcastLog);
		imageSortId = (ImageView) findViewById(R.id.imageSortIdBroadcastLog);
		imageSortDate = (ImageView) findViewById(R.id.imageSortDateBroadcastLog);
		
		linearRootBroadcastLog = (LinearLayout) findViewById(R.id.LinearRootBroadcastLog);
		
		if(IsTablet(this))
        	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); 
        else
        {
        	linearRootBroadcastLog.setVisibility(View.GONE);
        	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); 
        }
		
		FragmentManager fm = getFragmentManager();
		if(fm.findFragmentById(R.id.fragmentBroadCast) == null)
		{
			fragment = new fragmentBroadcastList();
			fm.beginTransaction().add(R.id.fragmentBroadCast, fragment).commit();
		}
		
		imageSortId.setBackgroundResource(R.drawable.navigateup);
		txtColumnId.setOnClickListener(clickIdToSort);
		txtColumnDate.setOnClickListener(clickDateToSort);
	}
	
	public static boolean IsTablet(Context context)
	{
		return (context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
		        >= Configuration.SCREENLAYOUT_SIZE_LARGE;
	}
	
	OnClickListener clickIdToSort = new OnClickListener() 
	{
		@Override
		public void onClick(View v) 
		{
			if(isSortedById)
			{
				isSortedById = false;
				isSortByDate = false;
				imageSortId.setVisibility(View.VISIBLE);
				imageSortDate.setVisibility(View.INVISIBLE);
				imageSortId.setBackgroundResource(R.drawable.navigatedown);
				
				fragment.cursor = G.dbHelperBroadcastLog.sortById(false);
				fragment.adapter.swapCursor(fragment.cursor);
			}
			else
			{
				isSortedById = true;
				isSortByDate = false;
				imageSortId.setVisibility(View.VISIBLE);
				imageSortDate.setVisibility(View.INVISIBLE);
				imageSortId.setBackgroundResource(R.drawable.navigateup);
				
				fragment.cursor = G.dbHelperBroadcastLog.sortById(true);
				fragment.adapter.swapCursor(fragment.cursor);
			}
		}
	};
	
	OnClickListener clickDateToSort = new OnClickListener() 
	{
		@Override
		public void onClick(View v) 
		{
			if(isSortByDate)
			{
				imageSortDate.setVisibility(View.VISIBLE);
				imageSortDate.setBackgroundResource(R.drawable.navigatedown);
				imageSortId.setVisibility(View.INVISIBLE);
				isSortByDate = false;
				isSortedById = false;
				
				fragment.cursor = G.dbHelperBroadcastLog.sortByDate(false);
				fragment.adapter.swapCursor(fragment.cursor);
			}
			else
			{
				imageSortDate.setVisibility(View.VISIBLE);
				imageSortDate.setBackgroundResource(R.drawable.navigateup);
				imageSortId.setVisibility(View.INVISIBLE);
				isSortByDate = true;
				isSortedById = false;
				
				fragment.cursor = G.dbHelperBroadcastLog.sortByDate(true);
				fragment.adapter.swapCursor(fragment.cursor);
			}
		}
	};
}
