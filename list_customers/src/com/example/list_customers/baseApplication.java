package com.example.list_customers;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

public class baseApplication extends Application 
{
	public static boolean isTablet;
	
	@Override
	public void onCreate() 
	{
		super.onCreate();
		
		isTablet = IsTablet(getApplicationContext());
	}
	
	private boolean IsTablet(Context context)
	{
		return (context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
		        >= Configuration.SCREENLAYOUT_SIZE_LARGE;
	}
}
