package com.example.servicebroadcastreceiver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class Service2 extends Service 
{
	@Override
	public IBinder onBind(Intent intent) 
	{
		return null;
	}
	
	@Override
	public void onCreate() 
	{
		super.onCreate();
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) 
	{
		Toast.makeText(getBaseContext(), "service 2 started", Toast.LENGTH_SHORT).show();
		return super.onStartCommand(intent, flags, startId);
	}
	
	@Override
	public void onDestroy() 
	{
		super.onDestroy();
		Toast.makeText(getBaseContext(), "service 2 destroyed", Toast.LENGTH_SHORT).show();
	}
	
}
