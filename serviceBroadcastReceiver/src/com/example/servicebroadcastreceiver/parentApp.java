package com.example.servicebroadcastreceiver;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

public class parentApp extends Application 
{
	public static final Handler handler = new Handler();
	public static Context context;
	
	@Override
	public void onCreate() 
	{
		super.onCreate();
		context = getApplicationContext();
	}
}
