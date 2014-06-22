package com.example.listviewsorte;

import android.app.Application;

public class parentApp extends Application 
{
	public static boolean isTablet;
	public static databaseHelper dbHelper;
	
	@Override
	public void onCreate() 
	{
		super.onCreate();
		if(trackingLogActivity.IsTablet(getBaseContext()))
			isTablet = true;
		else
			isTablet = false;
		
		dbHelper = new databaseHelper(getBaseContext());
	}
}
