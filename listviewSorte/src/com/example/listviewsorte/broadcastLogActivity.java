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
	private TextView txtColumnId;
	private TextView txtColumnDate;
	private ImageView imageSortId, imageSortDate;
	private boolean isSortedById = true;
	private boolean isSortByDate = false;
	private FragmentManager fm;
	private Context mContext;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_broadcast_log);
		
		txtColumnId = (TextView) findViewById(R.id.txtIdBroadcastLog);
		txtColumnDate = (TextView) findViewById(R.id.txtDateBroadcastLog);
		imageSortId = (ImageView) findViewById(R.id.imageSortIdBroadcastLog);
		imageSortDate = (ImageView) findViewById(R.id.imageSortDateBroadcastLog);
		mContext = this;
		
		linearRootBroadcastLog = (LinearLayout) findViewById(R.id.LinearRootBroadcastLog);
		
		if(baseApplication.isTablet)
        	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); 
        else
        {
        	linearRootBroadcastLog.setVisibility(View.GONE);
        	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); 
        }
		
		fm = getFragmentManager();
		if(fm.findFragmentById(R.id.fragmentBroadCast) == null)
		{
			this.fragment = new fragmentBroadcastList();
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
				
				fragment = (fragmentBroadcastList) fm.findFragmentById(R.id.fragmentBroadCast);
				
				fragment.cursor = getObjects.getHelperDBBroadcastlog(mContext).sortById(false);
				fragment.adapter.swapCursor(fragment.cursor);
			}
			else
			{
				isSortedById = true;
				isSortByDate = false;
				imageSortId.setVisibility(View.VISIBLE);
				imageSortDate.setVisibility(View.INVISIBLE);
				imageSortId.setBackgroundResource(R.drawable.navigateup);
				
				fragment.cursor = getObjects.getHelperDBBroadcastlog(mContext).sortById(true);
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
				
				fragment.cursor = getObjects.getHelperDBBroadcastlog(mContext).sortByDate(false);
				fragment.adapter.swapCursor(fragment.cursor);
			}
			else
			{
				imageSortDate.setVisibility(View.VISIBLE);
				imageSortDate.setBackgroundResource(R.drawable.navigateup);
				imageSortId.setVisibility(View.INVISIBLE);
				isSortByDate = true;
				isSortedById = false;
				
				fragment = (fragmentBroadcastList) fm.findFragmentById(R.id.fragmentBroadCast);
				
				fragment.cursor = getObjects.getHelperDBBroadcastlog(mContext).sortByDate(true);
				fragment.adapter.swapCursor(fragment.cursor);
			}
		}
	};
}
