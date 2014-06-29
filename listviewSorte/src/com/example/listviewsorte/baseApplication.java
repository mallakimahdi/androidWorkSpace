package com.example.listviewsorte;

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
		
		if(MainActivity.IsTablet(getApplicationContext()))
			isTablet = true;
		else
			isTablet = false;
	}
	
	public static boolean IsTablet(Context context)
	{
		return (context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
		        >= Configuration.SCREENLAYOUT_SIZE_LARGE;
	}
}
