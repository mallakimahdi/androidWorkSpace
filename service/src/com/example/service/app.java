package com.example.service;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.widget.TextView;
import org.acra.*;
import org.acra.annotation.*;

@ReportsCrashes(
				formKey = "",
				formUri = "http://192.168.0.39/mysite/crash_reporter2.php",
				httpMethod = org.acra.sender.HttpSender.Method.POST,
				mode = ReportingInteractionMode.TOAST,
				resToastText = R.string.hello_world
				)


public class app extends Application 
{
	public static final Handler handler = new Handler();
	public static Context context;
	
	@Override
	public void onCreate() 
	{
		ACRA.init(this);
		
		super.onCreate();
		context = getApplicationContext();
		
		TextView txt = null;
		txt.setText("hello");
	}
}
