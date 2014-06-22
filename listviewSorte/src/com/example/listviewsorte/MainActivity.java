package com.example.listviewsorte;

import java.util.Collections;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity 
{
	Button btnBroadcastLog, btnTrackingLog;
	
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
	}
}
