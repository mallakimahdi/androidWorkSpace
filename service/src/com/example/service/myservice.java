package com.example.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class myservice extends Service 
{
	int counter = 0;
	
	@Override
	public void onCreate() 
	{
		super.onCreate();
		
		new Thread(null, run, "thread service").start();
		
		Notification notification = new Notification(R.drawable.ic_launcher, "myapp", System.currentTimeMillis());
		Intent notificationIntent = new Intent(this, MainActivity.class);
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
		notification.setLatestEventInfo(this, "service", "service is running" ,pendingIntent);
		
		startForeground(5481, notification);
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) 
	{
		return START_STICKY;
	}

	@Override
	public IBinder onBind(Intent arg0) 
	{
		return null;
	}
	
	
	Runnable run = new Runnable() 
	{
		@Override
		public void run() 
		{
			while(true)
			{
				app.handler.post(new Runnable() 
				{
					@Override
					public void run() 
					{
						Toast.makeText(app.context, ++counter +"", Toast.LENGTH_SHORT).show();
					}
				});
				
				try 
				{
					Thread.sleep(3000);
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
		}
	};
}
