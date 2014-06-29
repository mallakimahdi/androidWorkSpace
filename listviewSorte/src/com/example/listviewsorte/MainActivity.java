package com.example.listviewsorte;

import android.view.View.OnClickListener;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity 
{
	private Button btnBroadcastLog, btnTrackingLog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnBroadcastLog = (Button) findViewById(R.id.btnBroadcastLog);
		btnTrackingLog = (Button) findViewById(R.id.btnTrackingLog);
		
		btnBroadcastLog.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				Intent i = new Intent(MainActivity.this, broadcastLogActivity.class);
				startActivity(i);
			}
		});
		
		btnTrackingLog.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				Intent i = new Intent(MainActivity.this, trackingLogActivity.class);
				startActivity(i);
			}
		});
		
		if(IsTablet(this))
        	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); 
        else
        	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
	}
	
	public static boolean IsTablet(Context context)
	{
		return (context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
		        >= Configuration.SCREENLAYOUT_SIZE_LARGE;
	}
}
