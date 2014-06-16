package com.example.litt;

import com.littlefluffytoys.littlefluffylocationlibrary.LocationLibrary;

import android.app.Application;

public class app extends Application 
{
	@Override
	public void onCreate() 
	{
		super.onCreate();
		LocationLibrary.initialiseLibrary(getBaseContext(),1 * 60 *1000, 1000 ,"com.example.litt");
	}
}