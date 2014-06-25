package com.example.dialog;

import android.app.Activity;
import android.app.Application;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;

public class G extends Application 
{
	@Override
	public void onCreate() 
	{
		
	};
	
	public static boolean isTablet(Activity activity)
	{
		
		if((activity.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
		        >= Configuration.SCREENLAYOUT_SIZE_LARGE)
		{
        	activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        	return true;
		}
        else
        	activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		return false;
	}
}
