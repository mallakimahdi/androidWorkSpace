package com.example.listviewsorte;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class broadcastLogActivity extends Activity 
{
	private LinearLayout linearRootBroadcastLog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_broadcast_log);
		
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
			
		}
	}
	
	public static boolean IsTablet(Context context)
	{
		return (context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
		        >= Configuration.SCREENLAYOUT_SIZE_LARGE;
	}
}
