package com.example.listviewsorte;

import databases.dbHelperTrackingLog;
import databases.dbhelperBroadcastLog;
import android.app.Application;
import android.content.Context;

public class G extends Application 
{
	public static boolean isTablet;
	public static dbHelperTrackingLog dbHelper;
	public static dbhelperBroadcastLog dbHelperBroadcastLog;
	public static Context mContext;
	
	@Override
	public void onCreate() 
	{
		super.onCreate();
		if(MainActivity.IsTablet(getBaseContext()))
			isTablet = true;
		else
			isTablet = false;
		
		dbHelper = new dbHelperTrackingLog(getBaseContext());
		dbHelperBroadcastLog = new dbhelperBroadcastLog(getBaseContext());
		mContext = getBaseContext();
	}
}
